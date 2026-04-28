package edu.sandiego.comp305;

public class Team {
    private int ranking;

    private String countryName;

    private String countryCode;

    private int rating;

    private int totalGames;

    private int totalWins;

    private int totalLosses;

    private int goalScored;

    private int goalsConceded;


    public Integer getRating(){
        return rating;
    }

    public Double getWinRate(){
        return (double) totalWins / totalGames;
    }

    public Integer getGoalDifference(){
        return goalScored - goalsConceded;
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
