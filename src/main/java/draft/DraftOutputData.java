package draft;

import teams.entity.Player;

public class DraftOutputData {
    Player[] players;
    String teamName;
    public DraftOutputData(Player[] players, String teamName) {
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
