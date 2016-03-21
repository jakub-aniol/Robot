package Robot;

import Robot.Scanners.ScanRobotLegimi;

/**
 * Created by jakub on 21.03.16.
 */
public class Start {
    public static void main(String[] args) {

        ScanningWWW scanwww = new ScanningWWW();
        UrlConectingWWW conwww = new UrlConectingWWW();
        InputStreamWWW instrWWW = new InputStreamWWW();
        ScanRobotLegimi scanLegimi = new ScanRobotLegimi();

        scanLegimi.subRead(scanwww.doScan(instrWWW.pullWWW(conwww.explore())));

    }

}
