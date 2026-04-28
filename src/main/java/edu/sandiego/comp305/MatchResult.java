package edu.sandiego.comp305;

public class MatchResult {
    private Team winner;

    private int goalsA;

    private int goalsB;

    private boolean isDraw;

    public Team getWinner(){
        return winner;
    }

    public boolean getIsDraw(){
        return isDraw;
    }

    public Integer getGoalsA(){
        return goalsA;
    }

    public Integer getGoalsB(){
        return goalsB;
    }
}
