package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    @Test
    void teamHasCorrectCountryName() {
        Team team = new Team(1, "Brazil", "BRA", 2141, 100, 70, 10, 200, 80);
        assertEquals("Brazil", team.getCountryName());
    }

    @Test
    void teamHasCorrectCountryCode() {
        Team team = new Team(3, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals("FRA", team.getCountryCode());
    }

    @Test
    void teamHasCorrectRanking() {
        Team team = new Team(3, "France", "FRA", 2050, 90, 60, 15, 180, 70);
        assertEquals(3, team.getRanking());
    }
}
