package edu.sandiego.comp305;

public class Team {
    private final int ranking;

    private final String countryName;

    private final String countryCode;

    private final int rating;

    private final int totalGames;

    private final int totalWins;

    private final int totalLosses;

    private final int goalsScored;

    private final int goalsConceded;

    public Team(final int ranking, final String countryName,
                final String countryCode, final int rating,
                final int totalGames, final int totalWins,
                final int totalLosses, final int goalsScored,
                final int goalsConceded){
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
