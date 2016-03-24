

package Scanners;

import Settings.BookStore;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ListIterator;


/**
 * Klasa odpowidzialna za wykonanie operacji wyszukujących darmowe książki
 * @author Created by Jakub_Aniol
 * @version 1.0.0
 */



public class ScanRobotLegimi {
    final static Logger logger = Logger.getLogger(ScanRobotLegimi.class);

    /**
     * Obiekt księgarni
     */

    private final BookStore bsLegimi;

    public ScanRobotLegimi(BookStore bookStore) {
        bsLegimi = bookStore;
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
            firstOccurence = contentWWW.indexOf("Najpopularniejsze");
            lastOccurence = contentWWW.indexOf("id=\"collection0\"");
            subContentWWW = contentWWW.subList(firstOccurence, lastOccurence);
        } catch (IndexOutOfBoundsException e) {
            logger.error("Nie można wydzielic sublisty brak występowania ogranicznikow" + firstOccurence + lastOccurence, e);
        }
        return subContentWWW;
    }


   /**
     * Metoda zawierająca algorytm zczytania odpowiednich treści pozawalajaych na wyświeltenie darmowych książek
     * @param list - Klasy List
     * @throws NullPointerException
     */

    public void showLegimiBooks(List list) {

        ListIterator<String> iterWWW;
        try {
            iterWWW = list.listIterator();

            String starts;
            String tytul;

            while (iterWWW.hasNext()) {
                starts = iterWWW.next();
                if (starts.startsWith("href='/pl/ebook-")) {
                    tytul = starts.substring(16, starts.length() - 12);
                    logger.info(bsLegimi.getName() + " " + tytul);
                }
            }

        } catch (NullPointerException e) {
            logger.error("Brak danych", e);
        }
    }
}

