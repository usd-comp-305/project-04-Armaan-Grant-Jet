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

    public void recordWin(final Team team) {}

    public double getWinProbability(final Team team) {
        return 0.0;
    }

    public int getTotalRuns() {
        return 0;
    }

    public void printResults() {}
    
}

