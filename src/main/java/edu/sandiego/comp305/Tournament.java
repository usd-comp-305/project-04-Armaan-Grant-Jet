package edu.sandiego.comp305;

import java.util.List;

import java.util.ArrayList;

public class Tournament {
    private final List<Group> groups;

    private final Bracket bracket;

    public Tournament(final List<Group> groups, final Bracket bracket){
        this.groups = new ArrayList<>(groups);
        this.bracket = bracket;
    }

    public void runGroupStage(){}

    public void buildBracket(){}

    public Team runKnockout(){
        return null;
    }
}
