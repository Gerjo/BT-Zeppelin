package Viewers;

import Controllers.MainController;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Gerjo Meier
 */
public class StatusIndicator extends javax.swing.JLabel implements MouseListener {
    private MainController mainController;

    public StatusIndicator(MainController mainController) {
        this.addMouseListener(this);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.mainController = mainController;
        setText("Loading...");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateStatus();
            }
        }, 0, 500);
    }

    /**
     * Update the status bar on the TabbedGUI
     */
    public void updateStatus() {
        long lastPing = mainController.getZeppelinController().getLastPing();
        long diff     = System.currentTimeMillis() - lastPing;
        String newText = "<html>BT Zeppelin status: ";


        if(mainController.getZeppelinController().isSearching()) {
            newText += "<font color=\"red\">Attempting to connect</font>.";
        } else if(lastPing == 0) {
            newText += "<font color=\"red\">Disconnected</font>.";
            //mainController.getTabbedGUI().showConnectCard();
        } else if(diff > 10000) {
            newText += "<font color=\"red\">Disconnected for " + Math.round(diff/1000) + " seconds</font>.";
            //mainController.getTabbedGUI().showNormalImage();

            // Removed this feature as it got really annoying:
            //mainController.getTabbedGUI().showConnectCard();
        } else {
            newText += "Connected. ";
        }
        newText += "</html>";

        if(!getText().equals(newText)) {
            setText(newText);
        }
    }

    public void addText(String text) {
        setText(getText() + text);
    }

    /**
     * Method used to show CardConnect on the TabbedGUI
     * @param e Event containing the mouse event details.
     */
    public void mouseClicked(MouseEvent e) {
        mainController.getTabbedGUI().showConnectCard();
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}
