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
        return null;
    }

    public Team getWinner(){
        return null;
    }

    public Integer getCurrentRound(){
        return round;
    }
}
