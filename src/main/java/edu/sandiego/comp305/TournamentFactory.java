package edu.sandiego.comp305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentFactory {

    private TournamentFactory() {
        //prevent instantiation
    }

    public static List<Group> buildGroups(final List<Team> teams) {
        final Map<String, Team> teamMap = buildTeamMap(teams);

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
        groups.add(buildGroup("J", teamMap, List.of("AR", "AT", "DZ", "JO")));
        groups.add(buildGroup("K", teamMap, List.of("PT", "CO", "UZ", "CG")));
        groups.add(buildGroup("L", teamMap, List.of("EN", "HR", "PA", "GH")));

        return groups;
    }

    private static Map<String, Team> buildTeamMap(final List<Team> teams) {
        final Map<String, Team> teamMap = new HashMap<>();
        for (final Team team : teams) {
            teamMap.put(team.getCountryCode(), team);
        }
        return teamMap;
    }

    private static Group buildGroup(final String name,
                                    final Map<String, Team> teamMap,
                                    final List<String> codes) {
        final List<Team> groupTeams = new ArrayList<>();
        for (final String code : codes) {
            final Team team = teamMap.get(code);
            if (team == null) {
                System.out.println("Warning: no team found for code: " + code);
                continue;
            }
            groupTeams.add(team);
        }
        return new Group(name, groupTeams);
    }

}
