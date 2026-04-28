package edu.sandiego.comp305;

public class Standings {
    private final Team team;

    private final int points;

    private final int goalDiff;

    private final int goalsFor;

    private final int goalsAgainst;

    public Standings(final Team team, final int points,
                     final int goalDiff, final int goalsFor,
                     final int goalsAgainst){
        this.team = team;
        this.points = points;
        this.goalDiff = goalDiff;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public void addResult(final MatchResult matchResult){
    }

    public Integer getPoints(){
        return points;
    }

    public Integer getGoalDiff(){
        return goalDiff;
    }

    public Integer getGoalsFor(){
        return goalsFor;
    }

    public Integer getGoalsAgainst(){
        return goalsAgainst;
    }

    public Team getTeam(){
        return team;
    }

}
