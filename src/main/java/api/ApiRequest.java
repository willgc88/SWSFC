package api;

import okhttp3.*;

import java.io.IOException;
import java.util.Random;

public class ApiRequest {
    public static Response apiRequest(String args) {
        OkHttpClient client = new OkHttpClient();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomPlayerId = random.nextInt(1000) + 1;

            Request request = new Request.Builder()
                    .url("https://api-football-v1.p.rapidapi.com/v3/players?id=" + randomPlayerId + "&season=2020")
                    .get()
                    .addHeader("X-RapidAPI-Key", "168092cdc6msh053297dfb2b0373p1b37abjsnf5ab4ec25b34")
                    .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String responseBody = response.body().string();
                System.out.println(responseBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}