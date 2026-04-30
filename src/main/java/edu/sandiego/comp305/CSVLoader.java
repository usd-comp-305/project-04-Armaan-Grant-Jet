package edu.sandiego.comp305;

import java.util.List;

public class CSVLoader {

    private static final int COLUMS_OF_FILE = 9;

    private final String filePath;


    public CSVLoader(final String filePath) {
        this.filePath = filePath;
    }

    public List<Team> loadTeams() {
        return null;
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

