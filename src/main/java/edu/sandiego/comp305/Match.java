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
        final double homeWinProbability = strategy.getProbability(homeTeam, awayTeam);
        final double drawProbability = (1.0 - homeWinProbability) * DRAW_SHARE;
        
        final double outcomeRoll = random.nextDouble();
        if (outcomeRoll < homeWinProbability) {
            final int homeGoals = simulateGoals(BASE_GOALS * 1.2);
            final int awayGoals = simulateGoals(BASE_GOALS * 0.8);
            final int guaranteedWinnerGoals = Math.max(homeGoals, awayGoals + 1);
            
            return new MatchResult(homeTeam, guaranteedWinnerGoals, awayGoals, false);
        } else if (outcomeRoll < homeWinProbability + drawProbability) {
            final int goals = simulateGoals(BASE_GOALS);
            if (isKnockout) {
                final Team winner = simulatePenalties();

                return new MatchResult(winner, goals, goals, false);
            }
            return new MatchResult(null, goals, goals, true);
        } else {
            final int homeGoals = simulateGoals(BASE_GOALS * 0.8);
            final int awayGoals = simulateGoals(BASE_GOALS * 1.2);
            final int guaranteedWinnerGoals = Math.max(awayGoals, homeGoals + 1);

            return new MatchResult(awayTeam, homeGoals, guaranteedWinnerGoals, false);
        }
    }

    public Team simulatePenalties() {
        return null;
    }

    private int simulateGoals(final double lambda) {
        final double threshold = Math.exp(-lambda);
        double product = 1.0;
        int goals = 0;
        do {
            product *= random.nextDouble();
            goals++;
        } while (product > threshold);
        
        return goals - 1;
    }
}

