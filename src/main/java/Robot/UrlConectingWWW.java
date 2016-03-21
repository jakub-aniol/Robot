package Robot;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ja on 19.03.16.
 */
public class UrlConectingWWW {

    private URLConnection urlc;

    final static Logger logger = Logger.getLogger(UrlConectingWWW.class);

    public URLConnection explore(URL url) {

        try {
            urlc = url.openConnection();
        } catch (MalformedURLException e) {
            logger.error("Nieprawidłowy adres URL: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlc;
    }
}







