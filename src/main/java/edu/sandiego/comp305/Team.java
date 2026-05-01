package edu.sandiego.comp305;

public class Team {
    private final int ranking;

    private final String countryName;

    private final String countryCode;

    private final int rating;

    private final int totalGames;

    private final int totalWins;

    private final int totalLosses;

    private final int goalsFor;

    private final int goalsAgainst;

    public Team(final int ranking, final String countryName,
                final String countryCode, final int rating,
                final int totalGames, final int totalWins,
                final int totalLosses, final int goalsFor,
                final int goalsAgainst){
        this.ranking = ranking;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.rating = rating;
        this.totalGames = totalGames;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getRating(){
        return rating;
    }

    public Double getWinRate(){
        return (double) totalWins / totalGames;
    }

    public Integer getGoalDifference(){
        return goalsFor - goalsAgainst;
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

    public Integer getTotalGames(){
        return totalGames;
    }

    public Integer getTotalWins(){
        return totalWins;
    }

    public Integer getGoalsFor(){
        return goalsFor;
    }

    public Integer getGoalsAgainst(){
        return goalsAgainst;
    }
}
