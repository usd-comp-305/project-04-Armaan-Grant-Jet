package edu.sandiego.comp305;

import java.util.List;
import java.util.ArrayList;

public class Group {
    private final String name;
    private final List<Team> teams;
    private final List<Standings> standings;
    private final PredictionStrategy strategy;

    public Group(final String name, final List<Team> teams,
                 final PredictionStrategy strategy){
        this.name = name;
        this.teams = new ArrayList<>(teams);
        this.strategy = strategy;
        this.standings = new ArrayList<>();
        for (final Team team : teams) {
            standings.add(new Standings(team));
        }
    }

    public void playGroupStage(){

    }

    public List<Team> getQualifiers(){
        return null;
    }

    public List<Standings> getStandings(){
        final List<Standings> sorted = new ArrayList<>(standings);
        sorted.sort((teamA, teamB) -> {
            if (teamB.getPoints() != teamA.getPoints()) {
                return teamB.getPoints() - teamA.getPoints();
            }
            if (teamB.getGoalDiff() != teamA.getGoalDiff()) {
                return teamB.getGoalDiff() - teamA.getGoalDiff();
            }
            return teamB.getGoalsFor() - teamA.getGoalsFor();
        });
        return sorted;
    }

    public String getName(){
        return name;
    }
}