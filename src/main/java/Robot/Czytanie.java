package Robot;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ja on 19.03.16.
 */
public class Czytanie {

    final static Logger logger = Logger.getLogger(Czytanie.class);


    public static void main(String args[]) throws Exception {

        String scanstr;
        List<String> zawartoscWWW = new ArrayList<String>();
        List<String> zawartoscSubWWW = null;

        URL url = null;
        URLConnection urlc = null;
        try {
            url = new URL("http://www.legimi.com/pl/ebooki/darmowe");
            urlc = url.openConnection();
        } catch (MalformedURLException e) {
            logger.error("Nieprawidłowy adres URL: " + url);
        }
        InputStream input = null;
        try {
            input = urlc.getInputStream();
        } catch (IOException e) {
            logger.error("Brak podanej strony: " + url.toString());
        }
        Scanner scanner = null;

        try {
            scanner = new Scanner(input);


            while (scanner.hasNext()) {
                scanstr = scanner.next();
                zawartoscWWW.add(scanstr);
            }

        } catch (NullPointerException e) {
            logger.error("Brak danych lub Brak podanej strony: " + url.toString());
        }

        int firstOccurence = zawartoscWWW.indexOf("Najpopularniejsze");
        int lastOccurence = zawartoscWWW.indexOf("id=\"collection0\"");


        try {
            zawartoscSubWWW = zawartoscWWW.subList(firstOccurence, lastOccurence);


            Iterator<String> iter = zawartoscSubWWW.listIterator();
            String starts;
            String tytul = null;


            while (iter.hasNext()) {
                starts = iter.next();
                if (starts.startsWith("href='/pl/ebook-")) {
                    tytul = starts.substring(16, starts.length() - 12);
                    System.out.println(tytul);
                    logger.info(tytul);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            logger.error("Nie można wydzielic sublisty brak występowania ogranicznikow");
        }

        try {
            input.close();
        } catch (NullPointerException e) {
            logger.error("Brak danyc do odcztu lub złe dane");
        }

    }


}







