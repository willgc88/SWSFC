package draft;

import teams.entity.Player;

public class DraftInputData {
    Player[] players;
    public DraftInputData(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }
}
