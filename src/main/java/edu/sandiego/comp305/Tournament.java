package edu.sandiego.comp305;

import java.util.List;

import java.util.ArrayList;

public class Tournament {
    private final List<Group> groups;

    private Bracket bracket;

    private final PredictionStrategy strategy;

    private static final int SINGLE_ELIMINATION = 1;

    public Tournament(final List<Group> groups,
                      final PredictionStrategy strategy){
        this.groups = new ArrayList<>(groups);
        this.strategy = strategy;
        this.bracket = null;
    }

    public void runGroupStage(){
        for (final Group group : groups) {
            group.playGroupStage();
        }
    }

    public void buildBracket() {
        final List<Team> qualifiers = new ArrayList<>();
        for (final Group group : groups) {
            qualifiers.addAll(group.getQualifiers());
        }
        bracket = new Bracket(qualifiers, SINGLE_ELIMINATION , strategy);
    }

    public Team runKnockout() {
        if (bracket == null) {
            throw new IllegalStateException(
                    "Bracket not built. Call buildBracket() first.");
        }
        List<Team> current = bracket.playRound();
        while (current.size() > 1) {
            current = playNextRound(current);
        }
        return new Bracket(current, 1, new EloStrategy()).getWinner();
    }

    private List<Team> playNextRound(final List<Team> teams) {
        final Bracket nextRound = new Bracket(teams, 1, strategy);
        return nextRound.playRound();
    }
}
