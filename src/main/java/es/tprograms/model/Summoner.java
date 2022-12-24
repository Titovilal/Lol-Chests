package es.tprograms.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scast
 */
public class Summoner {

    private String summonerId;
    private String region;
    private String gameName;
    private List<Champion> champions;

    public Summoner() {
        champions = new ArrayList<>();
    }

    public Summoner(String summonerId, String region, String gameName, List<Champion> champions) {
        this.summonerId = summonerId;
        this.region = region;
        this.gameName = gameName;
        this.champions = champions;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Champion> getChampions() {
        return champions;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

}
