package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TournamentFactoryTest {

    private List<Team> teams;

    @BeforeEach
    public void setUp() {
        final CSVLoader loader = new CSVLoader(
                "data/test_teams.csv");

        teams = loader.loadTeams();
    }

    @Test
    public void testBuildGroupsNotNull() {
        final List<Group> groups = TournamentFactory.buildGroups(teams);
        assertNotNull(groups);
    }

    @Test
    public void testBuildGroupSize() {
        final List<Group> groups = TournamentFactory.buildGroups(teams);
        assertEquals(12, groups.size());
    }

    @Test
    public void testBuildGroupsNotNullEntries() {
        final List<Group> groups = TournamentFactory.buildGroups(teams);
        for (final Group group : groups) {
            assertNotNull(group);
        }
    }
}
