package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    @Test
    void teamHasCorrectCountryName() {
        Team team = new Team(3, "France", "FRA", 2141, 100, 70, 10, 200, 80);
        assertEquals("France", team.getCountryName());
    }

    @Test
    void teamHasCorrectCountryCode() {
        Team team = new Team(2, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals("FRA", team.getCountryCode());
    }

    @Test
    void teamHasCorrectRanking() {
        Team team = new Team(2, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals(2, team.getRanking());
    }

    @Test
    void teamHasCorrectRating() {
        Team team = new Team(2, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals(2050, team.getRating());
    }

    @Test
    void teamHasCorrectTotalLosses() {
        Team team = new Team(2, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals(15, team.getTotalLosses());
    }

    @Test
    void teamHasCorrectWinRate() {
        Team team = new Team(2, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals(0.667, team.getWinRate(), 0.001);
    }
}
