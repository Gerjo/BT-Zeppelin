package Controllers;

import Viewers.TabbedGUI;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * MainController ties all other classes together. Rather than each class being
 * linked to eachother, every class simply links to this class. Simply put all
 * "traffic" from controller to controller travels via this route.
 *
 * @author Gerjo Meier
 */
public class MainController {
    private TabbedGUI TabbedGUI                   = null;
    private JFrame TabbedGUI_JFrame               = null;
    private ZeppelinController ZeppelinController = new ZeppelinController(this);
    private ComPortController ComPortController   = new ComPortController(this);
    private BufferedImage applicationIcon         = null;

    public MainController() {
        showTabbedGUI();
    }

    /**
     * Creates and shows the main GUI.
     */
    public void showTabbedGUI() {
        if(applicationIcon == null) {
            try {
                applicationIcon = ImageIO.read(getClass().getResource("/Resources/icon.png"));
            } catch (IOException ex) {}
        }

        TabbedGUI_JFrame = new JFrame("BT Zeppelin");
        TabbedGUI_JFrame.setIconImage(applicationIcon);
        TabbedGUI_JFrame.setSize(462, 370);
        TabbedGUI_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TabbedGUI = new TabbedGUI(this);
        TabbedGUI_JFrame.add(TabbedGUI); // getContentPane().
        TabbedGUI_JFrame.setResizable(false);
        TabbedGUI_JFrame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        TabbedGUI_JFrame.setLocation(getCenteredPoint(screenSize, TabbedGUI_JFrame));
    }

    /**
     * Find a centered point using a dimension and JFrame
     * @param dim
     * @param child
     * @return
     */
    public Point getCenteredPoint(Dimension dim, JFrame child) {
        int x = (int)((dim.getWidth()/2) - child.getWidth()/2);
        int y = (int)(dim.getHeight()/2) - child.getHeight()/2;
        return new Point(x, y);
    }

    public Point getCenteredPoint(JFrame parent, JFrame child) {
        int x = (parent.getX() + parent.getWidth()/2) - child.getWidth()/2;
        int y = (parent.getY() + parent.getHeight()/2) - child.getHeight()/2;
        return new Point(x, y);
    }

    /**
     *
     * @return The current instance of the TabbedGUI
     */
    public TabbedGUI getTabbedGUI() {
        return TabbedGUI;
    }

    /**
     *
     * @return JFrame containing the TabbedGUI
     */
    public JFrame getTabbedGUI_JFrame() {
        return TabbedGUI_JFrame;
    }

    /**
     *
     * @return The zeppelin controller
     */
    public ZeppelinController getZeppelinController() {
        return ZeppelinController;
    }

    /**
     *
     * @return Instance of the comport controller.
     */
    public ComPortController getComPortController() {
        return ComPortController;
    }
}
