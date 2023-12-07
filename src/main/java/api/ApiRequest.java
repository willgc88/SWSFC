package api;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import teams.entity.Player;

import java.io.IOException;
import java.util.*;


public class ApiRequest {

    public static Map<String, List<Player>> apiRequest() {
        Random random = new Random();
        int[] teamsID = {34, 33, 42, 50, 571, 85, 116, 157, 165, 173, 182, 489, 505, 492, 487, 209, 211, 212, 247, 598, 529, 530, 536, 541, 550};
        String[] teams = new String[5];

        Set<Integer> usedIndices = new HashSet<>();

        for (int i = 0; i < teams.length; i++) {
            int x;
            do {
                x = random.nextInt(teamsID.length);
            } while (usedIndices.contains(x));

            teams[i] = String.format("https://api-football-v1.p.rapidapi.com/v3/players/squads?team=%d", teamsID[x]);
            usedIndices.add(x);
        }

        // teams array contains unique URLs
        Map<String, List<Player>> result = new HashMap<>();
        for (String url : teams) {
            mergeValues(result, makeAPIRequest(url));
        }

       shuffleLists(result);
        return result;
    }

    public static Map<String, List<Player>> makeAPIRequest(String url) {
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
        Map<String, List<Player>> teamMap = new HashMap<>();
        teamMap.put("Goalkeeper", extractPlayersByPosition(responseBody, "Goalkeeper"));
        teamMap.put("Defender", extractPlayersByPosition(responseBody, "Defender"));
        teamMap.put("Midfielder", extractPlayersByPosition(responseBody, "Midfielder"));
        teamMap.put("Attacker", extractPlayersByPosition(responseBody, "Attacker"));

        return teamMap;
    }
    public static List<Player> extractPlayersByPosition(String jsonResponse, String position) {
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
    private static void shuffleLists(Map<String, List<Player>> positionPlayersMap) {
        for (List<Player> players : positionPlayersMap.values()) {
            Collections.shuffle(players);
        }
    }

    private static void mergeValues(Map<String, List<Player>> result, Map<String, List<Player>> map) {
        for (Map.Entry<String, List<Player>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Player> values = entry.getValue();
            result.computeIfAbsent(key, k -> new ArrayList<>()).addAll(values);
        }
    }
}