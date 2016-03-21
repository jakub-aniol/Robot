package Robot.Scanners;

import Settings.BookStore;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jakub on 21.03.16.
 */
public class ScanRobotLegimi {
    BookStore bsLegimi;

    public ScanRobotLegimi(){

    }

    final static Logger logger = Logger.getLogger(ScanRobotLegimi.class);

    private List<String> subContentWWW = null;

    public void subRead(List contentWWW) {

        int firstOccurence = contentWWW.indexOf("Najpopularniejsze");
        int lastOccurence = contentWWW.indexOf("id=\"collection0\"");

        try {
            subContentWWW = contentWWW.subList(firstOccurence, lastOccurence);
            Iterator<String> iterWWW = subContentWWW.listIterator();
            String starts;
            String tytul;

            while (iterWWW.hasNext()) {
                starts = iterWWW.next();
                if (starts.startsWith("href='/pl/ebook-")) {
                    tytul = starts.substring(16, starts.length() - 12);
                    logger.info(tytul);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            logger.error("Nie można wydzielic sublisty brak występowania ogranicznikow" + firstOccurence + lastOccurence, e);
        }
    }
}
