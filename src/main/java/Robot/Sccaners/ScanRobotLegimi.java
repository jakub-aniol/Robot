package Robot.Sccaners;

import Robot.ExploringWWW;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 21.03.16.
 */
public class ScanRobotLegimi {
    final static Logger logger = Logger.getLogger(ExploringWWW.class);

    String scanstr;
    List<String> contentWWW = new ArrayList<String>();
    List<String> subContentWWW = null;
    ExploringWWW exploringWWW = new ExploringWWW();

    public void doScan() {
        try {
            Scanner scanner = new Scanner(exploringWWW.explore());

            while (scanner.hasNext()) {
                scanstr = scanner.next();
                contentWWW.add(scanstr);
            }
            System.out.println(contentWWW);

        } catch (NullPointerException e) {
            logger.error("Brak danych lub Brak podanej strony: " + ExploringWWW.url.getPath(), e);
        }

        int firstOccurence = contentWWW.indexOf("Najpopularniejsze");
        int lastOccurence = contentWWW.indexOf("id=\"collection0\"");


        try {
            subContentWWW = contentWWW.subList(firstOccurence, lastOccurence);


            Iterator<String> iter = subContentWWW.listIterator();
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
            logger.error("Nie można wydzielic sublisty brak występowania ogranicznikow"+firstOccurence+lastOccurence, e);
        }
    }
}
