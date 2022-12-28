package es.tprograms.model;

/**
 * The Config class provides configuration constants for the application. It
 * includes constants for file names and API keys, as well as an inner class
 * containing constants for different regions.
 *
 * @author Titovilal
 * @version 1.0.0
 */
public final class Config {

    //Provisional way to acces api key until i learn how to hide it properly
    private static final String API_KEY = "RGAPI-d1fb1af4-d84a-4a1e-8290-da3caef733f3";

    public static final String FAVOURITES_FILE = "favourites.txt";
    public static final String CHAMPION_DATA_FILE = "champions.txt";
    public static final String VERSION_FILE = "version.txt";

    /**
     * The Region class contains constants for different regions in the
     * application.
     *
     * @author @author Titovilal
     * @version 1.0.0
     */
    public final class Region {

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

    public static String getAPI_KEY() {
        return API_KEY;

    }

}
