package Robot;

import GUI.GUI;
import Scanners.ScanRobot28Ksiazek;
import Scanners.ScanRobotLegimi;
import Scanners.ScanRobotUpolujEbooka;
import Settings.BookStore;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Created by jakub on 21.03.16.
 * @version 1.0.0
 */
public class Start {

    final static Logger logger = Logger.getLogger(Start.class);

    /**
     * Stworenie obiektów uruchomienie programu
     * @param args klasy String
     */
    public static void main(String[] args) {

        BookStore bsLegimi = null;
        BookStore bsUpolujEbooka = null;
        BookStore bs28Ksiazek = null;

        try {
            bsLegimi = new BookStore("Legimi", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        }catch (MalformedURLException e) {
            logger.error("Podany adres nie jest adresem URL", e);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            bsUpolujEbooka = new BookStore("Upolujebooka", new URL("http://upolujebooka.pl/kategoria,8248,darmowe_e-booki.html?count=60"));
        }catch (MalformedURLException e) {
            logger.error("Podany adres nie jest adresem URL", e);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            bs28Ksiazek = new BookStore("28Ksiazek", new URL("http://andrzejtucholski.pl/2014/28-wybitnych-ksiazek-ktore-mozesz-legalnie-i-za-darmo-pobrac-z-internetu/"));
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
        ScanRobot28Ksiazek scanRobot28Ksiazek = new ScanRobot28Ksiazek(bs28Ksiazek);


           scanRobotLegimi.showLegimiBooks(scanRobotLegimi.doSubContentWWW(scanningWWW.doScan(inputStreamWWW.pullWWW(urlConectingWWW.explore(bsLegimi.getUrl())))));



            scanRobotUpolujEbooka.showUpolujEbookaBooks(scanRobotUpolujEbooka.doSubContentWWW(scanningWWW.doScan(inputStreamWWW.pullWWW(urlConectingWWW.explore(bsUpolujEbooka.getUrl())))));

            scanRobot28Ksiazek.show28KsiazekBooks(scanRobot28Ksiazek.doSubContentWWW(scanningWWW.doScan(inputStreamWWW.pullWWW(urlConectingWWW.explore(bs28Ksiazek.getUrl())))));


        GUI gui = new GUI();
        gui.run();

    }

}
