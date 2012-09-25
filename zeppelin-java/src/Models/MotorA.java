package Models;

/**
 *
 * @author Gerjo Meier
 */
public class MotorA {
    public static final byte LEFT  = 1;
    public static final byte HALT  = 0;
    public static final byte RIGHT = -1;
    public static final byte NONE  = -2;

    public static final String toString(byte direction) {
        return ""+toChar(direction);
    }

    public static String toFancy(byte direction) {
        switch(direction) {
            case LEFT:
                return "Left";
            case RIGHT:
                return "Right";
            default:
                return "Halt";
        }
    }

    public static final char toChar(byte direction) {
        switch(direction) {
            case LEFT:
                return 'q';
            case RIGHT:
                return 'w';
            default:
                return 'e';
        }
    }
}
