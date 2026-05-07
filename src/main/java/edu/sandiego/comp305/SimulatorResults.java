package edu.sandiego.comp305;

import java.util.HashMap;
import java.util.Map;

public class SimulatorResults {
    
    private final Map<Team, Integer> winCounts;

    private int totalRuns;

    public SimulatorResults() {
        this.winCounts = new HashMap<>();
        this.totalRuns = 0;
    }

    public void recordWin(final Team team) {
        if (winCounts.containsKey(team)){
            winCounts.put(team, winCounts.get(team) + 1);
        }
        else {
            winCounts.put(team,1);
        }
        totalRuns++;
    }

    public double getWinProbability(final Team team) {
        if (!winCounts.containsKey(team)){
            return 0.0;
        }
        return (double) winCounts.get(team) / totalRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void printResults() {
        System.out.println("Total Simulations: " + totalRuns);
        for (final Team team : winCounts.keySet()){
            printTeamResult(team);
        }
    }

    private void printTeamResult(final Team team){
        final int wins = winCounts.get(team);
        final double probability = getWinProbability(team);
        System.out.println(team.getCountryName()
                + " - Wins: " + wins
                + " - Probability: " + probability);
    }
}

