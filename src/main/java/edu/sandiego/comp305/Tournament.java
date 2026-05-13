package edu.sandiego.comp305;

import java.util.List;

import java.util.ArrayList;

public class Tournament {
    private static final int SINGLE_ELIMINATION = 1;

    private final List<Group> groups;

    private Bracket bracket;

    private final PredictionStrategy strategy;

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
        final List<Standings> thirdPlaceStandings = new ArrayList<>();
        for (final Group group : groups) {
            qualifiers.addAll(group.getQualifiers());
            thirdPlaceStandings.add(group.getThirdPlace());
        }
        qualifiers.addAll(getBestThirdPlace(thirdPlaceStandings));
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
        return new Bracket(current,  SINGLE_ELIMINATION, strategy).getWinner();
    }

    public void reset() {
        for (final Group group : groups) {
            group.reset();
        }
        bracket = null;
    }

    private List<Team> playNextRound(final List<Team> teams) {
        final Bracket nextRound = new Bracket(teams, 1, strategy);
        return nextRound.playRound();
    }

    private List<Team> getBestThirdPlace(
            final List<Standings> thirdPlaceStandings) {
        final List<Team> bestThird = new ArrayList<>();
        final List<Standings> remaining =
                new ArrayList<>(thirdPlaceStandings);

        final int count = Math.min(8, remaining.size());

        for (int i = 0; i < count; i++) {
            final Standings best = findBestThird(remaining);
            bestThird.add(best.getTeam());
            remaining.remove(best);
        }
        return bestThird;
    }

    private Standings findBestThird(final List<Standings> remaining) {
        Standings best = remaining.get(0);
        for (final Standings standing : remaining) {
            if (isBetter(standing, best)) {
                best = standing;
            }
        }
        return best;
    }

    private boolean isBetter(final Standings currentStanding, final Standings bestStanding) {
        if (currentStanding.getPoints().intValue() != bestStanding.getPoints().intValue()) {
            return currentStanding.getPoints() > bestStanding.getPoints();
        }
        if (currentStanding.getGoalDiff().intValue() != bestStanding.getGoalDiff().intValue()) {
            return currentStanding.getGoalDiff() > bestStanding.getGoalDiff();
        }
        return currentStanding.getGoalsFor() > bestStanding.getGoalsFor();
    }
}
