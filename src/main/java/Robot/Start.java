package Robot;

import Robot.Scanners.ScanRobotLegimi;
import Robot.Scanners.ScanRobotUpolujEbooka;
import Settings.BookStore;
import GUI.GUI;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jakub on 21.03.16.
 */
public class Start {
    final static Logger logger = Logger.getLogger(Start.class);

    public static void main(String[] args) {


        BookStore bsLegimi = null;
        BookStore bsUpolujEbooka = null;
        

        try {
            bsUpolujEbooka = new BookStore("Upolujebooka", new URL("http://upolujebooka.pl/kategoria,8248,darmowe_e-booki.html?count=60"));
        }catch (MalformedURLException e) {
            logger.error("Podany adres nie jest adresem URL", e);
        } catch (NullPointerException e) {
        e.printStackTrace();
        }


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
        ScanRobotUpolujEbooka scanRobotUpolujEbooka = new ScanRobotUpolujEbooka(bsUpolujEbooka);
        

        scanRobotLegimi.showLegimiBooks(scanRobotLegimi.doSubContentWWW(scanningWWW.doScan(inputStreamWWW.pullWWW(urlConectingWWW.explore(bsLegimi.getUrl())))));
        scanRobotUpolujEbooka.showUpolujEbookaBooks(scanRobotUpolujEbooka.doSubContentWWW(scanningWWW.doScan(inputStreamWWW.pullWWW(urlConectingWWW.explore(bsUpolujEbooka.getUrl())))));
        
        GUI gui = new GUI();
        gui.run();

    }

}
