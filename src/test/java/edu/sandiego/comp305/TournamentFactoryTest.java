package edu.sandiego.comp305;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

    @Test
    public void testGroupAContainsCorrectTeams() {
        final List<Group> groups = TournamentFactory.buildGroups(teams);
        final Group groupA = groups.get(0);
        final List<Team> groupATeams = groupA.getTeams();

        final List<String> codes = new ArrayList<>();

        for (final Team team : groupATeams) {
            codes.add(team.getCountryCode());
        }

        assertTrue(codes.contains("MX"));
        assertTrue(codes.contains("KR"));
        assertTrue(codes.contains("ZA"));
        assertTrue(codes.contains("CZ"));
    }

    @Test
    public void testBuildGroupsWithInvalidTeam() {
        final List<Group> groups = TournamentFactory.buildGroups(teams);
        final Group groupA = groups.get(0);
        final List<Team> groupATeams = groupA.getTeams();

        final List<String> codes = new ArrayList<>();

        for (final Team team: groupATeams) {
            codes.add(team.getCountryCode());
        }
        assertFalse(codes.contains("VV"));
    }
}
