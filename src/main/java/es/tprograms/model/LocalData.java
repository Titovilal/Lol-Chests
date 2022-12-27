package es.tprograms.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that manage the program local data, it uses algorithm to encrypt the
 * summoners ids file
 *
 * @author Titovilal
 */
public class LocalData {

    private String apiKey;
    private Map<String, String> mapIdServer;
    private String mainId;
    private String mainServer;

    /**
     * Write or rewrite the file with the summoners ids and their routing
     * platform from favourites file
     *
     */
    public final void overwriteFavouritesFile() {

    }

    /**
     * Read and store the summoners ids and their routing platform from
     * favourites file
     *
     */
    public final void readFavouritesFile() {
    }

    /**
     * Compare lastest game version with the stored in static file
     *
     * @param lastestVersion Lastest game version
     * @return true if matches, false if not
     */
    public final boolean isLastestVersion(String lastestVersion) {
        return true;
    }

    /**
     * OverWrite game version and champion ids
     *
     * @return
     */
    public final Map<Integer, String> readChampionFile() {
        return new HashMap<>();
    }

    /**
     * OverWrite game version and champion ids
     *
     * @param championMap
     * @throws java.io.IOException
     */
    public final void overwriteChampionFile(Map<Integer, String> championMap) throws IOException {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(Constants.CHAMPION_DATA_FILE_PATH));
        for (Map.Entry<Integer, String> entry : championMap.entrySet()) {
            bw.write(entry.getKey() + "," + entry.getValue());
            bw.newLine();
        }
    }
}
