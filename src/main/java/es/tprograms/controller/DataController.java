package es.tprograms.controller;

import es.tprograms.dao.ChampionDao;
import es.tprograms.dao.DataDao;
import es.tprograms.model.Config;
import es.tprograms.model.Data;
import java.io.IOException;
import java.util.Map;

/**
 * A class for managing and updating the data of the game, including the current
 * version and the champions file.
 *
 * @author Titovilal
 * @version 1.0.0
 */
public final class DataController {

    /**
     * falta por acabar LA FUNCION
     *
     * @throws IOException
     */
    public void updateAllData() throws IOException {
        String currentVersion = DataDao.getLatestVersion();
        Map<Integer, String> champions = DataDao.getChampionsMap(currentVersion);
        DataDao.downloadChampionsSquare(champions, currentVersion);
    }

    /**
     * Returns a map with the favourite players.
     *
     * @return a map with the favourite players
     * @throws IOException if an error occurs when reading the favourites file
     */
    public Map<String, String> getFavPlayers() throws IOException {
        return Data.readFavouritesFile();
    }

    /**
     *
     * @param summoners
     * @throws IOException
     */
    public void overwriteFavPlayers(Map<String, String> summoners) throws IOException {
        Data.overwriteFavouritesFile(summoners);
    }

    /**
     * Gets the current version of the game. If the current version is newer
     * than the local version, overwrites the local version file with the
     * current version.
     *
     * @return the current version of the game.
     * @throws IOException if an error occurs when opening or writing to the
     * file.
     */
    public String checkVersion() throws IOException {
        String currentVersion;
        currentVersion = DataDao.getLatestVersion();
        String localVersion;
        localVersion = Data.readVersionFile();

        int comparisonResult = localVersion.compareTo(currentVersion);

        if (comparisonResult < 0) {
            Data.overWriteVersionFile(currentVersion);
            overwriteChampionsFile(currentVersion);
        }
        return currentVersion;
    }

    /**
     * Overwrites the champions file with the champions map for the current
     * version.
     *
     * @return true if the champions file was overwritten successfully, false if
     * the current version is null.
     * @throws IOException if an error occurs when opening or writing to the
     * file.
     */
    private void overwriteChampionsFile(String currentVersion) throws IOException {
        Map<Integer, String> championsMap;
        championsMap = DataDao.getChampionsMap(currentVersion);
        Data.overwriteChampionsFile(championsMap);
    }

}
