/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.apps.Main;
import com.tgif.dao.MembershipDAO;
import com.tgif.model.Category;
import com.tgif.model.Membership;
import com.tgif.util.TableManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mon
 */
public class FormMemberShipManagement extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormMemberShipManagement
     */
    
    private String[] header = {"Membership ID", "Name", "Address", "Contact", "Status"};
    private boolean[] cellEditable = {false, false, false, false, false};
    private int[] width = {100, 100, 150, 120, 100};
    
    public FormMemberShipManagement() {
        initComponents();
        initTable();
        getMembers();
    }
    private void initTable() {
        TableManager.setModel(jXTableMembers, jScrollPane1, null, header, false, false, 0, cellEditable, width);
    }
    
    private void getMembers() {
        TableManager.getTableModel(jXTableMembers).setRowCount(0);
        MembershipDAO mdao = new MembershipDAO();
        for (Membership membership : mdao.getMembers()) {
            TableManager.getTableModel(jXTableMembers).addRow(new Object[]{
                membership.getMemberId(),
                membership.getName(),
                membership.getAddress(),
                membership.getContactNumber(),
                membership.getStatus()
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
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTableMembers = new org.jdesktop.swingx.JXTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();

        setTitle("Members");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 23));

        jButtonSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSearch.setText("Search...");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 100, -1));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTableMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jXTableMembers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 420, 310));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 90, -1));

        jButtonAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 90, -1));

        jButtonEdit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 360, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonSearch.doClick();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        getMembers();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        List<String> membershipId = new ArrayList<>();
        for (int i = 0; i < jXTableMembers.getRowCount(); i++) {
            membershipId.add(TableManager.getTableModel(jXTableMembers).getValueAt(i, 0).toString().toLowerCase());
        }
        FormMemberShip form = new FormMemberShip(Main.JFParent, true);
        form.setTitle("Add Member");
        form.setMemberShipId(membershipId);
        form.setLocationRelativeTo(Main.JFParent);
        form.setVisible(true);
        form.dispose();
        jButtonSearch.doClick();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        List<String> memberShipId = new ArrayList<>();
        for(int i = 0; i < jXTableMembers.getRowCount(); i++) {
            memberShipId.add(TableManager.getTableModel(jXTableMembers).getValueAt(i, 1).toString().toLowerCase());
        }
        if (jXTableMembers.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Select record to edit");
            return;
        }
        
        Membership m = new Membership();
        String id = jXTableMembers.getValueAt(jXTableMembers.getSelectedRow(), 0).toString();
        String name = jXTableMembers.getValueAt(jXTableMembers.getSelectedRow(), 1).toString();
        String address = jXTableMembers.getValueAt(jXTableMembers.getSelectedRow(), 2).toString();
        String contactNum = jXTableMembers.getValueAt(jXTableMembers.getSelectedRow(), 3).toString();
        String status = jXTableMembers.getValueAt(jXTableMembers.getSelectedRow(), 4).toString();
        
        m.setMemberId(id);
        m.setName(name);
        m.setAddress(address);
        m.setContactNumber(contactNum);
        m.setStatus(status);
        
        FormMemberShip form = new FormMemberShip(Main.JFParent, true);
        form.setTitle("Edit Membership");
        form.setLocationRelativeTo(Main.JFParent);
        form.setMembership(m);
        form.setMemberShipId(memberShipId);
        form.setData();
        form.setVisible(true);
        form.dispose();
        jButtonSearch.doClick();
    }//GEN-LAST:event_jButtonEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    private org.jdesktop.swingx.JXTable jXTableMembers;
    // End of variables declaration//GEN-END:variables
}
