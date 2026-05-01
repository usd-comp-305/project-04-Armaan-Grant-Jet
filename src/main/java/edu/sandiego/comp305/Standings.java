package edu.sandiego.comp305;

public class Standings {
    private final Team team;

    private int points;
    private int goalsFor;
    private int goalsAgainst;

    public Standings(final Team team){
        this.team = team;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    public void addResult(final MatchResult matchResult) {
        if (matchResult.getTeamA().equals(team)) {
            this.goalsFor += matchResult.getGoalsA();
            this.goalsAgainst += matchResult.getGoalsB();
        } else {
            this.goalsFor += matchResult.getGoalsB();
            this.goalsAgainst += matchResult.getGoalsA();
        }
        if (matchResult.getIsDraw()) {
            this.points += 1;
        } else if (matchResult.getWinner().equals(team)) {
            this.points += 3;
        }
    }

    public Integer getPoints(){
        return points;
    }

    public Integer getGoalDiff(){
        return goalsFor - goalsAgainst;
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
