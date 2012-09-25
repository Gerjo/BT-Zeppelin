package Controllers;

import Models.MotorA;
import Models.MotorB;
import static Miscellaneous.DebugTools.*;
/**
 *
 * @author Gerjo Meier
 */
public abstract class BetterEngineController {
    private byte engineAstate;  //
    private byte engineBstate;  //
    private int servoAstate;    // we'll leave this one out for starters
    private boolean connected;
    private long lastServoCommand = 0;
    private int servoCommandDelay = 100; // millis

    // 2 options here, either you do it as show here, or we link directly
    // to the comlib. - okay done via extend.
    public void enableEngineController() {
        this.connected = true;
    }

    public void disableEngineController() {
        this.connected = false;
    }

    public void engineAstate(byte state) {
        if(engineAstate != state) {
            engineAstate = state;
            write(""+MotorA.toChar(state));
            out("Engine A: " + MotorA.toFancy(state) + "(" + MotorA.toChar(state) + ")");
        }
    }

    public void engineBstate(byte state) {
        if(engineBstate != state) {
            engineBstate = state;
            write(""+MotorB.toChar(state));
            out("Engine B: " + MotorB.toFancy(state) + "(" + MotorB.toChar(state) + ")");
        }
    }

    public void setServo(int angle) {
        write("h" + angle);
    }

    public void incrementServo() {
        if(servoDelay()) {
            out("Servo: increment");
            write("f");
            
        }
    }

    public void decrementServo() {
        if(servoDelay()) {
            out("Servo: decrement");
            write("g");
            
        }
    }

    private boolean servoDelay() {
        if(System.currentTimeMillis() - lastServoCommand > servoCommandDelay) {
            lastServoCommand = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public abstract void write(String command);

    // Send a message to the zeppelin controller, which in turn will
    // relay the data back to the appropriate comlib (which is connected to the arduino.
    // private void write(byte data) {
    //    // this refers to the object on which this clas shas been extended iu[on.
    //    this.write(data);
    // }

    // TODO: request a sync:
    private void sendSyncRequest() {

    }

    // TODO: receive the sync, and actually sync the status with this class.
    public void receiveSyncRequest(String syncData) {
        // syncData as CSV?
    }
}
