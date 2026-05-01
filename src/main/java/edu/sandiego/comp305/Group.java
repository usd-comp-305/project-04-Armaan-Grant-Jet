package edu.sandiego.comp305;

import java.util.List;
import java.util.ArrayList;

public class Group {
    private final String name;
    private final List<Team> teams;
    private final List<Standings> standings;

    public Group(final String name, final List<Team> teams){
        this.name = name;
        this.teams = new ArrayList<>(teams);
        this.standings = new ArrayList<>();
        for (final Team team : teams) {
            standings.add(new Standings(team));
        }
    }

    public void playGroupStage(){
        //will implement when Match.play() is created
    }

    public List<Team> getQualifiers(){
        final List<Standings> sorted = getStandings();
        final List<Team> qualifiers = new ArrayList<>();
        qualifiers.add(sorted.get(0).getTeam());
        qualifiers.add(sorted.get(1).getTeam());
        return qualifiers;
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