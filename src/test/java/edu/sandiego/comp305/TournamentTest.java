package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {
    private Tournament tournament;

    private Team spain;

    @BeforeEach
    public void setUp(){
        final List<Team> teams = new ArrayList<>();

        spain = new Team(1, "Spain", "Es", 2165,
                780, 461, 138, 1591, 697);

        final Team argentina = new Team(2, "Argentina", "AR", 2113,
                1109, 610, 228, 2112, 1136);

        final Team france = new Team(3, "France", "FR", 2082,
                938, 474, 269, 1706, 1272);

        final Team england = new Team(4, "England", "EN", 2020,
                1161, 683, 216, 2719, 1120);

        teams.add(spain);
        teams.add(argentina);
        teams.add(france);
        teams.add(england);

        final Group groupA = new Group("A", teams);
        final List<Group> groups = new ArrayList<>();
        groups.add(groupA);

        tournament = new Tournament(groups, new EloStrategy());

    }

    @Test
    public void testRunGroupStage() {
        tournament.runGroupStage();
    }

    @Test
    public void testBuildBracket() {
        tournament.runGroupStage();
        tournament.buildBracket();
    }

    @Test
    public void testRunKnockout() {
        tournament.runGroupStage();
        tournament.buildBracket();
        final Team winner = tournament.runKnockout();
        assertNotNull(winner);
    }

    @Test
    public void testRunKnockoutWithoutBracket() {
        try {
            tournament.runKnockout();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertEquals("Bracket not built. Call buildBracket() first.",
                    e.getMessage());
        }
    }

    @Test
    public void testRunGroupStageEmptyGroups() {
        final Tournament emptyTournament = new Tournament(
                new ArrayList<>(), new EloStrategy());
        emptyTournament.runGroupStage();
    }

    @Test
    public void testRunKnockoutOneTeamRemaining() {
        final List<Team> teams = new ArrayList<>();
        teams.add(spain);
        final Bracket singleBracket = new Bracket(
                teams, 1, new EloStrategy());
        assertNotNull(singleBracket.getWinner());
    }
}
