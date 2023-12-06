package draft.finalDraft.interfaceAdapters;

import teams.entity.Player;

import java.util.List;
import java.util.Map;

public class FinalDraftState {
    public String teamName;
    public Player[] players;
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

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }
}
