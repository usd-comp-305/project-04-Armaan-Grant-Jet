package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    @Test
    void teamHasCorrectCountryName() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals("France", team.getCountryName());
    }

    @Test
    void teamHasCorrectCountryCode() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals("FR", team.getCountryCode());
    }

    @Test
    void teamHasCorrectRanking() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals(3, team.getRanking());
    }

    @Test
    void teamHasCorrectRating() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals(2082, team.getRating());
    }

    @Test
    void teamHasCorrectTotalLosses() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals(269, team.getTotalLosses());
    }

    @Test
    void teamHasCorrectWinRate() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals(0.505, team.getWinRate(), 0.001);
    }

    @Test
    void teamHasPositiveGoalDifference() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 1706, 1272);
        assertEquals(434, team.getGoalDifference());
    }

    @Test
    void teamHasNegativeGoalDifference() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 50, 120);
        assertEquals(-70, team.getGoalDifference());
    }

    @Test
    void teamHasZeroGoalDifference() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 474, 269, 100, 100);
        assertEquals(0, team.getGoalDifference());
    }

    @Test
    void teamHasWinRateOfOne() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 938, 0, 1706, 1272);
        assertEquals(1.0, team.getWinRate(), 0.001);
    }

    @Test
    void teamHasWinRateOfZero() {
        final Team team = new Team(3, "France", "FR", 2082, 938, 0, 938, 1706, 1272);
        assertEquals(0.0, team.getWinRate(), 0.001);
    }
}
