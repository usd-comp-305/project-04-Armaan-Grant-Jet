package edu.sandiego.comp305;

import java.util.List;

public class WorldCupRunner {
    private WorldCupRunner() {
        // prevent instantiation
    }

    public static void main(final String[] args) {
        final CSVLoader loader = new CSVLoader(
                "data/test_teams.csv");
        final List<Team> teams = loader.loadTeams();
        final List<Group> groups = TournamentFactory.buildGroups(teams);
        final Tournament tournament = new Tournament(
                groups, new EloStrategy());
        final SimulatorResults results = new SimulatorResults();
        final Simulator simulator = new Simulator(tournament, results);
        simulator.runSimulations(Simulator.DEFAULT_SIMULATIONS);
    }
}
