package edu.sandiego.comp305;

import java.util.List;

import java.util.ArrayList;

public class Tournament {
    private final List<Group> groups;

    private Bracket bracket;

    public Tournament(final List<Group> groups){
        this.groups = new ArrayList<>(groups);
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
        bracket = new Bracket(qualifiers,1 , new EloStrategy());
    }

    public Team runKnockout(){
        return null;
    }
}
