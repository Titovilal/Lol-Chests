package es.tprograms.dao;

import com.google.gson.Gson;
import es.tprograms.model.Config;
import es.tprograms.model.NoScalingIcon;
import es.tprograms.model.Summoner;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.Icon;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 *
 * @author Titovilal
 */
public final class SummonerDao {

    public static NoScalingIcon getSummonerIcon(String profileIconId) {

        return null;

    }

    private SummonerDao() {

    }

    /**
     *
     * @param region
     * @param name
     * @param apiKey
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    @SuppressWarnings("null")
    public static Summoner getSummoner(String region, String name) throws IOException, InterruptedException, URISyntaxException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://"
                        + region + ".api.riotgames.com/lol/summoner/v4/summoners/"
                        + "by-name/" + name
                        + "?api_key=" + Config.getAPI_KEY())
                .get()
                .build();

        Gson gson = new Gson();
        ResponseBody responseBody;
        responseBody = client.newCall(request).execute().body();
        Summoner summoner;
        summoner = gson.fromJson(responseBody.string(), Summoner.class);
        return summoner;
    }

}
