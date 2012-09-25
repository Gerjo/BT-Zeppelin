package Viewers;

import static Miscellaneous.DebugTools.*;
import Controllers.MainController;
import java.awt.CardLayout;

public class TabbedGUI extends javax.swing.JPanel {
    private MainController MainController = null;

    public TabbedGUI() {
        this(null);
    }

    public TabbedGUI(MainController MainController) {
        this.MainController = MainController;
        initComponents();
        showConnectCard();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hiddenPanel = new javax.swing.JPanel();
        hiddenLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        tab_keyboard = new javax.swing.JLabel();
        tab_wiiremote = new javax.swing.JLabel();
        tab_mouse = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        cardConnect1 = new Viewers.Cards.CardConnect(this);
        cardKeyboard1 = new Viewers.Cards.CardKeyboard(this);
        cardMousePad1 = new Viewers.Cards.CardMousePad(this);
        cardWiiRemote1 = new Viewers.Cards.CardWiiRemote(this);
        statusLabel = new StatusIndicator(MainController);

        hiddenLabel.setText("hidden?");

        javax.swing.GroupLayout hiddenPanelLayout = new javax.swing.GroupLayout(hiddenPanel);
        hiddenPanel.setLayout(hiddenPanelLayout);
        hiddenPanelLayout.setHorizontalGroup(
            hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenPanelLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(hiddenLabel)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        hiddenPanelLayout.setVerticalGroup(
            hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(hiddenPanelLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(hiddenLabel)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(185, 203, 212));

        headerPanel.setBackground(new java.awt.Color(127, 160, 177));
        headerPanel.setPreferredSize(new java.awt.Dimension(420, 70));

        tab_keyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_keyboard_b.gif"))); // NOI18N
        tab_keyboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab_keyboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_keyboardMouseClicked(evt);
            }
        });

        tab_wiiremote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_wiiremote_b.gif"))); // NOI18N
        tab_wiiremote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab_wiiremote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tab_wiiremoteMousePressed(evt);
            }
        });

        tab_mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_mouse_b.gif"))); // NOI18N
        tab_mouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab_mouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tab_mouseMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/header.gif"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tab_keyboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tab_mouse))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab_wiiremote)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab_wiiremote)
                    .addComponent(tab_mouse)
                    .addComponent(tab_keyboard)))
        );

        cardPanel.setLayout(new java.awt.CardLayout());
        cardPanel.add(cardConnect1, "cardConnect");
        cardPanel.add(cardKeyboard1, "cardKeyboard");
        cardPanel.add(cardMousePad1, "cardMousePad");
        cardPanel.add(cardWiiRemote1, "cardWiiRemote");

        statusLabel.setFont(new java.awt.Font("SansSerif", 0, 12));
        statusLabel.setForeground(new java.awt.Color(91, 120, 134));
        statusLabel.setText("Loading...");
        statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        statusLabel.setAlignmentY(0.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        statusLabel.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void tab_keyboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_keyboardMouseClicked
        showCard("cardKeyboard", evt);
    }//GEN-LAST:event_tab_keyboardMouseClicked

    private void tab_mouseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_mouseMousePressed
        showCard("cardMousePad", evt);
    }//GEN-LAST:event_tab_mouseMousePressed

    private void tab_wiiremoteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_wiiremoteMousePressed
        showCard("cardWiiRemote", evt);
    }//GEN-LAST:event_tab_wiiremoteMousePressed

    public void showConnectCard() {
        showCard("cardConnect");
    }

    public void showCard(String cardname) {
        showCard(cardname, null);
    }

    public void showCard(String cardname, java.awt.event.MouseEvent evt) {
        if(cardname.equals("cardKeyboard")) {
            tab_keyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_keyboard_a.gif")));
            tab_mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_mouse_b.gif")));
            tab_wiiremote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_wiiremote_b.gif")));
            cardKeyboard1.requestFocusInWindow();
        } else if(cardname.equals("cardMousePad")) {
            tab_keyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_keyboard_b.gif")));
            tab_mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_mouse_a.gif")));
            tab_wiiremote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_wiiremote_b.gif")));
        } else if(cardname.equals("cardWiiRemote")) {
            tab_keyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_keyboard_b.gif")));
            tab_mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_mouse_b.gif")));
            tab_wiiremote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_wiiremote_a.gif")));
        } else {
            tab_keyboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_keyboard_b.gif")));
            tab_mouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_mouse_b.gif")));
            tab_wiiremote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tab_wiiremote_b.gif")));
        }
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, cardname);

        // Request the focus again, as it has been losed to cardPanel.
        if(cardname.equals("cardKeyboard")) {
            cardKeyboard1.requestFocusInWindow();
        }
    }

    public MainController getMainController() {
        return MainController;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Viewers.Cards.CardConnect cardConnect1;
    private Viewers.Cards.CardKeyboard cardKeyboard1;
    private Viewers.Cards.CardMousePad cardMousePad1;
    private javax.swing.JPanel cardPanel;
    private Viewers.Cards.CardWiiRemote cardWiiRemote1;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel hiddenLabel;
    private javax.swing.JPanel hiddenPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel tab_keyboard;
    private javax.swing.JLabel tab_mouse;
    private javax.swing.JLabel tab_wiiremote;
    // End of variables declaration//GEN-END:variables
}
