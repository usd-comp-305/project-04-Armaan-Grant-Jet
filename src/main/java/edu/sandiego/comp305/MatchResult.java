package edu.sandiego.comp305;

public class MatchResult {
    private final Team winner;

    private final int goalsA;

    private final int  goalsB;

    private final boolean isDraw;

    public MatchResult(final Team winner, final int goalsA, final int goalsB, final boolean isDraw){
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
