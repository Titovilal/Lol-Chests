package es.tprograms.model;

/**
 *
 * The Summoner class represents a summoner in a game. It contains information
 * about the summoner, such as their ID, account ID, PUUID, name, profile icon
 * ID, revision date, and summoner level.
 *
 * @author Titovilal
 * @version 1.0.0
 */
public class Summoner {

    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private String profileIconId;
    private String revisionDate;
    private long level;

    public Summoner() {
        id = "0";
        name = "0";
    }

    @Override
    public String toString() {
        return "Summoner{" + "id=" + id + ", accountId=" + accountId + ", puuid=" + puuid + ", name=" + name + ", profileIconId=" + profileIconId + ", revisionDate=" + revisionDate + ", summonerLevel=" + level + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(String profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

}
