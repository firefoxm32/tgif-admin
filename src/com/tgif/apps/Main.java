package com.tgif.apps;

import com.tgif.util.Formatter;
import com.tgif.view.FormCategoryManagement;
import com.tgif.view.FormFoodItemManagement;
import com.tgif.view.FormUserManagement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

/**
 *
 * @author JPlans
 */
public class Main extends javax.swing.JFrame {

    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    
    public static JFrame JFParent;
    public static Date SYSTEM_DATE;
    
    private JInternalFrame iframeRequest;

    public Main() {
        initComponents();
        JFParent = this;
        setExtendedState(MAXIMIZED_BOTH);
        initializeStatusBar();        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainDesktop = new javax.swing.JDesktopPane();
        jXStatusBar1 = new org.jdesktop.swingx.JXStatusBar();
        jLabelUser = new javax.swing.JLabel();
        jLabelIpAddress = new javax.swing.JLabel();
        jLabelDivision = new javax.swing.JLabel();
        jLabelSystemDate = new javax.swing.JLabel();
        jLabelSystemDate1 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jButtonCategoryManagement = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButtonFoodManagement = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButtonUserManagement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TGIF's System Admin");

        jLabelUser.setText("User");
        jXStatusBar1.add(jLabelUser);

        jLabelIpAddress.setText("IP Address");
        jXStatusBar1.add(jLabelIpAddress);

        jLabelDivision.setText("Division");
        jXStatusBar1.add(jLabelDivision);

        jLabelSystemDate.setText("Current Date");
        jXStatusBar1.add(jLabelSystemDate);

        jLabelSystemDate1.setText("Notifications:");
        jXStatusBar1.add(jLabelSystemDate1);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jButtonCategoryManagement.setText("Food Menu");
        jButtonCategoryManagement.setToolTipText("Category Management");
        jButtonCategoryManagement.setFocusable(false);
        jButtonCategoryManagement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCategoryManagement.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCategoryManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoryManagementActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonCategoryManagement);
        jToolBar2.add(jSeparator6);

        jButtonFoodManagement.setText("Food Item");
        jButtonFoodManagement.setToolTipText("Food Item Management");
        jButtonFoodManagement.setFocusable(false);
        jButtonFoodManagement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFoodManagement.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFoodManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFoodManagementActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonFoodManagement);
        jToolBar2.add(jSeparator7);

        jButtonUserManagement.setText("Users");
        jButtonUserManagement.setToolTipText("Users");
        jButtonUserManagement.setFocusable(false);
        jButtonUserManagement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUserManagement.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonUserManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserManagementActionPerformed(evt);
            }
        });
        jToolBar2.add(jButtonUserManagement);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainDesktop)
            .addComponent(jXStatusBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jMainDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXStatusBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFoodManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFoodManagementActionPerformed
        iframeRequest = showWindow(iframeRequest, new FormFoodItemManagement());
    }//GEN-LAST:event_jButtonFoodManagementActionPerformed

    private void jButtonCategoryManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoryManagementActionPerformed
        iframeRequest = showWindow(iframeRequest, new FormCategoryManagement());
    }//GEN-LAST:event_jButtonCategoryManagementActionPerformed

    private void jButtonUserManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserManagementActionPerformed
        iframeRequest = showWindow(iframeRequest, new FormUserManagement());
    }//GEN-LAST:event_jButtonUserManagementActionPerformed

    private void initializeStatusBar() {
        Date sysDate = new Date();
        SYSTEM_DATE = sysDate;
        jLabelSystemDate.setText("Current Date : " + Formatter.format(sysDate, Formatter.Date.MYSQL_FORMAT));
        jLabelUser.setText("User : Admin");
        jLabelIpAddress.setText("IP Address : " + getIpAddress());
        System.out.println("IP: "+getIpAddress());
//        jLabelDivision.setText("Division : " + DIVISION_NAME);        
    }

    private String getIpAddress() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().toString();
        }
        catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return ip;
    }
    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JInternalFrame showWindow(JInternalFrame iFrame, JInternalFrame newFrame) {
        try {
            if (iFrame.isClosed()) {
                try {
                    iFrame = newFrame;
                    iFrame.setOpaque(true);
                    iFrame.setVisible(true);
                    iFrame.setClosable(true);
                    jMainDesktop.add(iFrame);
                    iFrame.setLocation((screen.width - iFrame.getWidth()) / 2, ((screen.height - iFrame.getHeight()) / 2) - 45);
                    iFrame.setSelected(true);
                }
                catch (Exception ex1) {
                    ex1.printStackTrace();
                }
            }
            else {
                iFrame.setVisible(true);
                iFrame.setOpaque(true);
                iFrame.setSelected(true);
                iFrame.dispose();

                iFrame = newFrame;
                iFrame.setOpaque(true);
                iFrame.setVisible(true);
                iFrame.setClosable(true);
                jMainDesktop.add(iFrame);
                iFrame.setLocation((screen.width - iFrame.getWidth()) / 2, ((screen.height - iFrame.getHeight()) / 2) - 45);
                iFrame.setSelected(true);
            }
        }
        catch (Exception ex) {
            try {
                iFrame = newFrame;
                iFrame.setOpaque(true);
                iFrame.setVisible(true);
                iFrame.setClosable(true);
                jMainDesktop.add(iFrame);
                iFrame.setLocation((screen.width - iFrame.getWidth()) / 2, ((screen.height - iFrame.getHeight()) / 2) - 45);
                iFrame.setSelected(true);
            }
            catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }

        return iFrame;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setSystemLookAndFeel();
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCategoryManagement;
    private javax.swing.JButton jButtonFoodManagement;
    private javax.swing.JButton jButtonUserManagement;
    private javax.swing.JLabel jLabelDivision;
    private javax.swing.JLabel jLabelIpAddress;
    public static javax.swing.JLabel jLabelSystemDate;
    public static javax.swing.JLabel jLabelSystemDate1;
    public static javax.swing.JLabel jLabelUser;
    private static javax.swing.JDesktopPane jMainDesktop;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar2;
    private org.jdesktop.swingx.JXStatusBar jXStatusBar1;
    // End of variables declaration//GEN-END:variables
}
