package ComLib;

import Controllers.ZeppelinController;

/**
 *
 * @author Gerjo Meier
 */
public class ComThreadChecker implements Runnable {
    private ZeppelinController owner = null;
    private Thread thread            = null;

    public ComThreadChecker(ZeppelinController owner) {
        this.owner = owner;
        thread = new Thread(this);
        thread.start();
    }


    public void run() {
        System.out.println("started");
        while(thread != null) {
            owner.getComThread();
        }
    }

    public void stop() {
        thread = null;
    }
    public void join() {
        try {
            thread.join();
        } catch(Exception e) {}
    }
}
