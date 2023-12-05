package teams.entity;


public class PlayerFactory {


    public PlayerFactory() {
    }

    //public Player createPlayerFromApi(int playerId) {
    //        try {
    //            String apiUrl = "https://api-football-v1.p.rapidapi.com/v3/players?id=" + playerId + "&season=2020";
    //            Response response = (1);
    //
    //            if (response.isSuccessful()) {
    //                String responseBody = response.body().string();
    //                JSONArray playerArray = new JSONObject(responseBody).getJSONArray("response");
    //
    //                if (playerArray.length() > 0) {
    //                    JSONObject playerData = playerArray.getJSONObject(0);
    //                    return create(playerData);
    //                }
    //            }
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //
    //        return null;
    //    }

    public static Player create(JSONObject playerData) {

        String firstname = playerData.getString("firstname");
        String lastname = playerData.getString("lastname");
        String nation = playerData.getString("nationality");
        String club = getClubName(playerData);
        int age = playerData.getInt("age");
        int playerID = playerData.getJSONObject("player").getInt("id");

        //return new Player(firstname, lastname, nation, club, age, playerID);
        return null;
    }
}
