package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.MathContext;

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

    @Test
    void playNeverReturnsNull() {
         when(mockRandom.nextDouble()).thenReturn(0.01, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);

        assertNotNull(match.play());
    }

    @Test
    void playReturnsHomeTeamAsWinner() {
         when(mockRandom.nextDouble()).thenReturn(0.01, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);

        assertEquals(homeTeam, match.play().getWinner());
    }

    @Test
    void playReturnsHomeWinIsNotADraw() {
        when(mockRandom.nextDouble()).thenReturn(0.01, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);

        assertFalse(match.play().isDraw());
    }

    @Test
    void playHomeWinHomeGoalsGreaterThanAwayGoals() {
        when(mockRandom.nextDouble()).thenReturn(0.01, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);
        final MatchResult result = match.play();

        assertTrue(result.getHomeTeamGoals() > result.getAwayTeamGoals());
    }

    @Test
    void playReturnsAwayTeamAsWinner() {
        when(mockRandom.nextDouble()).thenReturn(0.99, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);

        assertEquals(awayTeam, match.play().getWinner());
    }

    @Test
    void playReturnsAwayWinIsNotADraw() {
        when(mockRandom.nextDouble()).thenReturn(0.99, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);

        assertFalse(match.play().isDraw());
    }

    @Test
    void playAwayWinAwayGoalsGreaterThanHomeGoals() {
        when(mockRandom.nextDouble()).thenReturn(0.99, 0.01, 0.01);
        final Match match = new Match(homeTeam, awayTeam, mockStrategy, false, mockRandom);
        final MatchResult result = match.play();

        assertTrue(result.getAwayTeamGoals() > result.getHomeTeamGoals());
    }
    
}
