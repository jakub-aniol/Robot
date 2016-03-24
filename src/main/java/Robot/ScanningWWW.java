package Robot;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Klasa odpowiedzialna za zeskanowanie strumienia
 * @author Created by jakub_aniol on 21.03.16.
 * @version 1.0.0
 */
public class ScanningWWW {

    final static Logger logger = Logger.getLogger(ScanningWWW.class);

    /**
     * Metoda zapisująca strumień do ArrayListy przy pomocy obiektu Scanner metoda hasNext()
     * oraz dodająca do ArrayListy poszczególne stringi z wykorzystaniem metody add(String)
     * @param inputStream - klasy InputStream - zawiera strumień danych
     * @return contentWWW - klasy ArrayList - zawierający kompletną stronę WWW
     * @throws NullPointerException
     */
    public ArrayList<String> doScan(InputStream inputStream) {

        String scanString;
        ArrayList<String> contentWWW = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
                scanString = scanner.next();
                contentWWW.add(scanString);
            }

            System.out.println(contentWWW.size());
        } catch (NullPointerException e) {
            logger.error("Brak danych lub Brak podanej strony: ", e);
        }
        System.out.println(contentWWW.size());

       return contentWWW;

    }




}


