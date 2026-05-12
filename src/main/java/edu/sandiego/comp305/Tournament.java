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

    public void runGroupStage(){}

    public void buildBracket(){}

    public Team runKnockout(){
        return null;
    }
}
