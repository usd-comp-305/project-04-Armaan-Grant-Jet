package edu.sandiego.comp305;

import java.util.List;

import java.util.ArrayList;

public class Group {
    private final String name;

    private final List<Team> teams;

    private final List<Standings> standings;

    public Group(final String name, final List<Team> teams,
                 final List<Standings> standings){
        this.name = name;
        this.teams = new ArrayList<>(teams);
        this.standings = new ArrayList<>(standings);
    }

    public void playGroupStage(){

    }

    public List<Team> getQualifiers(){
        return null;
    }

    public List<Standings> getStandings(){
        return null;
    }

    public String getName(){
        return name;
    }
}

