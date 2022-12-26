package es.tprograms.dao;

import es.tprograms.model.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class to acces all nonrelated summoner data
 *
 * @author Titovilal
 */
public class DataDao {
    
    /**
     * Get the encrypted id from a game name and routing platform
     * @param routing
     * @param gameName
     * @return
     * @throws IOException 
     */
    public final String getEncryptedId(String routing, String gameName) throws IOException {
        
        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder()
                .url("https://" + routing
                        + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/"
                        + gameName + "?api_key=" + Constants.getAPI())
                .get()
                .build();
        
        Response response;
        response = client.newCall(request).execute();
        @SuppressWarnings("null")
        String responseString = response.body().string();
        JSONObject responseJson = new JSONObject(responseString);
        
        return responseJson.getString("id");
    }

    /**
     * Get the lastest game version
     *
     * @return String with the lastest game version
     * @throws java.io.IOException
     */
    @SuppressWarnings("null")
    public final String getLatestVersion() throws IOException {
        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder()
                .url("https://ddragon.leagueoflegends.com/api/versions.json")
                .get()
                .build();
        
        Response response = client.newCall(request).execute();
        
        String responseString;
        responseString = response.body().string();
        JSONArray versionArray = new JSONArray(responseString);
        return versionArray.getString(0);
    }

    /**
     * Get a map with the champions ids and their respective name
     *
     * @param version
     * @return Map<Integer,String>
     * @throws java.io.IOException
     */
    public final Map<Integer, String> getMapIdsChampions(String version) throws IOException {
        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder()
                .url("https://ddragon.leagueoflegends.com/cdn/"
                        + version + "/data/en_US/champion.json")
                .get()
                .build();
        
        Response response;
        response = client.newCall(request).execute();
        @SuppressWarnings("null")
        String responseString = response.body().string();
        JSONObject responseJson = new JSONObject(responseString);
        JSONObject data = responseJson.getJSONObject("data");
        
        Map<Integer, String> championMap = new HashMap<>();
        for (String key : data.keySet()) {
            JSONObject champion = data.getJSONObject(key);
            int id = champion.getInt("id");
            String name = champion.getString("name");
            championMap.put(id, name);
        }
        return championMap;
    }
}
