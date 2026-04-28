package edu.sandiego.comp305;

public class Match {

    private final Team homeTeam;

    private final Team awayTeam;

    private final PredictionStrategy strategy;

    private final boolean isKnockout; 

    public Match(final Team homeTeam, final Team awayTeam, 
        final PredictionStrategy strategy, 
        final boolean isKnocked) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.strategy = strategy;
            this.isKnockout = isKnocked;
    }

    public MatchResult play() {
        return null;
    }

    public Team simulatePenalties() {
        return null;
    }
}

