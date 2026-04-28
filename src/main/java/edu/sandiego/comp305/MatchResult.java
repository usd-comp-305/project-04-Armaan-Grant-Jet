package edu.sandiego.comp305;

public class MatchResult {
    private Team winner;

    private int goalsA;

    private int goalsB;

    private boolean isDraw;

    public MatchResult(Team winner, int goalsA, int goalsB, boolean isDraw){
        this.winner = winner;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
        this.isDraw = isDraw;
    }

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
