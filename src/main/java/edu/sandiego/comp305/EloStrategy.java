package edu.sandiego.comp305;

public class EloStrategy implements PredictionStrategy {

    private static final double ELO_SCALE = 400.0;

    private static final double ELO_BASE = 10.0;

    private static final double WEIGHT_ELO = 0.5;

    private static final double WEIGHT_WINRATE = 0.2;

    private static final double WEIGHT_GOALDIFF = 0.2;

    private static final double WEIGHT_DEFENSE_ATT = 0.1;

    // Goal difference of weaker teams can be negative
    // and break the formula, so +5 will allow keep the values
    // above negative comfortably and keep the math valid

    private static final double GOALDIFF_SHIFT = 5.0;

    // For teams that have zero goals conceded 
    // and to avoid division by zero errors
    private static final double EPSILON = 1e-9;
    
    @Override
    public double getProbability(final Team home, final Team away) {
        final double eloProbability = elo(home, away);
        final double winRateProbability = winRate(home, away);
        final double goalDiffProbability = goalDiff(home, away);
        final double defenseAttProbability = defenseAtt(home, away);

        return WEIGHT_ELO * eloProbability 
        + WEIGHT_WINRATE * winRateProbability
        + WEIGHT_GOALDIFF * goalDiffProbability 
        + WEIGHT_DEFENSE_ATT * defenseAttProbability;
    }

    private double elo(final Team home, final Team away) {
        // Calculating home's team probability
        final double ratingDiff = away.getRating() - home.getRating();

        return 1.0 / (1.0 + Math.pow(
            ELO_BASE, ratingDiff / ELO_SCALE));
    }

    private double winRate(final Team home, final Team away) {
        final double homeWinRate = home.getWinRate();
        final double awayWinRate = away.getWinRate();
        final double total = homeWinRate + awayWinRate;

        if (total < EPSILON) {
            return 0.5;
        }
        return homeWinRate / total;
    }

    private double goalDiff(final Team home, final Team away) {
        final double homeGoalDiff = 
        home.getGoalDifference() / (double) home.getTotalGames() 
        + GOALDIFF_SHIFT;
        final double awayGoalDiff = 
        away.getGoalDifference() / (double) away.getTotalGames() 
        + GOALDIFF_SHIFT;

        return homeGoalDiff / (homeGoalDiff + awayGoalDiff);
    }

    private double defenseAtt(final Team home, final Team away) {
        final double homeGoalsConcededPerGame =
        home.getGoalsAgainst() / (double) home.getTotalGames() 
        + EPSILON;
        final double awayGoalsConcededPerGame = 
        away.getGoalsAgainst() / (double) away.getTotalGames() 
        + EPSILON;
        final double invertedHome = 1.0 / homeGoalsConcededPerGame;
        final double invertedAway = 1.0 / awayGoalsConcededPerGame;

        return invertedHome / (invertedHome + invertedAway);
    }
}

