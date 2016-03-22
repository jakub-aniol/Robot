package Robot;

import Robot.Scanners.ScanRobotLegimi;
import Settings.BookStore;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jakub on 21.03.16.
 */
public class Start {
    final static Logger logger = Logger.getLogger(ScanRobotLegimi.class);

    public static void main(String[] args) {

        BookStore bsLegimi = null;
        try {
            bsLegimi = new BookStore("Legimi", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        }catch (MalformedURLException e) {
            logger.error("Podany adres nie jest adresem URL", e);
        } catch (NullPointerException e) {
        e.printStackTrace();
        }

        UrlConectingWWW urlConectingWWW = new UrlConectingWWW();
        InputStreamWWW inputStreamWWW = new InputStreamWWW();
        ScanningWWW scanningWWW = new ScanningWWW();
        ScanRobotLegimi scanRobotLegimi = new ScanRobotLegimi(bsLegimi);

        scanRobotLegimi.showLegimiBooks(scanRobotLegimi.doSubContentWWW(scanningWWW.doScan(inputStreamWWW.pullWWW(urlConectingWWW.explore(bsLegimi.getUrl())))));


    }

}
