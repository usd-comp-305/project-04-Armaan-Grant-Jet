package edu.sandiego.comp305;

import java.util.Random;

public class Match {

    private static final double DRAW_SHARE = 0.35;

    private static final double BASE_GOALS = 1.3;

    private static final double PENALTY_WIN_PROBABILITY = 0.5;

    private final Team homeTeam;

    private final Team awayTeam;

    private final PredictionStrategy strategy;

    private final boolean isKnockout;

    private final RandomProvider random;

    public Match(final Team homeTeam, final Team awayTeam, 
        final PredictionStrategy strategy, final boolean isKnockout) {
        this(homeTeam, awayTeam, strategy, isKnockout, new Random()::nextDouble);
    }
    
    public Match(final Team homeTeam, final Team awayTeam, 
        final PredictionStrategy strategy, final boolean isKnockout, 
        final RandomProvider random) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.strategy = strategy;
        this.isKnockout = isKnockout;
        this.random = random;
    }

    public MatchResult play() {
        return null;
    }

    public Team simulatePenalties() {
        return null;
    }
}

