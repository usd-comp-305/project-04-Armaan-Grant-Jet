package edu.sandiego.comp305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulatorResults {
    
    private final Map<Team, Integer> winCounts;

    private int totalRuns;

    public SimulatorResults() {
        this.winCounts = new HashMap<>();
        this.totalRuns = 0;
    }

    public void recordWin(final Team team) {
        if (winCounts.containsKey(team)) {
            winCounts.put(team, winCounts.get(team) + 1);
        } else {
            winCounts.put(team, 1);
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
        final List<Team> remaining = new ArrayList<>(winCounts.keySet());
        while (!remaining.isEmpty()) {
            final Team best = findTopTeam(remaining);
            printTeamResult(best);
            remaining.remove(best);
        }
        printFavorite();
    }

    private void printTeamResult(final Team team){
        final int wins = winCounts.get(team);
        final double probability = getWinProbability(team) * 100;
        System.out.printf("%s - Wins: %d, Probability: %.1f%%%n",
                team.getCountryName(), wins, probability);
    }

    private Team findTopTeam(final List<Team> remaining) {
        Team best = remaining.get(0);
        for (final Team team : remaining) {
            if (winCounts.get(team) > winCounts.get(best)) {
                best = team;
            }
        }
        return best;
    }

    private void printFavorite() {
        Team favorite = null;
        int maxWins = 0;
        for (final Map.Entry<Team, Integer> entry : winCounts.entrySet()) {
            if (entry.getValue() > maxWins) {
                maxWins = entry.getValue();
                favorite = entry.getKey();
            }
        }
        System.out.println("\n" + favorite.getCountryName() +
                " has the best chance of winning the World Cup!");
    }
}

