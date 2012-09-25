package ComLib;

import Controllers.ZeppelinController;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import static Miscellaneous.DebugTools.*;

/**
 *
 * @author Gerjo Meier
 */
public class ComThread implements Runnable, SerialPortEventListener {
    // Communication variables:
    private CommPortIdentifier comport = null;
    private ZeppelinController owner   = null;
    private Thread thread              = null;
    private Date startTime             = new Date();
    private int timeout                = 0;
    private SerialPort serialPort      = null;
    private OutputStream outputStream  = null;
    private InputStream inputStream    = null;

    // Singleton variables:
    private boolean isConnected        = false;
    private boolean isSetupCompleted   = false;

    // Zeppelin specific variables:
    private long lastPing              = 0;

    public ComThread(ZeppelinController owner, CommPortIdentifier CommPortIdentifier, int timeout) {
        this.comport = CommPortIdentifier;
        this.owner              = owner;
        this.timeout            = timeout;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Method called asynchronous by the thread. Attempts to setup a connection, and write the handshake.
     */
    public void run() {
        startTime = new Date();
        while(thread != null) {
            if(!isSetupCompleted) {
                setup();
                //out("[" + comport.getName() + "] setup completed, sending handshake.");
                write("y", false);
                isSetupCompleted = true;
            }
        }
    }

    /**
     * Initiate the serial port communication streams.
     */
    public void setup() {
        try {
            serialPort  = (SerialPort) comport.open("SimpleReadApp", 2000);
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            
            serialPort.notifyOnOutputEmpty(false); // true

            //serialPort.enableReceiveTimeout(1);

            outputStream = serialPort.getOutputStream();
            inputStream  = serialPort.getInputStream();
        } catch (Exception e) {
            
        }
    }

    /**
     * Called asynchronous by the computer.
     * @param event Containing details about the event.
     */
    public void serialEvent(SerialPortEvent event) {
        String finalString = "";

        if(event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            sleep(100);
            try {
                byte[] readBuffer = new byte[40];
                while(inputStream.available() > 0) {
                    inputStream.read(readBuffer);
                }
                finalString = new String(readBuffer).trim();

                if(isSetupCompleted && finalString.equals("z") && !isConnected) {
                    isConnected = true;
                    out("[" + comport.getName() + "] found BT Zeppelin!");
                    write("p", false);
                    owner.onZeppelinFound(this);
                } else if(finalString.equals("p")) {
                    write("p", false);
                    out("[" + comport.getName() + "] responding to ping.");

                    // Take note of the last received ping, the GUI will update
                    owner.setLastPing(System.currentTimeMillis());
                } else {
                    out("[" + comport.getName() + "] read: '" + finalString + "'");
                }
            } catch (IOException e) {
                
            }
        }
    }

    /**
     * Write data to the serial port.
     * @param command String data to be send.
     */
    public void write(String command) {
        write(command, true);
    }
    /**
     * Write data to the serial port, optionally write a debug message.
     * @param command String data to be send.
     * @param echoToOut Wether or not to write the data to System.out
     */
    public void write(String command, boolean echoToOut) {
        if(true || outputStream != null) {
            try {
                if(echoToOut) {
                    out("[" + comport.getName() + "] writing: '" + command + "'");
                }
                outputStream.write(command.getBytes());
            } catch(Exception e) {

            }
        } else {
            out("[error] Zeppelin is not connected.");
        }
    }

    /**
     * Safe method to halt this thread.
     */
    public void stop() {
        thread = null;
    }
    /**
     * Join this thread in the queue.
     */
    public void join() {
        try {
            thread.join();
        } catch(Exception e) {}
    }
    /**
     *
     * @return Boolean wether or not the timeout period has been reached.
     */
    public boolean isOverTime() {
        return (getRunTime() > timeout);
    }
    /**
     *
     * @return time difference between now and the state time.
     */
    public long getRunTime() {
        return (new Date().getTime() - startTime.getTime())/1000;
    }
}
