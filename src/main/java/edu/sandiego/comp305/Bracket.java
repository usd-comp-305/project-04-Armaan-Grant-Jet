package edu.sandiego.comp305;

import java.util.ArrayList;

import java.util.List;

public class Bracket {
    private final List<Team> teams;

    private final int round;

    private final PredictionStrategy strategy;

    public Bracket(final List<Team> teams, final int round,
                   final PredictionStrategy strategy){
        this.teams = new ArrayList<>(teams);
        this.round = round;
        this.strategy = strategy;
    }

    public List<Team> playRound(){
        final List<Team> winners = new ArrayList<>();
        for (int i = 0; i < teams.size() - 1; i +=2){
            final Team winner = playMatch(teams.get(i), teams.get(i+1));
            winners.add(winner);
        }
        return winners;
    }

    public Team getWinner(){
        return teams.get(0);
    }

    public Integer getCurrentRound(){
        return round;
    }

    private Team playMatch(final Team homeTeam, final Team awayTeam) {
        final Match match = new Match(homeTeam, awayTeam, strategy, true);
        final MatchResult result = match.play();
        return result.getWinner();
    }
}
