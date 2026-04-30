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

        strongTeam = new Team(1, "Strong", "ST", 2000, 100, 70, 15, 180, 60);
        weakTeam = new Team(2, "Weak", "WK", 1600, 100, 30, 50, 80, 160);
        equalTeamA = new Team(1, "EqualA", "EA", 1800, 100, 50, 25, 130, 100);
        equalTeamB = new Team(2, "EqualB", "EB", 1800, 100, 50, 25, 130, 100);
    }

    @Test
    void getResultIsBetweenZeonAndOne() {
        final double probability = strategy.getProbability(strongTeam, weakTeam);

        assertTrue(probability >= 0.0 && probability <= 1.0);
    }

    @Test
    void getResultIsNeverNaN() {
        assertFalse(Double.isNaN(strategy.getProbability(strongTeam, weakTeam)));
    }

    @Test
    void zeroGoalsConcededAndDoesNotCrash() {
        final Team noGoalsConceded = new Team(1, "noGoalsConceded", "NC", 1800, 100, 50, 25, 130, 0);

        strategy.getProbability(noGoalsConceded, equalTeamA);
    }

    @Test
    void zeroWinsAndDoesNotCrash() {
        final Team noWins = new Team(1, "noWins", "NW", 1800, 100, 0, 65, 80, 150);

        strategy.getProbability(noWins, equalTeamA);
    }

    @Test
    void extremeRatingDiffButInRange() {
        final Team elite = new Team(1, "Elite", "E", 2400, 100, 80, 10, 200, 50);
        final Team mid = new Team(2, "Mid", "M", 800, 100, 10, 70, 50, 200);
        final double probability = strategy.getProbability(elite, mid);

        assertTrue(probability >= 0.0 && probability <= 1.0);
        assertFalse(Double.isNaN(probability));
    }
}