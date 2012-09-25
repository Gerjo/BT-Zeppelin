package Viewers.Cards;

import Models.MotorA;
import Models.MotorB;
import static Miscellaneous.DebugTools.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Gerjo Meier
 */
public class CardKeyboard extends javax.swing.JPanel implements KeyListener {
    Viewers.TabbedGUI owner = null;

    private boolean isLeftArrowKey      = false;
    private boolean isRightArrowKey     = false;
    private boolean isUpArrowKey        = false;
    private boolean isDownArrowKey      = false;

    private ImageIcon[] leftArrowImage  = new ImageIcon[2];
    private ImageIcon[] rightArrowImage = new ImageIcon[2];
    private ImageIcon[] upArrowImage    = new ImageIcon[2];
    private ImageIcon[] downArrowImage  = new ImageIcon[2];

    public CardKeyboard(){
        leftArrowImage[1]  = new ImageIcon(getClass().getResource("/Resources/arrow_left_blue.gif"));
        leftArrowImage[0]  = new ImageIcon(getClass().getResource("/Resources/arrow_left_red.gif"));

        rightArrowImage[1] = new ImageIcon(getClass().getResource("/Resources/arrow_right_blue.gif"));
        rightArrowImage[0] = new ImageIcon(getClass().getResource("/Resources/arrow_right_red.gif"));

        upArrowImage[1]   = new ImageIcon(getClass().getResource("/Resources/arrow_up_blue.gif"));
        upArrowImage[0]   = new ImageIcon(getClass().getResource("/Resources/arrow_up_red.gif"));

        downArrowImage[1] = new ImageIcon(getClass().getResource("/Resources/arrow_down_blue.gif"));
        downArrowImage[0] = new ImageIcon(getClass().getResource("/Resources/arrow_down_red.gif"));

        initComponents();
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();
    }

    public CardKeyboard(Viewers.TabbedGUI owner) {
        this();
        this.owner = owner;
    }

    public void keyPressed(KeyEvent e) {
        updateKeyPad(e.getKeyCode(), true);
    }
    public void keyReleased(KeyEvent e) {
        updateKeyPad(e.getKeyCode(), false);
    }
    public void keyTyped(KeyEvent e) {
        
    }

    public void updateKeyPad(int keyCode, boolean isKeyDown) {
        // Using intentional fallthrough to catch both the numeric and arrow keys
        // and the normal arrow keys. Each "block" should not have more than 2 cases.
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_KP_LEFT:
                isLeftArrowKey = isKeyDown;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_KP_RIGHT:
                isRightArrowKey = isKeyDown;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_KP_UP:
                isUpArrowKey = isKeyDown;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_KP_DOWN:
                isDownArrowKey = isKeyDown;
                break;
            default:
                break;
        }

        setIcon(leftLabel,  (isLeftArrowKey)  ? leftArrowImage[0]:leftArrowImage[1]);
        setIcon(rightLabel, (isRightArrowKey) ? rightArrowImage[0]:rightArrowImage[1]);
        setIcon(upLabel,    (isUpArrowKey)    ? upArrowImage[0]:upArrowImage[1]);
        setIcon(downLabel,  (isDownArrowKey)  ? downArrowImage[0]:downArrowImage[1] );

        owner.getMainController().getZeppelinController().engineAstate (
               (isLeftArrowKey) ? MotorA.LEFT:MotorA.HALT);

        owner.getMainController().getZeppelinController().engineBstate (
               (isRightArrowKey) ? MotorB.LEFT:MotorB.HALT);

        setIcon(leftLabel,  (isLeftArrowKey)  ? leftArrowImage[0]:leftArrowImage[1]);
        setIcon(rightLabel, (isRightArrowKey) ? rightArrowImage[0]:rightArrowImage[1]);
        setIcon(upLabel,    (isUpArrowKey)    ? upArrowImage[0]:upArrowImage[1]);
        setIcon(downLabel,  (isDownArrowKey)  ? downArrowImage[0]:downArrowImage[1] );

        owner.getMainController().getZeppelinController().engineAstate (
               (isLeftArrowKey) ? MotorA.LEFT:MotorA.HALT);

        owner.getMainController().getZeppelinController().engineBstate (
               (isRightArrowKey) ? MotorB.LEFT:MotorB.HALT);

        if(isUpArrowKey) {
            owner.getMainController().getZeppelinController().incrementServo();
        }
        if(isDownArrowKey) {
            owner.getMainController().getZeppelinController().decrementServo();
        }

    }

    private void setIcon(JLabel target, ImageIcon icon) {
        target.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        downLabel = new javax.swing.JLabel();
        rightLabel = new javax.swing.JLabel();
        leftLabel = new javax.swing.JLabel();
        upLabel = new javax.swing.JLabel();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        downLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/arrow_down_blue.gif"))); // NOI18N
        downLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                downLabelMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                downLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                downLabelMouseReleased(evt);
            }
        });

        rightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/arrow_right_blue.gif"))); // NOI18N
        rightLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rightLabelMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rightLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rightLabelMouseReleased(evt);
            }
        });

        leftLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/arrow_left_blue.gif"))); // NOI18N
        leftLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leftLabelMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                leftLabelMouseReleased(evt);
            }
        });

        upLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/arrow_up_blue.gif"))); // NOI18N
        upLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        upLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                upLabelMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                upLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                upLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(leftLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(downLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightLabel)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(upLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(downLabel)
                            .addComponent(rightLabel)))
                    .addComponent(leftLabel))
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        //out("focus");
    }//GEN-LAST:event_formFocusGained

    private void leftLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftLabelMousePressed
        updateKeyPad(KeyEvent.VK_LEFT, true);
    }//GEN-LAST:event_leftLabelMousePressed

    private void downLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downLabelMousePressed
        updateKeyPad(KeyEvent.VK_DOWN, true);
    }//GEN-LAST:event_downLabelMousePressed

    private void rightLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightLabelMousePressed
        updateKeyPad(KeyEvent.VK_RIGHT, true);
    }//GEN-LAST:event_rightLabelMousePressed

    private void upLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upLabelMousePressed
        updateKeyPad(KeyEvent.VK_UP, true);
    }//GEN-LAST:event_upLabelMousePressed

    private void leftLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftLabelMouseReleased
        updateKeyPad(KeyEvent.VK_LEFT, false);
    }//GEN-LAST:event_leftLabelMouseReleased

    private void downLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downLabelMouseReleased
        updateKeyPad(KeyEvent.VK_DOWN, false);
    }//GEN-LAST:event_downLabelMouseReleased

    private void rightLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightLabelMouseReleased
        updateKeyPad(KeyEvent.VK_RIGHT, false);
    }//GEN-LAST:event_rightLabelMouseReleased

    private void upLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upLabelMouseReleased
        updateKeyPad(KeyEvent.VK_UP, false);
    }//GEN-LAST:event_upLabelMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel downLabel;
    private javax.swing.JLabel leftLabel;
    private javax.swing.JLabel rightLabel;
    private javax.swing.JLabel upLabel;
    // End of variables declaration//GEN-END:variables

}
