package api;

import okhttp3.*;

import java.io.IOException;

public class ApiRequest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-football-v1.p.rapidapi.com/v3/players?id=276&season=2023")
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
}