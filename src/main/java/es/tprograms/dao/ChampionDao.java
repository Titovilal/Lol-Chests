package es.tprograms.dao;

import com.google.gson.Gson;
import es.tprograms.model.Champion;
import es.tprograms.model.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Titovilal
 */
public final class ChampionDao {

    /**
     *
     * @param encryptedId
     * @param ChampionId
     * @return
     * @throws IOException
     */
    @SuppressWarnings("null")
    public static Champion getChampion(String region, String encryptedId, int ChampionId) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
                        + encryptedId)
                .get()
                .addHeader("X-Riot-Token", Config.getAPI_KEY())
                .build();

        Gson gson = new Gson();
        ResponseBody responseBody;
        responseBody = client.newCall(request).execute().body();

        Champion champion;
        champion = gson.fromJson(responseBody.string(), Champion.class);
        return champion;
    }

    /**
     * Get the summoner champions data and store it into a champions list. In
     * future versions it could be used the Jackson library to improve the
     * method efficience
     *
     * @param region Summoner region
     * @param encryptedId Summoner id
     * @return Champion list of summoners champions data
     * @throws IOException Something went wrong at the get request
     */
    @SuppressWarnings("null")
    public static List<Champion> getSumonersChampion(String region, String encryptedId) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://" + region
                        + ".api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
                        + encryptedId)
                .addHeader("X-Riot-Token", Config.getAPI_KEY())
                .build();

        String responseBody = client.newCall(request).execute().body().string();
        JSONArray jChampionList = new JSONArray(responseBody);
        List<Champion> champions = new ArrayList<>();
        Gson gson = new Gson();

        for (int i = 0; i < jChampionList.length(); i++) {

            String jChampion = jChampionList.get(i).toString();
            champions.add(gson.fromJson(jChampion, Champion.class));
        }
        return champions;
    }
}
