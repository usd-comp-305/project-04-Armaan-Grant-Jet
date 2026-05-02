package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class MatchTest {

    @Mock
    private RandomProvider mockRandom;

    @Mock
    private PredictionStrategy mockStrategy;

    private Team homeTeam;
    private Team awayTeam;

    @BeforeEach
    void setUp() {
        
        homeTeam = new Team(1, "Home", "HT", 2000, 100, 70, 15, 180, 60);
        awayTeam = new Team(2, "Away", "AT", 1600, 100, 30, 50, 80, 160);

        // homeWinProb = 0.7, drawProb = (1-0.7)*0.35 = 0.105
        // home win: roll < 0.70
        // draw: 0.7 <= roll < 0.805
        // away win: roll > 0.805

        when(mockStrategy.getProbability(homeTeam, awayTeam)).thenReturn(0.70);
    }

    private void setHomeWin() {
        when(mockRandom.nextDouble()).thenReturn(0.01, 0.01, 0.01);
    }

    private void setAwayWin() {
        when(mockRandom.nextDouble()).thenReturn(0.99, 0.01, 0.01);
    }

    private void setGroupStage() {
        when(mockRandom.nextDouble()).thenReturn(0.75, 0.01);
    }

    private void setKnockoutStageHomeWinsPenalties() {
        when(mockRandom.nextDouble()).thenReturn(0.75, 0.01, 0.01);
    }

    private void setKnockoutStageAwayWinsPenalties() {
        when(mockRandom.nextDouble()).thenReturn(0.75, 0.01, 0.99);
    }

    private Match groupMatch() {
        return new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);
    }

    private Match knockoutMatch() {
        return new Match(homeTeam, awayTeam, mockStrategy, true, mockRandom);
    }

    private MatchResult playGroupMatch() {
        return groupMatch().play();
    }

    private MatchResult playKnockoutMatch() {
        return knockoutMatch().play();
    }

    @Test
    void playNeverReturnsNull() {
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
        when(mockRandom.nextDouble()).thenReturn(0.01);

        assertEquals(homeTeam, knockoutMatch().simulatePenalties());
    }

    @Test
    void simulatePenaltiesAboveThresholdReturnsAwayTeam() {
        when(mockRandom.nextDouble()).thenReturn(0.99);

        assertEquals(awayTeam, knockoutMatch().simulatePenalties());
    }
    
}
