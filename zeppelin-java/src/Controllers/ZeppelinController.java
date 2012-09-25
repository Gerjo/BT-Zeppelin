package Controllers;

import ComLib.ComThreadChecker;
import ComLib.ComThread;
import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import static Miscellaneous.DebugTools.*;

/**
 *
 * @author Gerjo Meier
 */
public class ZeppelinController extends BetterEngineController {
    private MainController MainController;
    private ArrayList<ComThread> ComProbes    = new ArrayList<ComThread>();
    private ComThreadChecker ComThreadChecker = null;
    private ComThread comThread               = null;
    private ComThread zeppelinComport         = null;

    private boolean isSearching = false;
    private long lastPing       = 0;

    public ZeppelinController(MainController MainController) {
        this.MainController = MainController;
    }

    /**
     * Attempt to connect to the zeppelin.
     */
    public void connectToZeppelin() {
        isSearching = true;

        ComPortController ComPortController = MainController.getComPortController();
        ArrayList<CommPortIdentifier> ports = ComPortController.getAllSerialPorts();

        if(ports.size() > 0) {
            // MESSAGE: Found XX serial ports.
            mainLoop:
            for(CommPortIdentifier port : ports) {
                if(FORCE_COMPORT != null && !FORCE_COMPORT.equals(port.getName())) {
                    out("FORCING COM PORT!");
                    continue;
                }

                out("[" + port.getName() + "] starting thread.");
                comThread = new ComThread(this, port, 10);

                while(!comThread.isOverTime()) {
                    if(zeppelinComport != null) {
                        out("halting...");
                        break mainLoop;
                    }
                    sleep(1000);
                }
                out("[" + port.getName() + "] killed after " + comThread.getRunTime() + " seconds.");
                comThread.stop();
            }

            out("All serial ports have been scanned.");
            isSearching = false;
        } else {
            // MESSAGE: No free serial ports found.
            out("No serial ports were found.");
        }
    }

    /**
     *
     * @return Boolean wether or not the controller is searching for the zeppelin.
     */
    public boolean isSearching() {
        return isSearching;
    }

    /**
     * Send data to the zeppelin arduino.
     * @param command String data to be send to the zeppelin.
     */
    public void write(String command) {
        if(comThread != null) comThread.write(command);
    }
    /**
     * Send data to the zeppelin arduino.
     * @param command String data to be send to the zeppelin.
     * @param echoToOut Wether or not to write to System.out
     */
    public void write(String command, boolean echoToOut) {
        if(comThread != null) comThread.write(command, echoToOut);
    }
    /**
     * Retrieve the currently available ComThread.
     * @return a comThread that is being used.
     */
    public ComThread getComThread() {
        return comThread;
    }
    /**
     * Called asynchronous when the zeppelin has been found by a spawned thread.
     * @param zeppelinComport ComThread to which the zeppelin is connected.
     */
    public void onZeppelinFound(ComThread zeppelinComport) {
        this.zeppelinComport = zeppelinComport;
        enableEngineController();
    }
    /**
     *
     * @return ComThead to which the zeppelin is connected.
     */
    public ComThread getZeppelinComport() {
        return zeppelinComport;
    }
    /**
     *
     * @param zeppelinComport
     */
    public void setZeppelinComport(ComThread zeppelinComport) {
        this.zeppelinComport = zeppelinComport;
    }
    /**
     *
     * @return long containing the last known ping time, since 1970.
     */
    public long getLastPing() {
        return lastPing;
    }
    /**
     * 
     * @param lastPing
     */
    public void setLastPing(long lastPing) {
        this.lastPing = lastPing;
    }
}
