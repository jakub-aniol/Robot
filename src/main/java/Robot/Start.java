package Robot;

import Robot.Scanners.ScanRobotLegimi;

/**
 * Created by jakub on 21.03.16.
 */
public class Start {
    public static void main(String[] args) {

        ScanningWWW scanwww = new ScanningWWW();
        ConectingWWW conwww = new ConectingWWW();
        ScanRobotLegimi scanLegimi = new ScanRobotLegimi();
        scanLegimi.subRead(scanwww.doScan(conwww.explore()));

    }

}
