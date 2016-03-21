package Robot;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 21.03.16.
 */
public class ScanningWWW {

    final static Logger logger = Logger.getLogger(ScanningWWW.class);

    private String scanString;
    List<String> contentWWW = new ArrayList<String>();


    public List<String> doScan(InputStream strwww) {

        try {
            Scanner scanner = new Scanner(strwww);

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


