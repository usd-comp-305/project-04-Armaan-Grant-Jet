package edu.sandiego.comp305;

public interface PredictionStrategy {
    public abstract double getProbability(Team homeTeam, Team awayTeam);
}
