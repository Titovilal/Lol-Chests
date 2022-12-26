package es.tprograms.dao;

import com.google.gson.Gson;
import es.tprograms.model.Champion;
import es.tprograms.model.Constants;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * Unused class at this version
 *
 * @author Titovilal
 */
public class ChampionDao {

    /**
     *
     * @param encryptedId
     * @param ChampionId
     * @return
     * @throws IOException
     */
    @SuppressWarnings("null")
    public static Champion getChampion(String encryptedId, int ChampionId) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://euw1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
                        + encryptedId)
                .get()
                .addHeader("X-Riot-Token", Constants.getAPI())
                .build();

        Gson gson = new Gson();
        ResponseBody responseBody;
        responseBody = client.newCall(request).execute().body();

        Champion champion;
        champion = gson.fromJson(responseBody.string(), Champion.class);
        return champion;
    }
}
