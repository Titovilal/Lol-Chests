package es.tprograms.dao;

import es.tprograms.model.Config;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * The DataDao class provides functionality for retrieving data from an external
 * source. It offers methods for getting the encrypted ID for a summoner, the
 * latest game version, and a map with champions IDs and their respective names.
 *
 * @author Titovilal
 * @version 1.0.0
 */
public final class DataDao {

    /**
     * Downloads the images of the given champions.
     *
     * @param champions a map of champion IDs and names
     * @param version the version of the champions to download
     * @throws IOException if an I/O error occurs while reading from the URL or
     * writing to the file
     */
    public static final void downloadChampionsSquare(Map<Integer, String> champions, String version) throws IOException {
        for (Map.Entry<Integer, String> entry : champions.entrySet()) {
            String championName = entry.getValue();
            downloadChampionSquare(championName, version);
        }
    }

    /**
     * Downloads the image of the given champion.
     *
     * @param championName the name of the champion
     * @param version the version of the champion to download
     * @throws IOException if an I/O error occurs while reading from the URL or
     * writing to the file
     */
    private static void downloadChampionSquare(String championName, String version) throws IOException {
        String urlString = "http://ddragon.leagueoflegends.com/cdn/" + version + "/img/champion/" + championName + ".png";
        URL url = new URL(urlString);
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        try ( BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("resources/icons/" + championName + ".png"))) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                out.write(dataBuffer, 0, bytesRead);
            }
        }
    }

    /**
     * Gets the encrypted ID for a summoner with a given game name and routing
     * platform.
     *
     * @param routing the routing platform for the summoner.
     * @param gameName the game name of the summoner.
     * @return the encrypted ID for the summoner.
     * @throws IOException if an error occurs when making the HTTP request.
     */
    public static final String getEncryptedId(String routing, String gameName) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://" + routing
                        + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/"
                        + gameName + "?api_key=" + Config.getAPI_KEY())
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
     * Gets the latest game version.
     *
     * @return a string with the latest game version.
     * @throws IOException if an error occurs when making the HTTP request.
     */
    @SuppressWarnings("null")
    public static final String getLatestVersion() throws IOException {
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
    public static final Map<Integer, String> getChampionsMap(String version) throws IOException {
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
            int id = champion.getInt("key");
            String name = champion.getString("id");
            championMap.put(id, name);
        }
        return championMap;
    }
}
