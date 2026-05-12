package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SimulatorTest {
    private Simulator simulator;

    private SimulatorResults results;

    @BeforeEach
    public void setUp() {
        final List<Team> teams = new ArrayList<>();
        teams.add(new Team(1, "Spain", "ES", 2165,
                780, 461, 138, 1591, 697));
        teams.add(new Team(2, "Argentina", "AR", 2113,
                1109, 610, 228, 2112, 1136));
        teams.add(new Team(3, "France", "FR", 2082,
                938, 474, 269, 1706, 1722));
        teams.add(new Team(4, "England", "EN", 2020,
                1161, 683, 216, 2719, 1120));

        final Group groupA = new Group("A", teams);
        final List<Group> groups = new ArrayList<>();
        groups.add(groupA);

        final Tournament tournament = new Tournament(
                groups, new EloStrategy());
        results = new SimulatorResults();
        final CSVLoader loader = new CSVLoader("teams.csv");

        simulator = new Simulator(tournament, results, loader);
    }

    @Test
    public void testRunSimulations() {
        simulator.runSimulations(10);
        assertEquals(10, results.getTotalRuns());
    }

    @Test
    public void testRunSimulationZeroRuns() {
        simulator.runSimulations(0);
        assertEquals(0, results.getTotalRuns());
    }

    @Test
    public void testRunSimulationWinnerRecorded() {
        simulator.runSimulations(5);
        assertTrue(results.getTotalRuns() > 0);
    }

    @Test
    public void testRunSimulationThousandRuns() {
        simulator.runSimulations(1000);
        assertEquals(1000, results.getTotalRuns());
    }

}
