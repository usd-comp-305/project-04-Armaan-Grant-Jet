package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {
    private Team spain;
    private Team france;
    private Team brazil;
    private Team argentina;
    private Prediction ;

    @BeforeEach
    void setUp() {
        spain = new Team(1, "Spain", "ES",
                2165, 780, 461, 138, 1591, 697);
        argentina = new Team(2, "Argentina", "AR",
                2113, 1109, 610, 228, 2112, 1136);
        france = new Team(3, "France", "FR",
                2082, 938, 474, 269, 1706, 1272);
        brazil = new Team(5, "Brazil", "BR",
                1984, 1065, 670, 172, 2294, 954);
    }

    @Test
    void groupHasCorrectName() {
        final Group group = new Group("A",
                List.of(spain, france, brazil, argentina));
        assertEquals("A", group.getName());
    }

    @Test
    void groupCreatesStandingsForEachTeam() {
        final Group group = new Group("A",
                List.of(spain, france, brazil, argentina));
        assertEquals(4, group.getStandings().size());
    }

    @Test
    void standingsContainAllTeams() {
        final Group group = new Group("A",
                List.of(spain, france, brazil, argentina));
        final List<Team> teamsInStandings = group.getStandings()
                .stream().map(Standings::getTeam).toList();
        assertTrue(teamsInStandings.contains(spain));
        assertTrue(teamsInStandings.contains(france));
        assertTrue(teamsInStandings.contains(brazil));
        assertTrue(teamsInStandings.contains(argentina));
    }

    @Test
    void standingsStartWithZeroPoints() {
        final Group group = new Group("A",
                List.of(spain, france, brazil, argentina));
        for (final Standings s : group.getStandings()) {
            assertEquals(0, s.getPoints());
        }
    }

    @Test
    void getStandingsReturnsFourStandings() {
        final Group group = new Group("A",
                List.of(spain, france, brazil, argentina));
        assertEquals(4, group.getStandings().size());
    }

    @Test
    void getQualifiersReturnsTwoTeams() {
        final Group group = new Group("A",
                List.of(spain, france, brazil, argentina));
        assertEquals(2, group.getQualifiers().size());
    }
}
