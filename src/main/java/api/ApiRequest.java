package api;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import teams.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ApiRequest {
    public static void main(String[] args) {
        String response = apiRequest();
        System.out.println(response);
        List<Player> defenders = extractPlayersByPosition(response, "Defender");
        for (Player defender : defenders) {
            System.out.println(defender.getName() + " ," + defender.getPosition() + " ," + defender.getClub() );
        }

    }

    public static String apiRequest() {
        Random random = new Random();
        int [] teamsID = {50,33,47,42,40,529,530,541,9568,157, 165, 489,492,496, 505, 49, 85, 91};
        String [] teams = new String [5];

            for (int i = 0; i < teams.length; i++) {
                int x = random.nextInt(teamsID.length);
                teams[i] = String.format("https://api-football-v1.p.rapidapi.com/v3/players/squads?team=%d", teamsID[x]);
            }

            return  makeAPIRequest(teams[0]);
    }

    public static String makeAPIRequest(String url) {
        OkHttpClient client = new OkHttpClient();
        String responseBody;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", "168092cdc6msh053297dfb2b0373p1b37abjsnf5ab4ec25b34")
                .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return responseBody;
    }
    private static List<Player> extractPlayersByPosition(String jsonResponse, String position) {
        List<Player> defenders = new ArrayList<>();

        // Parse the JSON response using org.json library
        JSONObject responseObject = new JSONObject(jsonResponse);

        if (responseObject.has("response")) {
            JSONArray playersArray = responseObject.getJSONArray("response").getJSONObject(0)
                    .getJSONArray("players");

            for (int i = 0; i < playersArray.length(); i++) {
                JSONObject playerObject = playersArray.getJSONObject(i);
                String clubName = responseObject.getJSONArray("response").getJSONObject(0)
                        .getJSONObject("team").getString("name");
                if (playerObject.has("position") && playerObject.getString("position").equals(position)) {
                    int playerId = playerObject.getInt("id");
                    String playerName = playerObject.getString("name");
                    Player defender = new Player(playerName, clubName, position, playerId);
                    defenders.add(defender);
                }
            }
        }

        return defenders;
    }
}