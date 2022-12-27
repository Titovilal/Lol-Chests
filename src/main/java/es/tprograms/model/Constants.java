package es.tprograms.model;

/**
 *
 * @author Titovilal
 */
public final class Constants {

    
    public static final String USER_DATA_FILE_PATH = "";
    public static final String CHAMPION_DATA_FILE_PATH = "";
    public static final String DATA_LOADER_FILE_PATH = "";
    private static String API = "RGAPI-444c1562-72b9-48b4-a753-5368dba961ab";

    /**
     * Class with the Riot Platform Routing Values
     * 
     */
    public final class Routing {

        public static final String BR1 = "br1";
        public static final String EUN1 = "eun1";
        public static final String EUW1 = "euw1";
        public static final String JP1 = "jp1";
        public static final String KR = "kr";
        public static final String LA1 = "la1";
        public static final String LA2 = "la2";
        public static final String NA1 = "na1";
        public static final String OC1 = "oc1";
        public static final String TR1 = "tr1";
        public static final String RU = "ru";
        public static final String PBE1 = "pbe1";
    }

    public static String getAPI() {
        return API;

    }

    public static void setAPI(String API) {
        Constants.API = API;
    }

}
