package edu.sandiego.comp305;

public class MatchResult {
    private Team winner;
    private int goalsA;
    private int goalsB;
    private boolean isDraw;


    public Team getWinner(){
        return winner;
    }
    public boolean isDraw(){
        return false;
    }
    public Integer getGoalsA() {
        return 0;
    }
    public Integer getGoalsB(){
        return 0;
    }
}
