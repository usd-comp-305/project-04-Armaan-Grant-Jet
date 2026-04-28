package edu.sandiego.comp305;
import java.util.List;

public class Group {
    private final String name;

    private final List<Team> teams;

    private final List<Standings> standings;

    public Group(final String name, final List<Team> teams,
                 final List<Standings> standings){
        this.name = name;
        this.teams = teams;
        this.standings = standings;
    }

    public void playGroupStage(){

    }

    public List<Team> getQualifiers(){
        return null;
    }

    public List<Standings> getStandings(){
        return null;
    }

    public String getName(){
        return name;
    }
}

