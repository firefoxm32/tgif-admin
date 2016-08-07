/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.dao.UserDao;
import com.tgif.model.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Mon
 */
public class FormUser extends javax.swing.JDialog {

    private User user;
    private String action;

    public void setAction(String action) {
        this.action = action;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setData() {
        if (this.user != null) {
            jTextFieldUsername.setText(this.user.getUsername());
            jPasswordFieldPassword.setText(this.user.getPassword());
            jComboBoxTableNumber.setSelectedIndex(this.user.getTableNumber());
            if (this.user.getUserType().equalsIgnoreCase("Mobile")) {
                jRadioButtonMobile.setSelected(true);
            } else {
                jRadioButtonAdmin.setSelected(true);
            }
            jTextFieldUsername.setEnabled(false);
        } else {
            System.out.println("null");
        }
    }

    /**
     * Creates new form FormUser
     */
    public FormUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonMobile = new javax.swing.JRadioButton();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxTableNumber = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Username:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 30));

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 270, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 30));

        jPasswordFieldPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 270, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Table Number:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("User Type:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

        buttonGroup1.add(jRadioButtonMobile);
        jRadioButtonMobile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonMobile.setText("Mobile");
        jPanel1.add(jRadioButtonMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 30));

        buttonGroup1.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonAdmin.setText("Admin");
        jPanel1.add(jRadioButtonAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 70, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 380, 10));

        jComboBoxTableNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxTableNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Number", "1", "2", "3", "4", "5", "6" }));
        jPanel1.add(jComboBoxTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        saveUser();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveUser() {
        System.out.println("action: "+this.action);
        System.out.println("pass: " + String.valueOf(jPasswordFieldPassword.getPassword()));
        if (jTextFieldUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input username");
            jTextFieldUsername.requestFocus();
            return;
        }
        if (String.valueOf(jPasswordFieldPassword.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Input password");
            jPasswordFieldPassword.requestFocus();
            return;
        }
        if (jComboBoxTableNumber.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select table number");
            jComboBoxTableNumber.requestFocus();
            return;
        }
        if (jRadioButtonMobile.isSelected() == false && jRadioButtonAdmin.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Select user type");
            return;
        }
        User localUser = new User();
        localUser.setUsername(jTextFieldUsername.getText());
        localUser.setPassword(String.valueOf(jPasswordFieldPassword.getPassword()));
        localUser.setTableNumber(Integer.valueOf(jComboBoxTableNumber.getSelectedItem().toString()));
        String type = jRadioButtonAdmin.isSelected() ? "Admin" : "Mobile";
        localUser.setUserType(type);
        UserDao userDao = new UserDao();
        userDao.save(localUser, this.action);
        clearData();
    }
    
    private void clearData() {
        jTextFieldUsername.setText("");
        jComboBoxTableNumber.setSelectedIndex(0);
        jPasswordFieldPassword.setText("");
        jRadioButtonAdmin.setSelected(false);
        jRadioButtonMobile.setSelected(false);
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBoxTableNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonMobile;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
