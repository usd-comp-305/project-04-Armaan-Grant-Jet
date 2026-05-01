package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CSVLoaderTest {
    @Test
    void loaderReturnsNonEmptyList() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertFalse(teams.isEmpty());
    }

    @Test
    void loaderReturnsCorrectNumberOfTeams() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(47, teams.size());
    }

    @Test
    void firstTeamHasCorrectCountryName() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals("Spain", teams.get(0).getCountryName());
    }

    @Test
    void firstTeamHasCorrectCountryCode() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals("ES", teams.get(0).getCountryCode());
    }

    @Test
    void firstTeamHasCorrectRanking() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(1, teams.get(0).getRanking());
    }

    @Test
    void firstTeamHasCorrectRating() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(2165, teams.get(0).getRating());
    }

    @Test
    void firstTeamHasCorrectTotalGames() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(780, teams.get(0).getTotalGames());
    }

    @Test
    void firstTeamHasCorrectTotalWins() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(461, teams.get(0).getTotalWins());
    }

    @Test
    void firstTeamHasCorrectTotalLosses() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(138, teams.get(0).getTotalLosses());
    }

    @Test
    void firstTeamHasCorrectGoalsScored() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(1591, teams.get(0).getGoalsFor());
    }

    @Test
    void firstTeamHasCorrectGoalsConceded() {
        CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        List<Team> teams = loader.loadTeams();
        assertEquals(697, teams.get(0).getGoalsAgainst());
    }

    @Test
    void loaderReturnsEmptyListForNonExistentFile() {
        CSVLoader loader = new CSVLoader("nonexistent.csv");
        List<Team> teams = loader.loadTeams();
        assertTrue(teams.isEmpty());
    }
}
