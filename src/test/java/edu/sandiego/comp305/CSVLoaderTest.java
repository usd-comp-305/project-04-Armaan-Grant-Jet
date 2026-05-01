package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CSVLoaderTest {
    @Test
    void loaderReturnsNonEmptyList() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertFalse(teams.isEmpty());
    }

    @Test
    void loaderReturnsCorrectNumberOfTeams() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(47, teams.size());
    }

    @Test
    void firstTeamHasCorrectCountryName() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals("Spain", teams.get(0).getCountryName());
    }

    @Test
    void firstTeamHasCorrectCountryCode() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals("ES", teams.get(0).getCountryCode());
    }

    @Test
    void firstTeamHasCorrectRanking() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(1, teams.get(0).getRanking());
    }

    @Test
    void firstTeamHasCorrectRating() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(2165, teams.get(0).getRating());
    }

    @Test
    void firstTeamHasCorrectTotalGames() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(780, teams.get(0).getTotalGames());
    }

    @Test
    void firstTeamHasCorrectTotalWins() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(461, teams.get(0).getTotalWins());
    }

    @Test
    void firstTeamHasCorrectTotalLosses() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(138, teams.get(0).getTotalLosses());
    }

    @Test
    void firstTeamHasCorrectGoalsScored() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(1591, teams.get(0).getGoalsScored());
    }

    @Test
    void firstTeamHasCorrectGoalsConceded() {
        final CSVLoader loader = new CSVLoader("QualifiedWorldCupTeams.csv");
        final List<Team> teams = loader.loadTeams();
        assertEquals(697, teams.get(0).getGoalsConceded());
    }

    @Test
    void loaderReturnsEmptyListForNonExistentFile() {
        final CSVLoader loader = new CSVLoader("nonexistent.csv");
        final List<Team> teams = loader.loadTeams();
        assertTrue(teams.isEmpty());
    }
}
