package edu.sandiego.comp305;

public class Simulator {
    
    private final Tournament tournament;

    private final SimulatorResults result;

    private final CSVLoader loader;

    public Simulator(final Tournament tournament, 
        final SimulatorResults result, final CSVLoader loader) {
        this.tournament = tournament;
        this.result = result;
        this.loader = loader;
    }

    public void runSimulations(final int numSimRun) {}
}
