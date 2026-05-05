package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    private double[] randomValues;

    private int randomIndex;

    private RandomProvider mockRandom;

    private PredictionStrategy mockStrategy;

    private Team homeTeam;

    private Team awayTeam;

    @BeforeEach
    void setUp() {

        randomIndex = 0;
        mockRandom = new RandomProvider() {
            @Override
            public double nextDouble() {
                return randomValues[randomIndex++];
            }
        };

        mockStrategy = new PredictionStrategy() {
            @Override
            public double getProbability(
                final Team homeTeam, final Team awayTeam) {
                return 0.70;
            }
        };

        homeTeam = new Team(1, "Home", "HT", 2000, 100, 70, 15, 180, 60);
        awayTeam = new Team(2, "Away", "AT", 1600, 100, 30, 50, 80, 160);
    }

    private void setRandomValues(final double... values) {
        randomValues = values;
        randomIndex = 0;
    }

    private void setHomeWin() {
        setRandomValues(0.01, 0.01, 0.01);
    }

    private void setAwayWin() {
        setRandomValues(0.99, 0.01, 0.01);
    }

    private void setGroupStage() {
        setRandomValues(0.75, 0.01);
    }

    private void setKnockoutStageHomeWinsPenalties() {
        setRandomValues(0.75, 0.01, 0.01);
    }

    private void setKnockoutStageAwayWinsPenalties() {
        setRandomValues(0.75, 0.01, 0.99);
    }

    private Match groupMatch() {
        return new Match(
            homeTeam, awayTeam, mockStrategy, false, mockRandom);
    }

    private Match knockoutMatch() {
        return new Match(
            homeTeam, awayTeam, mockStrategy, true, mockRandom);
    }

    private MatchResult playGroupMatch() {
        return groupMatch().play();
    }

    private MatchResult playKnockoutMatch() {
        return knockoutMatch().play();
    }

    @Test
    void playNeverReturnsNullAndDoesNotBreakSim() {
        setHomeWin();

        assertNotNull(groupMatch().play());
    }

    @Test
    void playReturnsHomeTeamAsWinner() {
        setHomeWin();

        assertEquals(homeTeam, groupMatch().play().getWinner());
    }

    @Test
    void playReturnsHomeWinIsNotADraw() {
        setHomeWin();

        assertFalse(groupMatch().play().isDraw());
    }

    @Test
    void playHomeWinHomeGoalsGreaterThanAwayGoals() {
        setHomeWin();
        final MatchResult result = playGroupMatch();

        assertTrue(result.getHomeTeamGoals() > result.getAwayTeamGoals());
    }

    @Test
    void playReturnsAwayTeamAsWinner() {
        setAwayWin();

        assertEquals(awayTeam, groupMatch().play().getWinner());
    }

    @Test
    void playReturnsAwayWinIsNotADraw() {
        setAwayWin();

        assertFalse(groupMatch().play().isDraw());
    }

    @Test
    void playAwayWinAwayGoalsGreaterThanHomeGoals() {
        setAwayWin();
        final MatchResult result = playGroupMatch();

        assertTrue(result.getAwayTeamGoals() > result.getHomeTeamGoals());
    }

    @Test
    void playGroupStageIsADraw() {
        setGroupStage();

        assertTrue(groupMatch().play().isDraw());
    }

    @Test
    void playGroupStageWinnerIsNull() {
        setGroupStage();

        assertNull(groupMatch().play().getWinner());
    }

    @Test
    void playGroupStageGoalsAreEqual() {
        setGroupStage();
        final MatchResult result = playGroupMatch();

        assertEquals(result.getHomeTeamGoals(), result.getAwayTeamGoals());
    }

    @Test
    void playKnockoutStageIsNotDraw() {
        setKnockoutStageHomeWinsPenalties();

        assertFalse(knockoutMatch().play().isDraw());
    }

    @Test
    void playKnockoutStageHomeWinPenalties() {
        setKnockoutStageHomeWinsPenalties();

        assertEquals(homeTeam, knockoutMatch().play().getWinner());
    }

    @Test
    void playKnockoutStageAwayWinPenalties() {
        setKnockoutStageAwayWinsPenalties();

        assertEquals(awayTeam, knockoutMatch().play().getWinner());
    }

    @Test
    void playKnockoutStageGoalsAreEqual() {
        setKnockoutStageHomeWinsPenalties();
        final MatchResult result = playKnockoutMatch();

        assertEquals(result.getHomeTeamGoals(), result.getAwayTeamGoals());
    }

    @Test
    void simulatePenaltiesBelowThresholdReturnsHomeTeam() {
        setRandomValues(0.01);

        assertEquals(homeTeam, knockoutMatch().simulatePenalties());
    }

    @Test
    void simulatePenaltiesAboveThresholdReturnsAwayTeam() {
        setRandomValues(0.99);

        assertEquals(awayTeam, knockoutMatch().simulatePenalties());
    }
    
}
