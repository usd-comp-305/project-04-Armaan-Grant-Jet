package edu.sandiego.comp305;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;


public class TournamentTest {
    @Test
    public void testRunGroupStage() {
        final List<Team> teams = new ArrayList<>();

        final Team spain = new Team(1, "Spain", "Es", 2165,
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

        final Tournament tournament = new Tournament(groups);
        tournament.runGroupStage();

        assertNotNull(groupA.getStandings());

    }
}
