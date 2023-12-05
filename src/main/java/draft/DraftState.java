package draft;

import teams.entity.Player;

import java.util.List;
import java.util.Map;

public class DraftState {
    public String teamName;
    public Map<String, List<Player>> randomPlayers;
    public DraftState(DraftState copy) {
        teamName = copy.teamName;
    }
    public DraftState() {};

    public String getTeamName() {
        return this.teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setRandomPlayers(Map<String, List<Player>> map) {
        this.randomPlayers = map;
    }

    public Map<String, List<Player>> getRandomPlayers() {
        return randomPlayers;
    }
}
