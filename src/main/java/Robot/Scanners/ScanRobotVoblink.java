package Robot.Scanners;

import Settings.BookStore;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by jakub on 22.03.16.
 */
public class ScanRobotVoblink {

    final static Logger logger = Logger.getLogger(ScanRobotVoblink.class);

    BookStore bsLegimi;

    public ScanRobotVoblink(BookStore bookStore) {
        bsLegimi = bookStore;
    }

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

    public void showLegimiBooks(List list) {
        ListIterator<String> iterWWW = null;
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


