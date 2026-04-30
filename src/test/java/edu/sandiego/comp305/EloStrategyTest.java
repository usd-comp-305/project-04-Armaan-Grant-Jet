package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EloStrategyTest {

    private EloStrategy strategy;

    private Team strongTeam;

    private Team weakTeam;

    private Team equalTeamA;

    private Team equalTeamB;

    @BeforeEach
    void setUp() {
        strategy = new EloStrategy();

        strongTeam = new Team(
            1, "Strong", "ST", 
            2000, 100, 70, 15, 180, 60);
        weakTeam = new Team(
            2, "Weak", "WK", 
            1600, 100, 30, 50, 80, 160);
        equalTeamA = new Team(
            1, "EqualA", "EA", 
            1800, 100, 50, 25, 130, 100);
        equalTeamB = new Team(
            2, "EqualB", "EB", 
            1800, 100, 50, 25, 130, 100);
    }

    @Test
    void getResultIsBetweenZeonAndOne() {
        final double probability = 
            strategy.getProbability(strongTeam, weakTeam);

        assertTrue(probability >= 0.0 
            && probability <= 1.0);
    }

    @Test
    void getResultIsNeverNaN() {
        assertFalse(Double.isNaN(
            strategy.getProbability(strongTeam, weakTeam)));
    }

    @Test
    void zeroGoalsConcededAndDoesNotCrash() {
        final Team noGoalsConceded = new Team(
            1, "noGoalsConceded", "NC", 
            1800, 100, 50, 25, 130, 0);
        final double probability = 
            strategy.getProbability(noGoalsConceded, equalTeamA);

        assertFalse(Double.isNaN(probability));
    }

    @Test
    void zeroWinsAndDoesNotCrash() {
        final Team noWins = new Team(
            1, "noWins", "NW", 
            1800, 100, 0, 65, 80, 150);
        final double probability = strategy.getProbability(noWins, equalTeamA);

        assertFalse(Double.isNaN(probability));
    }

    @Test
    void extremeRatingDiffButInRange() {
        final Team elite = new Team(
            1, "Elite", "E", 
            2400, 100, 80, 10, 200, 50);
        final Team mid = new Team(
            2, "Mid", "M", 
            800, 100, 10, 70, 50, 200);
        final double probability = 
            strategy.getProbability(elite, mid);

        assertTrue(probability >= 0.0 
            && probability <= 1.0);
        assertFalse(Double.isNaN(probability));
        assertTrue(probability > 0.5);
    }

    @Test
    void probabilitieSumToOne() {
        final double probabilityA =  strategy.getProbability(
            strongTeam, weakTeam);
        final double probabilityB =  strategy.getProbability(
            weakTeam, strongTeam);

        assertEquals(1.0, 
            probabilityA + probabilityB, 1e-9);
    }

    @Test
    void getProbabilityIdenticalTeamsReturnHalf() {
        assertEquals(0.5, 
            strategy.getProbability(
                equalTeamA, equalTeamB), 
                1e-9);
    }

    @Test
    void strongerTeamIsFavoredToWin() {
        assertTrue(strategy.getProbability(
            strongTeam, weakTeam) > 0.5);
    }

    @Test
    void higherRatingIncreasesProbability() {
        final Team higherRatedTeam = new Team(
            1, "High", "H", 
            2000, 100, 50, 25, 130, 100);
        final Team lowerRatedTeam = new Team(
            2, "Low", "L", 
            1600, 100, 50, 25, 130, 100);

        assertTrue(strategy.getProbability(
            higherRatedTeam, lowerRatedTeam) > 0.5);
    }

    @Test
    void higherWinRateIncreasesProbability() {
        final Team moreWinsTeam = new Team(
            1, "moreWins", "MW", 
            1800, 100, 70, 15, 130, 100);
        final Team fewerWinsTeam = new Team(
            2, "fewerWins", "FW", 
            1800, 100, 30, 35, 130, 100);

        assertTrue(strategy.getProbability(
            moreWinsTeam, fewerWinsTeam) > 0.5);
    }

    @Test
    void betterDefenseIncreasesProbability() {
        final Team goodDefense =  new Team(
            1, "goodDefense", "GD", 
            1800, 100, 50, 25, 130, 60);
        final Team badDefense = new Team(
            2, "badDefense", "BD", 
            1800, 100, 50, 25, 130, 180);

        assertTrue(strategy.getProbability(
            goodDefense, badDefense) > 0.5);
    }

    @Test
    void betterGoalDifferenceIncreasesProbability() {
        final Team betterGoalDiff = new Team(
            1, "betterGoalDifference", "BD", 
            1800, 100, 50, 25, 180, 80);
        final Team worseGoalDiff = new Team(
            2, "worseGoalDifference", "WD", 
            1800, 100, 50, 25, 80, 180);

        assertTrue(strategy.getProbability(
            betterGoalDiff, worseGoalDiff) > 0.5);
    }
}
