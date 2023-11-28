package teams.entity;

import org.json.JSONArray;
import org.json.JSONObject;
import teams.entity.Player;
import teams.entity.PlayerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerData {
    private List<Player> players;
    private PlayerFactory playerFactory;



    public PlayerData() {
        this.players = new ArrayList<>();
        this.playerFactory = new PlayerFactory();
    }

    public void savePlayerData(JSONArray playerDataArray) {
        for (int i = 0; i < playerDataArray.length(); i++) {
            JSONObject playerData = playerDataArray.getJSONObject(i);
            Player player = PlayerFactory.create(playerData);
            players.add(player);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
