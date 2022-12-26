    package es.tprograms.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
     * Encrypt and write or rewrite the file with the summoners ids and Api Key
     *
     */
    public final void overwriteUserData() {

    }

    /**
     * Read, decrypt and store the summoners ids and Api Key
     *
     */
    public final void readUserData() {

    }

    /**
     * OverWrite game version and champion ids
     *
     * @param championMap
     * @throws java.io.IOException
     */
    public final void overwriteChampionData(Map<Integer, String> championMap) throws IOException {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(Constants.CHAMPION_DATA_FILE_PATH));
        for (Map.Entry<Integer, String> entry : championMap.entrySet()) {
            bw.write(entry.getKey() + "," + entry.getValue());
            bw.newLine();
        }

    }
    
    public void loadNewUserData(){
        
    }

    /**
     * Compare lastest game version with the stored in local data
     *
     * @param lastestVersion Lastest game version
     * @return true if matches, false if not
     */
    public final boolean compareChampionData(String lastestVersion) {
        return true;
    }
}
