import Controllers.MainController;


public class Main {
    public static MainController MainController;

    /**
     * TabbedZeppelin point of entry.
     * @param args Arguments supplied via the runtime environment
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainController = new MainController();
            }
        });
    }
}
