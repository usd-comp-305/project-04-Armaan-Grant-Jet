package edu.sandiego.comp305;

public class Standings {
    private Team team;
    private int points;
    private int goalDiff;
    private int goalsFor;
    private int goalsAgainst;

    public Standings(Team team, int points,
                     int goalDiff, int goalsFor,
                     int goalsAgainst){
        this.team = team;
        this.points = points;
        this.goalDiff = goalDiff;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public void addResult(MatchResult matchResult){
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
