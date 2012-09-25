package Miscellaneous;


/**
 * While this file is a summit of worst practises, it certainly speeds up
 * development time. For convenience sake each method should be import static.
 * @author Gerjo Meier
 */
public class DebugTools {
    public static String FORCE_COMPORT = null;//"COM12";

    public static void main(String[] args) {
        //out(2);
    }

    public static void sleep(int utime) {
        try {
            Thread.sleep(utime);
        } catch(Exception e){

        }
    }
    
    public static <TYPE> void out(TYPE asd) {
        System.out.println(asd);
    }
}
