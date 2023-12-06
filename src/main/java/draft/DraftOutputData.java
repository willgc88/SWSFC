package draft;

import teams.entity.Player;

public class DraftOutputData {
    Player[] players;
    String teamName;
    public DraftOutputData(Player[] players, String teamName) {
        this.teamName = teamName;
        this.players = players;
    }

}
