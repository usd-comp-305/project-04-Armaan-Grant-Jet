package edu.sandiego.comp305;

public class MatchResult {
    private final Team winner;

    private final int homeTeamGoals;

    private final int awayTeamGoals;

    private final boolean isDraw;

    public MatchResult(final Team winner, final int goalsA,
                       final int goalsB, final boolean isDraw){
        this.winner = winner;
        this.homeTeamGoals = goalsA;
        this.awayTeamGoals = goalsB;
        this.isDraw = isDraw;
    }

    public Team getWinner(){
        return winner;
    }

    public boolean isDraw(){
        return isDraw;
    }

    public Integer getHomeTeamGoals(){
        return homeTeamGoals;
    }

    public Integer getAwayTeamGoals(){
        return awayTeamGoals;
    }
}
