package Scanners;

import Settings.BookStore;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ListIterator;


/**
 * Klasa odpowidzialna za wykonanie operacji wyszukujących darmowe książki
 *
 * @author Created by Jakub_Aniol
 * @version 1.0.0
 */

public class ScanRobot28Ksiazek {
    final static Logger logger = Logger.getLogger(ScanRobot28Ksiazek.class);

    /**
     * Obiekt księgarni
     */
    private final BookStore bs28Ksiazek;


    public ScanRobot28Ksiazek(BookStore bookStore) {
        bs28Ksiazek = bookStore;
    }

    /**
     * Metoda odpowiedzialna za wydzielenie sublisty ograniczającej wielkość listę zawierającą
     * całą stronę www do mniejszego obszaru, z ktorego latwiej mozna wyodrębnić darmowe e-booki
     *
     * @param contentWWW klasy List<String>
     * @return subContentWWW klasy List</String>
     * @throws IndexOutOfBoundsException
     */
    public List<String> doSubContentWWW(List<String> contentWWW) {
        List<String> subContentWWW = null;
        int firstOccurence = 0;
        int lastOccurence = 0;
        try {
            firstOccurence = contentWWW.indexOf("hierarchii.");
            lastOccurence = contentWWW.indexOf("newslettera</a>?</p>");
            subContentWWW = contentWWW.subList(firstOccurence, lastOccurence);
        } catch (IndexOutOfBoundsException e) {
            logger.error("Nie można wydzielic sublisty brak występowania ogranicznikow" + firstOccurence + lastOccurence, e);
        }
        return subContentWWW;
    }


    /**
     * Metoda zawierająca algorytm zczytania odpowiednich treści pozawalajaych na wyświeltenie darmowych książek
     *
     * @param list - Klasy List
     * @throws NullPointerException
     */
    public void show28KsiazekBooks(List list) {

        try {
            ListIterator<String> iterWWW = list.listIterator();

            String starts;
            String tytul;

            while (iterWWW.hasNext()) {
                starts = iterWWW.next();
                if (starts.startsWith("href=\"http://wolnelektury.pl/katalog/lektura/")) {
                    tytul = starts.substring(45, starts.lastIndexOf("/\">"));
                    logger.info(bs28Ksiazek.getName() + " " + tytul);
                }
            }

        } catch (NullPointerException e) {
            logger.error("Brak danych", e);
        }
    }
}
