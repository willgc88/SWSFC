package app;

import draft.finalDraft.interfaceAdapters.FinalDraftState;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import teams.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RatingCalculator {

    public String RatingCalculator(FinalDraftState state) {
        float rating = 0;
        state.getPlayers();
        Player [] listOfPlayers = new Player[11];
        listOfPlayers[0] = state.getPlayers()[0];
        listOfPlayers[1]= state.getPlayers()[1];
        listOfPlayers[2] = state.getPlayers()[2];
        listOfPlayers[3] = state.getPlayers()[3];
        listOfPlayers[4] = state.getPlayers()[4];
        listOfPlayers[5] = state.getPlayers()[5];
        listOfPlayers[6] = state.getPlayers()[6];
        listOfPlayers[7] = state.getPlayers()[7];
        listOfPlayers[8]= state.getPlayers()[8];
        listOfPlayers[9] = state.getPlayers()[9];
        listOfPlayers[10] = state.getPlayers()[10];

        for (Player player : listOfPlayers) {
            rating += GetStats(player.getPlayerID());
        }

        int chemistry = getChemistry(listOfPlayers);
        int roundedValue = Math.round(rating+chemistry);

        return "Your rating is:" + rating +"! Your chemistry is: " + chemistry +". FINAL RATING: " + roundedValue;
    }

    private static int getChemistry(Player[] listOfPlayers) {
        Map<String, Integer> clubOccurrences = new HashMap<>();

        // Loop to count occurrences
        for (Player player : listOfPlayers) {
            String club = player.getClub();

            // Update club occurrences in the map
            clubOccurrences.put(club, clubOccurrences.getOrDefault(club, 0) + 1);
        }

        // Calculate chemistry
        int chemistry = 0;
        for (int occurrences : clubOccurrences.values()) {
            if (occurrences > 1) {
                chemistry += (occurrences * 3) + 1;
            }
        }
        return chemistry;
    }

    private static float GetStats(int playerID) {
        OkHttpClient client = new OkHttpClient();
        String responseBody;
        Request request = new Request.Builder()
                .url(String.format("https://api-football-v1.p.rapidapi.com/v3/players?id=%d&season=2019", playerID))
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

        float rating = 0;
        Pattern pattern = Pattern.compile("\"rating\":\"(\\d+\\.\\d+)\"");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            rating = Float.parseFloat(matcher.group(1));
        }


        return rating;
    }
}
