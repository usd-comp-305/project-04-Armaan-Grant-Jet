package edu.sandiego.comp305;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.List;

import java.io.IOException;

import java.util.ArrayList;

public class CSVLoader {

    private final String filePath;

    public CSVLoader(final String filePath) {
        this.filePath = filePath;
    }

    public List<Team> loadTeams() {
        final List<Team> teams = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = reader.readLine();

            while ((line = reader.readLine()) != null){
                line = line.trim();
                if (line.isEmpty()){
                    continue;
                }
                final Team team = parseLine(line);
                if(team != null){
                    teams.add(team);
                }
            }
        }catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return teams;
    }
}

