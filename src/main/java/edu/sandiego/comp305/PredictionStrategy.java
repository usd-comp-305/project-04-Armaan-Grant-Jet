package edu.sandiego.comp305;

public interface PredictionStrategy {
    double getProbability(Team homeTeam, Team awayTeam);
}