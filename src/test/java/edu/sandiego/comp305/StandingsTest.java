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
        final Standings standings = new Standings(france);
        assertEquals(0, standings.getPoints());
    }

    @Test
    void standingsStartWithZeroGoalsFor() {
        final Standings standings = new Standings(france);
        assertEquals(0, standings.getGoalsFor());
    }

    @Test
    void standingsStartWithZeroGoalsAgainst() {
        final Standings standings = new Standings(france);
        assertEquals(0, standings.getGoalsAgainst());
    }

    @Test
    void standingsStartWithZeroGoalDiff() {
        final Standings standings = new Standings(france);
        assertEquals(0, standings.getGoalDiff());
    }
    
    @Test
    void standingsReturnCorrectTeam() {
        final Standings entry = new Standings(france);
        assertEquals(france, entry.getTeam());
    }

    @Test
    void winAddsThreePoints() {
        final Standings standings = new Standings(france);
        final MatchResult result = new MatchResult(france, spain, france,
                3, 1, false);
        standings.addResult(result);
        assertEquals(3, standings.getPoints());
    }

    @Test
    void winUpdatesGoalsFor() {
        final Standings standings = new Standings(france);
        final MatchResult result = new MatchResult(france, spain, france,
                3, 1, false);
        standings.addResult(result);
        assertEquals(3, standings.getGoalsFor());
    }

    @Test
    void winUpdatesGoalsAgainst() {
        final Standings standings = new Standings(france);
        final MatchResult result = new MatchResult(france, spain, france,
                3, 1, false);
        standings.addResult(result);
        assertEquals(3, standings.getGoalsAgainst());
    }

    @Test
    void winProducesPositiveGoalDiff() {
        final Standings standings = new Standings(france);
        final MatchResult result = new MatchResult(france, spain, france,
                3, 1, false);
        standings.addResult(result);
        assertEquals(2, standings.getGoalDiff());
    }
}
