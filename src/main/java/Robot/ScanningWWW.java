package Robot;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jakub on 21.03.16.
 */
public class ScanningWWW {

    final static Logger logger = Logger.getLogger(ScanningWWW.class);

    public ArrayList<String> doScan(InputStream inputStream) {
        String scanString;
        ArrayList<String> contentWWW = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
                scanString = scanner.next();
                contentWWW.add(scanString);
            }
        } catch (NullPointerException e) {
            logger.error("Brak danych lub Brak podanej strony: ", e);
        }

       return contentWWW;

    }




}


