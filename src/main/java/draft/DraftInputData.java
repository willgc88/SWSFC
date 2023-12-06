package draft;

import teams.entity.Player;

public class DraftInputData {
    Player[] players;
    String teamName;
    public DraftInputData(Player[] players, String teamName) {
        this.teamName = teamName;
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getTeamName() {
        return teamName;
    }
}
