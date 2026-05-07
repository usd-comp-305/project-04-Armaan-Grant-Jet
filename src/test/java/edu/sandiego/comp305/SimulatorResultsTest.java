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

}
