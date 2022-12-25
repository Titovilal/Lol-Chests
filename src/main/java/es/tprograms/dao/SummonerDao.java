package es.tprograms.dao;

import com.google.gson.Gson;
import es.tprograms.model.Summoner;
import java.io.IOException;
import java.net.URISyntaxException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 *
 * @author scast
 */
public final class SummonerDao {

    private SummonerDao (){
        
    }
    /**
     *
     * @param server
     * @param gameName
     * @param apiKey
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static Summoner getSummoner(String server, String gameName, String apiKey) throws IOException, InterruptedException, URISyntaxException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://"
                        + server + ".api.riotgames.com/lol/summoner/v4/summoners/"
                        + "by-name/" + gameName
                        + "?api_key=" + apiKey)
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