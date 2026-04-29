package edu.sandiego.comp305;

import java.util.HashMap;
import java.util.Map;

public class SimulatorResults {
    
    private final Map<Team, Integer> winCounts;

    private final int totalRuns;

    public SimulatorResults(final Map<Team, Integer> winCounts, 
        final int totalRuns) {
        this.winCounts = new HashMap<>(winCounts);
        this.totalRuns = totalRuns;
    }

    public void recordWin(final Team team) {}

    public double getWinProbability(final Team team) {
        return 0.0;
    }

    public int getTotalRuns() {
        return 0;
    }

    public void printResults() {}
    
}

