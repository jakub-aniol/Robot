package Robot;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * Created by jakub on 21.03.16.
 */
public class InputStreamWWW {

    private InputStream input;

    final static Logger logger = Logger.getLogger(InputStreamWWW.class);

    public InputStream pullWWW(URLConnection conwww){

        try {
            input = conwww.getInputStream();
        } catch (IOException e) {
            logger.error("Brak podanej strony: " + conwww.getContentEncoding());
        }

        return input;
    }
}
