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

    public void playGroupStage() {
        final PredictionStrategy strategy = new EloStrategy();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                final Match match = new Match(teams.get(i),
                        teams.get(j), strategy, false);
                final MatchResult result = match.play();
                findStandings(teams.get(i)).addResult(result);
                findStandings(teams.get(j)).addResult(result);
            }
        }
    }

    private Standings findStandings(final Team team) {
        return standings.stream()
                .filter(s -> s.getTeam().equals(team))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "No standings found for: "
                                + team.getCountryName()));
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
        sorted.sort((homeTeam, awayTeam) -> {
            if (awayTeam.getPoints().intValue() != homeTeam.getPoints()) {
                return awayTeam.getPoints() - homeTeam.getPoints();
            }
            if (awayTeam.getGoalDiff().intValue() != homeTeam.getGoalDiff()) {
                return awayTeam.getGoalDiff() - homeTeam.getGoalDiff();
            }
            return awayTeam.getGoalsFor() - homeTeam.getGoalsFor();
        });
        return sorted;
    }

    public String getName(){
        return name;
    }

    public void reset() {
        for (final Standings standing : standings) {
            standing.reset();
        }
    }

    //for TournamentFactoryTest
    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }
}
