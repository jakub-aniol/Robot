package Robot;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * Klasa odpowiedzialna za przesłanie strumienia z połączenia internetowego.
 * @author Created by jakub_aniol on 21.03.16.
 * @version 1.0.0
 */
public class InputStreamWWW {

    final static Logger logger = Logger.getLogger(InputStreamWWW.class);
    private InputStream input;

    /**
     * Metoda generująca strumień.
     * @param urlConnection - klasy URLConnection - połączenie ze stroną
     * @return input  - klasy InputStream  - wysyła strumień
     */
    public InputStream pullWWW(URLConnection urlConnection) {

        try {
            input = urlConnection.getInputStream();
        } catch (IOException e) {
            logger.error("Brak podanej strony: " + urlConnection.toString());
        }

        return input;
    }
}
