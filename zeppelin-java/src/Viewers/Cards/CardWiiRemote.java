package Viewers.Cards;

import Models.MotorA;
import Models.MotorB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.wiiusejevents.physicalevents.*;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.*;

/**
 *
 * @author Gerjo Meier
 */
public class CardWiiRemote extends javax.swing.JPanel implements WiimoteListener {
    private BufferedImage imageWiiHead   = null;
    private BufferedImage imageWiiMiddle = null;

    private boolean isLeft  = false;
    private boolean isRight = false;
    private boolean isUp    = false;
    private boolean isDown  = false;
    private boolean isPlus  = false;
    private boolean isMinus = false;

    Viewers.TabbedGUI owner = null;
    public CardWiiRemote(){
        initComponents();

    }
    public CardWiiRemote(Viewers.TabbedGUI owner) {
        super();
        this.owner = owner;
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Offset used by the image, as well as their "highlighted" buttons.
        Point offsetHead   = new Point(10, 25);
        Point offsetMiddle = new Point(235, 30);

        // Sinleton to load the images only once. Placing this in the
        // Constructor will fail to load the images to begin with - Java bug?
        if(imageWiiHead == null) {
            try {
                imageWiiHead   = ImageIO.read(getClass().getResource("/Resources/wiiremote_head.png"));
                imageWiiMiddle = ImageIO.read(getClass().getResource("/Resources/wiiremote_middle.png"));
            } catch (IOException ex) { }
        }
        
        g.drawImage(imageWiiHead, offsetHead.x, offsetHead.y, null);
        g.drawImage(imageWiiMiddle, offsetMiddle.x, offsetMiddle.y, null);

        // Color of the highlighted buttons:
        g.setColor(Color.decode("0x5b7886"));

        // This routine should highlight any button currently pressed.
        if(isLeft)  drawSquare(g, 42, 95, offsetHead); // left
        if(isRight) drawSquare(g, 95, 95, offsetHead); // right
        if(isUp)    drawSquare(g, 68, 68, offsetHead); // up
        if(isDown)  drawSquare(g, 68, 122, offsetHead); // down

        if(isMinus) drawCircle(g, 23, 23, offsetMiddle); // - button
        if(isPlus)  drawCircle(g, 111, 23, offsetMiddle); // + button
    }

    public void drawSquare(Graphics g, int x, int y, Point offset) {
        g.fillRect(offset.x + x, offset.y + y, 21, 21);
    }

    public void drawCircle(Graphics g, int x, int y, Point offset) {
        g.fillOval(offset.x + x, offset.y + y, 25, 25);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/button_connect_wiimote_normal.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/button_connect_wiimote_loading.png")));
        new Thread(new Runnable() {
            public void run() {
                Wiimote[] wiimotes = WiiUseApiManager.getWiimotes(1, true);
                if(wiimotes.length > 0) {
                    wiimotes[0].addWiiMoteEventListeners(getThis());
                } else {
                    System.out.println("nahh");
                }
                jLabel1.setVisible(false);
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/button_connect_wiimote_normal.png")));
            }
        }).start();

    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void onButtonsEvent(WiimoteButtonsEvent wbe) {
        if(wbe.isButtonLeftPressed()) {
            isLeft = true;
            owner.getMainController().getZeppelinController().engineAstate(MotorA.LEFT);
        } else {
            isLeft = false;
            owner.getMainController().getZeppelinController().engineAstate(MotorA.HALT);
        }

        if(wbe.isButtonRightPressed()) {
            isRight = true;
            owner.getMainController().getZeppelinController().engineAstate(MotorB.LEFT);
        } else {
            isRight = false;
            owner.getMainController().getZeppelinController().engineAstate(MotorB.HALT);
        }

        if(wbe.isButtonUpPressed()) {
            isUp = true;
        } else {
            isUp = false;
        }
        
        if(wbe.isButtonDownPressed()) {
            isDown = true;
        } else {
            isDown = false;
        }

        if(wbe.isButtonPlusPressed()) {
            isPlus = true;
            owner.getMainController().getZeppelinController().write("g");
        } else {
            isPlus = false;
        }
        
        if(wbe.isButtonMinusPressed()) {
            isMinus = true;
            owner.getMainController().getZeppelinController().write("f");
        } else {
            isMinus = false;
        }
        repaint();
    }

    public void onIrEvent(IREvent ire) {}
    public void onMotionSensingEvent(MotionSensingEvent mse) {}
    public void onExpansionEvent(ExpansionEvent ee) {}
    public void onStatusEvent(StatusEvent se) {}
    public void onDisconnectionEvent(DisconnectionEvent de) {}
    public void onNunchukInsertedEvent(NunchukInsertedEvent nie) {}
    public void onNunchukRemovedEvent(NunchukRemovedEvent nre) {}
    public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent ghie) {}
    public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent ghre) {}
    public void onClassicControllerInsertedEvent(ClassicControllerInsertedEvent ccie) {}
    public void onClassicControllerRemovedEvent(ClassicControllerRemovedEvent ccre) {}
    public CardWiiRemote getThis() {
        return this;
    }
}