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
        if (matchResult.getHomeTeam().equals(team)) {
            this.goalsFor += matchResult.getHomeGoals();
            this.goalsAgainst += matchResult.getAwayGoals();
        } else {
            this.goalsFor += matchResult.getAwayGoals();
            this.goalsAgainst += matchResult.getHomeGoals();
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

    public void reset() {
        points = 0;
        goalsFor = 0;
        goalsAgainst = 0;
    }
}

