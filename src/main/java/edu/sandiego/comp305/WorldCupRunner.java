package edu.sandiego.comp305;

import java.util.*;
import java.util.List;

public class WorldCupRunner {
    private WorldCupRunner() {
        // prevent instantiation
    }

    public static void main(final String[] args) {
        final CSVLoader loader = new CSVLoader(
                "data/test_teams.csv");
        final List<Team> teams = loader.loadTeams();

        final List<Group> groups = buildGroups(teams);
        final Tournament tournament = new Tournament(
                groups, new EloStrategy());
        final SimulatorResults results = new SimulatorResults();
        final Simulator simulator = new Simulator(tournament, results);
        simulator.runSimulations(Simulator.DEFAULT_SIMULATIONS);
    }

    private static List<Group> buildGroups(final List<Team> teams) {
        final Map<String, Team> teamMap = new HashMap<>();
        for (final Team team : teams) {
            teamMap.put(team.getCountryCode(), team);
        }
        final List<Group> groups = new ArrayList<>();

        groups.add(buildGroup("A", teamMap, List.of("MX", "KR", "ZA", "CZ")));
        groups.add(buildGroup("B", teamMap, List.of("CA", "CH", "QA", "BA")));
        groups.add(buildGroup("C", teamMap, List.of("BR", "MA", "SQ", "HT")));
        groups.add(buildGroup("D", teamMap, List.of("US", "PY", "AU", "TR")));
        groups.add(buildGroup("E", teamMap, List.of("DE", "EC", "CI", "CW")));
        groups.add(buildGroup("F", teamMap, List.of("NL", "JP", "TN", "SE")));
        groups.add(buildGroup("G", teamMap, List.of("BE", "IR", "EG", "NZ")));
        groups.add(buildGroup("H", teamMap, List.of("ES", "UY", "SA", "CV")));
        groups.add(buildGroup("I", teamMap, List.of("FR", "SN", "NO", "IQ")));
        groups.add(buildGroup("J", teamMap, List.of("PT", "CO", "UZ", "CG")));
        groups.add(buildGroup("L", teamMap, List.of("EN", "HR", "PA", "GH")));
        return groups;
    }

    private static Group buildGroup(final String name,
                                    final Map<String, Team> teamMap,
                                    final List<String> codes){
        final List<Team> teams = new ArrayList<>();
        for (final String code : codes) {
            teams.add(teamMap.get(code));
        }
        return new Group(name, teams);
    }
}
