
package Controllers;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author Gerjo Meier
 */
public class ComPortController {
    private MainController MainController;

    public ComPortController(MainController MainController) {
        this.MainController = MainController;
    }

    /**
     *
     * @return ArrayList containing all available Serial Ports (albeit virtual) on this computer.
     */
    public ArrayList<CommPortIdentifier> getAllSerialPorts() {
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        ArrayList<CommPortIdentifier> ports = new ArrayList<CommPortIdentifier>();

        while(portList.hasMoreElements()) {
            CommPortIdentifier tempPort = (CommPortIdentifier) portList.nextElement();
            if (tempPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                ports.add(tempPort);
            }
        }

        return ports;
    }
}
