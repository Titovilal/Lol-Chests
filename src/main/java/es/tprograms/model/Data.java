package es.tprograms.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A class for storing and loading data from local files. Favourites class could
 * be implemented to handle and error at trying to have two users with the same
 * summoner name but different region (replacing the map with the object).
 *
 * @author Titovilal
 * https://ddragon.leagueoflegends.com/cdn/12.23.1/img/champion/Aatrox.png
 */
public final class Data {
    
    /**
     * Saves a map of regions and summoner names to a file.
     *
     * @param summoners The map of regions and summoner names to save.
     * @throws IOException If there is an error writing to the file.
     */
    public static void overwriteFavouritesFile(Map<String, String> summoners) throws IOException {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(Config.FAVOURITES_FILE))) {
            for (Map.Entry<String, String> entry : summoners.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            writer.close();
        }
    }

    /**
     * Loads a map of regions and summoner names from a file.
     *
     * @return The map of regions and summoner names loaded from the file.
     * @throws IOException If there is an error reading the file.
     */
    public static Map<String, String> readFavouritesFile() throws IOException {
        Map<String, String> summoners = new HashMap<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(Config.FAVOURITES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                summoners.put(parts[0], parts[1]);
            }
        }
        return summoners;
    }

    /**
     * Overwrites the version file with the specified version.
     *
     * @param version the version to write to the version file.
     * @throws IOException if an error occurs when opening or writing to the
     * file.
     */
    public static final void overWriteVersionFile(String version) throws IOException {

        File file = new File(Config.VERSION_FILE);
        FileWriter fileWriter = new FileWriter(file);
        try ( BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(version);
            bufferedWriter.close();
        }
    }

    /**
     *
     * Reads the version file and returns a string with the version.
     *
     * @return a string with the version
     * @throws IOException if an error occurs when reading the file
     */
    public static final String readVersionFile() throws IOException {
        File file = new File(Config.VERSION_FILE);
        String version = "";
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            version = reader.readLine();
        }
        return version;
    }

    /**
     * Loads a map of champion IDs and names from the champion data file.
     *
     * @return The map of champion IDs and names loaded from the file.
     * @throws IOException If there is an error reading the file.
     */
    public static Map<Integer, String> readChampionsFile() throws IOException {
        Map<Integer, String> championMap = new HashMap<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(Config.CHAMPION_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                championMap.put(Integer.parseInt(parts[0]), parts[1]);
            }
        }
        return championMap;
    }

    /**
     * Overwrites the champion data file with the provided map of champion IDs
     * and names.
     *
     * @param championsMap The map of champion IDs and names to write to the
     * file.
     * @throws IOException If there is an error writing to the file.
     */
    public static final void overwriteChampionsFile(Map<Integer, String> championsMap) throws IOException {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(Config.CHAMPION_DATA_FILE));
        for (Map.Entry<Integer, String> entry : championsMap.entrySet()) {
            bw.write(entry.getKey() + ":" + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }
}
