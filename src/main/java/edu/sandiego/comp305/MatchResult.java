package edu.sandiego.comp305;

public class MatchResult {
    private final Team winner;

    private final Team homeTeam;

    private final Team awayTeam;

    private final int homeGoals;

    private final int  awayGoals;

    private final boolean isDraw;

    public MatchResult(final Team homeTeam, final Team awayTeam,
                       final Team winner, final int homeGoals,
                       final int AwayGoals, final boolean isDraw){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winner = winner;
        this.homeGoals = homeGoals;
        this.awayGoals = AwayGoals;
        this.isDraw = isDraw;
    }

    public Team getWinner(){
        return winner;
    }

    public Team getHomeTeam(){
        return homeTeam;
    }

    public Team getAwayTeam(){
        return awayTeam;
    }

    public boolean getIsDraw(){
        return isDraw;
    }

    public Integer getHomeGoals(){
        return homeGoals;
    }

    public Integer getAwayGoals(){
        return awayGoals;
    }
}
