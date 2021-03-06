/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.apps.Main;
import com.tgif.dao.CategoryDao;
import com.tgif.dao.UserDao;
import com.tgif.model.Category;
import com.tgif.model.User;
import com.tgif.util.TableManager;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.xswingx.PromptSupport;

/**
 *
 * @author JPlans
 */
public class FormUserManagement extends javax.swing.JInternalFrame {

    private String[] header = {"Username", "Table Number", "User Type"};
    private boolean[] cellEditable = {false, false, false};
    private int[] width = {250, 90, 90};

    /**
     * Creates new form FormSupplierManagement
     */
    public FormUserManagement() {
        initComponents();
        initTextField();
        initTable();
        jLabelSpinner.setVisible(false);
        jButtonDelete.setVisible(false);
        jComboBoxPassword.setVisible(false);
    }

    private void initTextField() {
        PromptSupport.setPrompt("Search", jTextFieldSearch);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextFieldSearch);
        PromptSupport.setForeground(Color.LIGHT_GRAY, jTextFieldSearch);
    }

    private void initTable() {
        TableManager.setModel(jXTableUser, jScrollPaneSuppliers, null, header, false, false, 0, cellEditable, width);
        getUser();
    }

    private void getUser() {
        TableManager.getTableModel(jXTableUser).setRowCount(0);
        UserDao userDao = new UserDao();
        for (User user : userDao.getUserData()) {
            jComboBoxPassword.addItem(String.valueOf(user.getPassword()));
//            String type = user.getUserType().equalsIgnoreCase("m") ? "Mobile" : "Admin";
            String utype = user.getUserType();
            String type;
            switch(utype){
                case "A" : 
                type = "Admin";
                break;
                case "C" :
                type = "Cashier";
                break;
                case "K" :
                type = "Kitchen";
                break;
                case "W" :
                type = "Waiter";
                break;
                default : 
                type = "Mobile";
                break;
            }
            TableManager.getTableModel(jXTableUser).addRow(new Object[]{
                user.getUsername(),
                user.getTableNumber(),
                type
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jComboBoxPassword = new javax.swing.JComboBox();
        jScrollPaneSuppliers = new javax.swing.JScrollPane();
        jXTableUser = new org.jdesktop.swingx.JXTable();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelSpinner = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();

        setTitle("User Management");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 90, -1));

        jButtonNew.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonNew.setText("New");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 90, -1));

        jButtonEdit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 90, -1));

        jPanel2.add(jComboBoxPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 450, -1));

        jScrollPaneSuppliers.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneSuppliers.setViewportView(jXTableUser);

        jPanel1.add(jScrollPaneSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 450, 310));

        jTextFieldSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, 23));

        jButtonSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSearch.setText("Search...");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 100, -1));

        jLabelSpinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tgif/icons/loading_icon_2_rev01.gif"))); // NOI18N
        jPanel1.add(jLabelSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 150, -1));

        jButtonDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonSearch.doClick();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        getUser();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        List<Integer> tnum = new ArrayList<>();
        for (int i = 0; i < TableManager.getTableModel(jXTableUser).getRowCount(); i++) {
            if (Integer.valueOf(TableManager.getTableModel(jXTableUser).getValueAt(i, 1).toString()) > 0) {
                tnum.add(Integer.valueOf(TableManager.getTableModel(jXTableUser).getValueAt(i, 1).toString()));
            }
        }
        FormUser form = new FormUser(Main.JFParent, true);
        form.setTitle("Add User");
        form.setLocationRelativeTo(Main.JFParent);
        form.setTableNumber(tnum);
        form.setAction("add");
        form.setVisible(true);
        jButtonSearch.doClick();
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if (jXTableUser.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Select record to edit");
            return;
        }

        User user = new User();
        String userName = TableManager.getTableModel(jXTableUser).getValueAt(jXTableUser.getSelectedRow(), 0).toString();
        user.setUsername(userName);
        int tableNumber = Integer.valueOf(TableManager.getTableModel(jXTableUser).getValueAt(jXTableUser.getSelectedRow(), 1).toString());
        user.setTableNumber(tableNumber);
        String type = TableManager.getTableModel(jXTableUser).getValueAt(jXTableUser.getSelectedRow(), 2).toString();
        user.setUserType(type);
        jComboBoxPassword.setSelectedIndex(jXTableUser.getSelectedRow());
        String password = String.valueOf(jComboBoxPassword.getSelectedItem());
        user.setPassword(password);

        FormUser form = new FormUser(Main.JFParent, true);
        form.setTitle("Edit User");
        form.setLocationRelativeTo(Main.JFParent);
        form.setUser(user);
        form.setAction("edit");
        form.setData();
        form.setVisible(true);
        form.dispose();
        jButtonSearch.doClick();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (jXTableUser.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Select record to edit");
            return;
        }
        int id = Integer.valueOf(TableManager.getTableModel(jXTableUser).getValueAt(jXTableUser.getSelectedRow(), 0).toString());
        Category category = new Category();
        String label = TableManager.getTableModel(jXTableUser).getValueAt(jXTableUser.getSelectedRow(), 1).toString();
        category.setName(label);
        category.setId(id);
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.save(category, "delete");
        jButtonSearch.doClick();
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxPassword;
    private javax.swing.JLabel jLabelSpinner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneSuppliers;
    private javax.swing.JTextField jTextFieldSearch;
    private org.jdesktop.swingx.JXTable jXTableUser;
    // End of variables declaration//GEN-END:variables
}
