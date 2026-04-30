package edu.sandiego.comp305;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

    private static final int COLUMS_OF_FILE = 9;

    private final String filePath;


    public CSVLoader(final String filePath) {
        this.filePath = filePath;
    }

    public List<Team> loadTeams() {
        final List<Team> teams = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                final Team team = parseLine(line);
                if (team != null) {
                    teams.add(team);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return teams;
    }

    private Team parseLine(final String line) {
        try {
            final String[] parts = line.split(",");
            if (parts.length < COLUMS_OF_FILE) {
                System.out.println("Warning: skipping bad row: " + line);
                return null;
            }

            return new Team(
                Integer.parseInt(parts[0].trim()), 
                parts[1].trim(), parts[2].trim(),
                Integer.parseInt(parts[3].trim()),
                Integer.parseInt(parts[4].trim()),
                Integer.parseInt(parts[5].trim()),
                Integer.parseInt(parts[6].trim()),
                Integer.parseInt(parts[7].trim()),
                Integer.parseInt(parts[8].trim()));
        } catch (NumberFormatException e) {
            System.out.println("Warning: skipping valid row: " + line);
            return null;
        }
    }
}

