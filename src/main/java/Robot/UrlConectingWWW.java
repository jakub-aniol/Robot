package Robot;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Klasa zestawiająca połączenie URL
 * @author Created by jakub_aniol on 19.03.16.
 * @version 1.0.0
 */
public class UrlConectingWWW {

    final static Logger logger = Logger.getLogger(UrlConectingWWW.class);

    private URLConnection urlc;

    /**
     *  Metoda odpowiedzialna za zesatwienie połączenia z daną stroną WWW
     * @param url - Klasy URL
     * @return urlc - Klasy URLConnection
     */
    public URLConnection explore(URL url) {

        try {
            urlc = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlc;
    }
}







