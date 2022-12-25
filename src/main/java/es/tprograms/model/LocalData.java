package es.tprograms.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scast
 */
public class LocalData {

    private static final String CONFIG_FILE_PATH = "";

    private Map<String, String> encryptedIds;
    private String mainEncryptedId;
    private String mainServer;

    public final void rewriteConfigFile() throws IOException {
        try ( FileOutputStream fos = new FileOutputStream(CONFIG_FILE_PATH)) {
            try ( ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(mainEncryptedId);
                oos.writeObject(mainServer);
                oos.writeObject(encryptedIds);
            }
        }
    }

    public final void readConfigFile() throws IOException {
        try ( FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);  ObjectInputStream ois = new ObjectInputStream(fis)) {
            mainEncryptedId = (String) ois.readObject();
            mainServer = (String) ois.readObject();
            encryptedIds = (Map<String, String>) ois.readObject();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocalData.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
