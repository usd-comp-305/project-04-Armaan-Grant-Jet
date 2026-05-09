package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import java.util.List;

public class BracketTest {
    @Test
    public void testPlayRound() {
        final List<Team> teams = new ArrayList<>();
        final Team spain = new Team(1, "Spain", "ES", 2165,
                780, 461, 138,1591, 697);

        final Team argentina = new Team(1, "Argentina", "AR", 2113,
                1109, 610, 228, 2112, 1136);

        teams.add(spain);
        teams.add(argentina);

        final Bracket bracket = new Bracket(teams, 1, new EloStrategy());
        final List<Team> winners = bracket.playRound();

        assertEquals(1, winners.size());
    }

    @Test
    public void testFourTeamsPlayRound() {
        final List<Team> teams = new ArrayList<>();

        final Team spain = new Team(1, "Spain", "ES", 2165,
                780, 461, 138, 1591, 697);
        final Team argentina = new Team(2, "Argentina", "AR", 2113,
                1109, 610, 228, 2112, 1136);
        final Team france = new Team(3, "France", "FR", 2082,
                938, 474, 269, 1706, 1272);
        final Team england = new Team(4, "England", "EN", 2020,
                1161,683, 216, 2719, 1129);

        teams.add(spain);
        teams.add(argentina);
        teams.add(france);
        teams.add(england);

        final Bracket bracket = new Bracket(teams, 1, new EloStrategy());
        final List<Team> winners = bracket.playRound();

        assertEquals(2, winners.size());
    }

    @Test
    public void testGetWinner() {
        final List<Team> teams = new ArrayList<>();

        final Team spain = new Team(1, "Spain", "ES", 2165,
                780, 461, 138, 1591, 697);

        final Team argentina = new Team(2, "Argentina", "AR", 2113,
                1109, 610, 228, 2112, 1136);

        teams.add(spain);
        teams.add(argentina);

        final Bracket bracket = new Bracket(teams, 1, new EloStrategy());
        bracket.playRound();

        assertNotNull(bracket.getWinner());
    }
}
