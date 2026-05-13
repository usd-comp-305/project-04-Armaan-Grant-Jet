# 2026 World Cup Simulator

A simulator that scrapes historical ELO rating data for all 48 qualified nations and predicts the winner of the 2026 FIFA World Cup.

## How It Works

The data pipeline fetches live data from [eloratings.net](https://eloratings.net) and filters it down to only the 48 qualified teams, producing a CSV with the following stats per team:

| Column | Description |
|---|---|
| `Ranking` | Current world ranking |
| `CountryNames` | Full country name |
| `Country` | Country code |
| `Rating` | ELO rating |
| `TotalGames` | Total games played |
| `TotalWins` | Total wins |
| `TotalLosses` | Total losses |
| `GoalsScored` | Total goals scored |
| `GoalsConceded` | Total goals conceded |

## Architecture

```mermaid
classDiagram
    class PredictionStrategy {
        <<interface>>
        +getProbability(home: Team, away: Team) double
    }
    class RandomProvider {
        <<interface>>
        +nextDouble() double
    }
    class CSVLoader {
        -COLUMNS_OF_FILE : int
        -filePath : String
        +loadTeams() List~Team~
        -parseLine(line: String) Team
    }
    class Team {
        -ranking : int
        -countryName : String
        -countryCode : String
        -rating : int
        -totalGames : int
        -totalWins : int
        -totalLosses : int
        -goalsFor : int
        -goalsAgainst : int
        +getRating() int
        +getWinRate() double
        +getGoalDifference() int
        +getGoalsFor() int
        +getGoalsAgainst() int
        +getTotalGames() int
        +getTotalWins() int
        +getTotalLosses() int
        +getRanking() int
        +getCountryName() String
        +getCountryCode() String
    }
    class EloStrategy {
        -ELO_SCALE : double
        -ELO_BASE : double
        -WEIGHT_ELO : double
        -WEIGHT_WINRATE : double
        -WEIGHT_GOALDIFF : double
        -WEIGHT_DEFENSE_ATT : double
        -GOALDIFF_SHIFT : double
        -EPSILON : double
        +getProbability(home: Team, away: Team) double
        -elo(home: Team, away: Team) double
        -winRate(home: Team, away: Team) double
        -goalDiff(home: Team, away: Team) double
        -defenseAtt(home: Team, away: Team) double
    }
    class MatchResult {
        -winner : Team
        -homeTeam : Team
        -awayTeam : Team
        -homeGoals : int
        -awayGoals : int
        -isDraw : boolean
        +getWinner() Team
        +getHomeTeam() Team
        +getAwayTeam() Team
        +getIsDraw() boolean
        +getHomeGoals() int
        +getAwayGoals() int
    }
    class Match {
        -DRAW_SHARE : double
        -BASE_GOALS : double
        -PENALTY_WIN_PROBABILITY : double
        -homeTeam : Team
        -awayTeam : Team
        -isKnockout : boolean
        +play() MatchResult
        +simulatePenalties() Team
        -simulateGoals(lambda: double) int
    }
    class Standings {
        -team : Team
        -points : int
        -goalsFor : int
        -goalsAgainst : int
        +addResult(result: MatchResult) void
        +getPoints() int
        +getGoalDiff() int
        +getGoalsFor() int
        +getGoalsAgainst() int
        +getTeam() Team
        +reset() void
    }
    class Group {
        -name : String
        -teams : List~Team~
        -standings : List~Standings~
        +playGroupStage() void
        +getQualifiers() List~Team~
        +getStandings() List~Standings~
        +getThirdPlace() Standings
        +getTeams() List~Team~
        +getName() String
        +reset() void
    }
    class Bracket {
        -MATCH_PAIR : int
        -teams : List~Team~
        -round : int
        +playRound() List~Team~
        +getWinner() Team
        +getCurrentRound() int
        -playMatch(homeTeam: Team, awayTeam: Team) Team
    }
    class Tournament {
        -SINGLE_ELIMINATION : int
        -groups : List~Group~
        -bracket : Bracket
        +runGroupStage() void
        +buildBracket() void
        +runKnockout() Team
        +reset() void
        -playNextRound(teams: List~Team~) List~Team~
        -getBestThirdPlace(standings: List~Standings~) List~Team~
        -findBestThird(remaining: List~Standings~) Standings
        -isBetter(current: Standings, best: Standings) boolean
    }
    class SimulatorResults {
        -winCounts : Map~Team~
        -totalRuns : int
        +recordWin(team: Team) void
        +getWinProbability(team: Team) double
        +getTotalRuns() int
        +printResults() void
        -printTeamResult(team: Team) void
        -findTopTeam(remaining: List~Team~) Team
    }
    class Simulator {
        +DEFAULT_SIMULATIONS : int
        -tournament : Tournament
        -result : SimulatorResults
        +runSimulations(numSimRun: int) void
    }
    class TournamentFactory {
        +buildGroups(teams: List~Team~) List~Group~
        -buildTeamMap(teams: List~Team~) Map~String~
        -buildGroup(name: String, codes: List~String~) Group
    }
    class WorldCupRunner {
        +main(args: String[]) void
    }

    EloStrategy ..|> PredictionStrategy

    CSVLoader ..> Team : creates
    TournamentFactory ..> Group : creates
    TournamentFactory ..> Team : uses
    WorldCupRunner ..> CSVLoader : uses
    WorldCupRunner ..> TournamentFactory : uses
    WorldCupRunner ..> Tournament : uses
    WorldCupRunner ..> SimulatorResults : uses
    WorldCupRunner ..> Simulator : uses

    Match --> Team
    Match --> PredictionStrategy
    Match --> RandomProvider
    Match ..> MatchResult : creates

    Standings --> Team
    Standings ..> MatchResult : reads

    Group *-- Standings
    Group o-- Team

    Bracket o-- Team
    Bracket --> PredictionStrategy
    Bracket ..> Match : creates

    Tournament *-- Group
    Tournament o-- Bracket
    Tournament --> PredictionStrategy

    Simulator --> Tournament
    Simulator --> SimulatorResults
```

## Project Structure

```
├── WorldCupData.py         # Main script — scrapes and outputs CSV
├── DataColumns.py          # Column index config for the TSV source
├── ListOfQualifiedTeams.py # List of all 48 qualified teams
└── QualifiedWorldCupTeams.csv  # Generated output (run script to produce)
```

## Setup

**Prerequisites:** Python 3.x

**Install dependencies:**
```bash
pip install requests pandas
```

## Usage

Run the data pipeline to generate the CSV:
```bash
python WorldCupData.py
```

This will print the dataframe to the terminal and produce `QualifiedWorldCupTeams.csv` in the same directory.

## Data Source

Live data is pulled from [eloratings.net](https://eloratings.net) at runtime, so the stats reflect current standings each time the script is run.