package edu.sandiego.comp305;

public class Team {
    private int ranking;

    private String countryName;

    private String countryCode;

    private int rating;

    private int totalGames;

    private int totalWins;

    private int totalLosses;

    private int goalsScored;

    private int goalsConceded;

    public Team(int ranking, String countryName, String countryCode, int rating, int totalGames, int totalWins,
                int totalLosses, int goalsScored, int goalsConceded){
        this.ranking = ranking;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.rating = rating;
        this.totalGames = totalGames;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }

    public Integer getRating(){
        return rating;
    }

    public Double getWinRate(){
        return (double) totalWins / totalGames;
    }

    public Integer getGoalDifference(){
        return goalsScored - goalsConceded;
    }

    public Integer getRanking(){
        return ranking;
    }

    public String getCountryName(){
        return countryName;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public Integer getTotalLosses(){
        return totalLosses;
    }
}
