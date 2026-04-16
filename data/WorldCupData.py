from ListOfQualifiedTeams import qualified_teams
from DataColumns import DATA
import requests
import pandas as PD
from io import StringIO

PD.set_option("display.show_dimensions", False)

WORLD_URL = "https://eloratings.net/World.tsv"
COUNTRY_NAMES_URL = "https://eloratings.net/en.teams.tsv"

def fetch_tsv(url):
    response = requests.get(url)
    
    return PD.read_csv(StringIO(response.text), sep="\t", header=None)
    
def get_qualified_countries_stats():
    qualified_countries_dataframe = fetch_tsv(WORLD_URL)
    qualified_countries_dataframe = qualified_countries_dataframe[DATA["required_world_data"]]
    qualified_countries_dataframe.columns = DATA["column_names"]
    
    return qualified_countries_dataframe

def get_qualified_country_names():
    qualified_country_names_dataframe = PD.read_csv(StringIO(requests.get(COUNTRY_NAMES_URL).text), sep="\t", header=None, usecols=[0,1], on_bad_lines="skip")
    qualified_country_names_dataframe.columns = ["Country", "CountryNames"]

    return qualified_country_names_dataframe

def filter_qualified_teams(dataframe, teams):
    filter_teams_dataframe = dataframe[dataframe["CountryNames"].isin(teams)]
    col = list(filter_teams_dataframe.columns)
    col.insert(1, col.pop(col.index("CountryNames")))

    return filter_teams_dataframe[col]

def build_final_qualified_teams_dataframe():
    statistics = get_qualified_countries_stats()
    country_names = get_qualified_country_names()

    merged_dataframe = PD.merge(statistics, country_names, on="Country")
    filtered_dataframe = filter_qualified_teams(merged_dataframe, qualified_teams)

    return filtered_dataframe.sort_values(by="Rating", ascending=False)

if __name__ == "__main__":
    final_dataframe = build_final_qualified_teams_dataframe()
    print(final_dataframe)
    #final_dataframe.to_csv("QualifiedWorldCupTeams.csv", index=False)

