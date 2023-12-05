package draft.finalDraft.interfaceAdapters;

import teams.entity.Player;

import java.util.List;
import java.util.Map;

public class FinalDraftState {
    public String teamName;
    public Map<String, List<Player>> Players;
    public FinalDraftState(FinalDraftState copy) {
        teamName = copy.teamName;
    }
    public FinalDraftState() {};

    public String getTeamName() {
        return this.teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPlayers(Map<String, List<Player>> map) {
        this.Players = map;
    }

    public Map<String, List<Player>> getPlayers() {
        return Players;
    }
}
