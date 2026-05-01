package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StandingsTest {
    private Team france;
    private Team spain;

    @BeforeEach
    void setUp() {
        france = new Team(3, "France", "FR",
                2082, 938, 474, 269, 1706, 1272);
        spain = new Team(1, "Spain", "ES",
                2165, 780, 461, 138, 1591, 697);
    }

    @Test
    void standingsStartWithZeroPoints() {
        final Standings entry = new Standings(france);
        assertEquals(0, entry.getPoints());
    }

    @Test
    void standingsStartWithZeroGoalsFor() {
        final Standings entry = new Standings(france);
        assertEquals(0, entry.getGoalsFor());
    }

    @Test
    void standingsStartWithZeroGoalsAgainst() {
        final Standings entry = new Standings(france);
        assertEquals(0, entry.getGoalsAgainst());
    }

    @Test
    void standingsStartWithZeroGoalDiff() {
        final Standings entry = new Standings(france);
        assertEquals(0, entry.getGoalDiff());
    }
}
