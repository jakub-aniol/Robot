package Robot;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ja on 19.03.16.
 */
public class ConectingWWW {

    final static Logger logger = Logger.getLogger(ConectingWWW.class);

    public static URL url = null;

    public InputStream explore() {

        InputStream input = null;
        URLConnection urlc = null;

        try {
            url = new URL("http://" + new BookStore().getUrl());

            urlc = url.openConnection();
        } catch (MalformedURLException e) {
            logger.error("Nieprawidłowy adres URL: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            input = urlc.getInputStream();
        } catch (IOException e) {
            logger.error("Brak podanej strony: " + url.toString());
        }
        return input;
    }
}







