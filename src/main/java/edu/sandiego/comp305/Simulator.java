package edu.sandiego.comp305;

public class Simulator {

    public static final int DEFAULT_SIMULATIONS = 1000;
    
    private final Tournament tournament;

    private final SimulatorResults result;

    public Simulator(final Tournament tournament, 
        final SimulatorResults result) {
        this.tournament = tournament;
        this.result = result;
    }

    public void runSimulations(final int numSimRun) {
        for (int i = 0; i < numSimRun; i++) {
            tournament.reset();
            tournament.runGroupStage();
            tournament.buildBracket();
            final Team winner = tournament.runKnockout();
            result.recordWin(winner);
        }
        result.printResults();
    }
}
