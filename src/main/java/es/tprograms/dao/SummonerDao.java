package es.tprograms.dao;

import es.tprograms.model.Summoner;
import java.io.IOException;
import java.net.URISyntaxException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author scast
 */
public final class SummonerDao {

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

        Response response;
        response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.body().string());

        return new Summoner();
    }
}

//
//OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://league-of-legends-esports.p.rapidapi.com/teams?id=lng-esports")
//                .get()
//                .addHeader("summonerId", apiKey)
//                .addHeader("X-RapidAPI-Host", "league-of-legends-esports.p.rapidapi.com")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        Gson gson = new Gson();
//        String jsonRequest = gson.toJson(summoner);
//        System.out.println(jsonRequest);
//        HttpRequest postRequest = HttpRequest.newBuilder()
//                .uri(new URI(""))
//                .header("Authorization", Constants.API_KEY)
//                .POST(BodyPublishers.ofString(jsonRequest))
//                .build();
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        HttpResponse<String> httpResponse = httpClient.send(postRequest, BodyHandlers.ofString());
