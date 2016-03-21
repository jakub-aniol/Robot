package Robot;

import Robot.Scanners.ScanRobotLegimi;
import Settings.BookStore;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jakub on 21.03.16.
 */
public class Start {
    public static void main(String[] args) {

        BookStore bsLegimi = null;
        try {
            bsLegimi = new BookStore("Legimi", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ScanningWWW scanwww = new ScanningWWW();
        UrlConectingWWW conwww = new UrlConectingWWW();
        InputStreamWWW instrWWW = new InputStreamWWW();
        ScanRobotLegimi scanLegimi = new ScanRobotLegimi(bsLegimi);

        scanLegimi.subRead(scanwww.doScan(instrWWW.pullWWW(conwww.explore(bsLegimi.getUrl()))));

    }

}
