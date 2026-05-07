package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimulatorResultsTest {

    @Test
    public void testRecordWin() {
        final SimulatorResults results = new SimulatorResults();
        final Team spain = new Team(1, "Spain", "ES", 2165,
                780, 461, 138, 1591, 697);

        results.recordWin(spain);

        assertEquals(1, results.getWinProbability(spain), 0.01);
    }

    @Test
    public void testGetTotalRuns() {
        final SimulatorResults results = new SimulatorResults();
        final Team spain = new Team(1, "Spain", "ES", 2165,
                780, 461, 138, 1591, 697);

        final Team argentina = new Team(2, "Argentina", "AR", 2113,
                1109, 610, 228, 2112, 1136);

        results.recordWin(spain);
        results.recordWin(argentina);

        assertEquals(2, results.getTotalRuns());
    }

}
