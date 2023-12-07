import api.ApiRequest;
import org.junit.Test;
import teams.entity.Player;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ApiTest {

    @Test
    public void testMakeAPIRequest() {
        String testUrl = "https://api-football-v1.p.rapidapi.com/v3/players/squads?team=34";

        Map<String, List<Player>> result = ApiRequest.makeAPIRequest(testUrl);

        assertNotNull(result);
    }

    @Test
    public void testExtractPlayersByPosition() {
        String testJsonResponse = "{\"response\": [{\"team\": {\"name\": \"TeamName\"}, \"players\": [{\"id\": 1, \"name\": \"Player1\", \"position\": \"Defender\"}]}]}";

        List<Player> defenders = ApiRequest.extractPlayersByPosition(testJsonResponse, "Defender");

        assertNotNull(defenders);
    }

}

