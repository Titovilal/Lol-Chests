package es.tprograms.controller;

import es.tprograms.dao.SummonerDao;
import es.tprograms.model.Summoner;
import es.tprograms.model.NoScalingIcon;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author Titovilal
 */
public class SummonerController {

    /**
     *
     * @param region
     * @param name
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public Summoner getSummonerByName(String region, String name) throws IOException, InterruptedException, URISyntaxException {
        return SummonerDao.getSummoner(region, name);
    }

    /**
     *
     * @param profileIconId
     * @return
     */
    public NoScalingIcon getSummonerIcon(String profileIconId) {
        return SummonerDao.getSummonerIcon(profileIconId);
    }

}
