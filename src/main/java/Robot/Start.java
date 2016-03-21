package Robot;

import Robot.Scanners.ScanRobotLegimi;
import Settings.BookStore;

/**
 * Created by jakub on 21.03.16.
 */
public class Start {
    public static void main(String[] args) {

        BookStore bsLegimi = new BookStore("Legimi", "www.legimi.com/pl/ebooki/darmowe");
        ScanningWWW scanwww = new ScanningWWW();
        UrlConectingWWW conwww = new UrlConectingWWW();
        InputStreamWWW instrWWW = new InputStreamWWW();
        ScanRobotLegimi scanLegimi = new ScanRobotLegimi(bsLegimi);

        scanLegimi.subRead(scanwww.doScan(instrWWW.pullWWW(conwww.explore())));

    }

}
