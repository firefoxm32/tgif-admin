/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.apps.Main;
import com.tgif.dao.FoodItemsDao;
import com.tgif.model.Category;
import com.tgif.model.FoodItem;
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
public class FormFoodItemManagement extends javax.swing.JInternalFrame {

    private String[] header = {"Item Id", "Category Name", "Item Name", "Image", "Description", "Promo Price", "Promo Status"};
    private boolean[] cellEditable = {false, false, false, false, false, false, false};
    private int[] width = {100, 150, 150, 150, 500, 100, 100};
    private String[] fields = {"", "item_id", "label", "menu_name", "image"};

    /**
     * Creates new form FormSupplierManagement
     */
    public FormFoodItemManagement() {
        initComponents();
        initTextField();
        initTable();
        jLabelSpinner.setVisible(false);
    }

    private void initTextField() {
        PromptSupport.setPrompt("Search", jTextFieldSearch);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextFieldSearch);
        PromptSupport.setForeground(Color.LIGHT_GRAY, jTextFieldSearch);
    }

    private void initTable() {
        TableManager.setModel(jXTableSuppliers, jScrollPaneSuppliers, null, header, false, false, 0, cellEditable, width);
        getfoodItem("", "");
    }

    private void getfoodItem(String field, String value) {
        TableManager.getTableModel(jXTableSuppliers).setRowCount(0);
        FoodItemsDao foodItemsDao = new FoodItemsDao();
        for (FoodItem foodItem : foodItemsDao.getFoodItems(field, value)) {
            TableManager.getTableModel(jXTableSuppliers).addRow(new Object[]{
                foodItem.getItemId(),
                foodItem.getCategory().getName(),
                foodItem.getItemName(),
                foodItem.getImage(),
                foodItem.getDescription(),
                foodItem.getPromoPrice(),
                foodItem.getPromoStatus()
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
        jButtonDelete = new javax.swing.JButton();
        jButtonPromo = new javax.swing.JButton();
        jScrollPaneSuppliers = new javax.swing.JScrollPane();
        jXTableSuppliers = new org.jdesktop.swingx.JXTable();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelSpinner = new javax.swing.JLabel();
        jComboBoxField = new javax.swing.JComboBox();

        setTitle("Food Item Management");
        setPreferredSize(new java.awt.Dimension(705, 440));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 90, -1));

        jButtonNew.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonNew.setText("New");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 90, -1));

        jButtonEdit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 90, -1));

        jButtonDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 90, -1));

        jButtonPromo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonPromo.setText("Promo");
        jButtonPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPromoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 510, -1));

        jScrollPaneSuppliers.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTableSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPaneSuppliers.setViewportView(jXTableSuppliers);

        jPanel1.add(jScrollPaneSuppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 670, 310));

        jTextFieldSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 420, 23));

        jButtonSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSearch.setText("Search...");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 100, -1));

        jLabelSpinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tgif/icons/loading_icon_2_rev01.gif"))); // NOI18N
        jPanel1.add(jLabelSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 150, -1));

        jComboBoxField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Field", "Item Id", "Category Name", "Item Name", "Image" }));
        jComboBoxField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFieldItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 135, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonSearch.doClick();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        if (jComboBoxField.getSelectedIndex() > 0) {
            getfoodItem(fields[jComboBoxField.getSelectedIndex()], jTextFieldSearch.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Please select field");
            jComboBoxField.requestFocus();
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        List<String> itemNames = new ArrayList<>();
        for(int i = 0; i < jXTableSuppliers.getRowCount(); i++) {
            itemNames.add(jXTableSuppliers.getValueAt(i, 2).toString().toLowerCase());
        }
        FormFoodItem form = new FormFoodItem(Main.JFParent, true);
        form.setTitle("Add Food Item");
        form.setItemNames(itemNames);
        form.setLocationRelativeTo(Main.JFParent);
        form.setVisible(true);
//        jButtonSearch.doClick();

        getfoodItem("", "");
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        List<String> itemNames = new ArrayList<>();
        for(int i = 0; i < jXTableSuppliers.getRowCount(); i++) {
            itemNames.add(jXTableSuppliers.getValueAt(i, 2).toString().toLowerCase());
        }
        if (jXTableSuppliers.getSelectedRow() >= 0) {
            int itemId = Integer.valueOf(jXTableSuppliers.getValueAt(jXTableSuppliers.getSelectedRow(), 0).toString());
            String categoryName = jXTableSuppliers.getValueAt(jXTableSuppliers.getSelectedRow(), 1).toString();
            String itemName = jXTableSuppliers.getValueAt(jXTableSuppliers.getSelectedRow(), 2).toString();
            String image = jXTableSuppliers.getValueAt(jXTableSuppliers.getSelectedRow(), 3).toString();
            String description = jXTableSuppliers.getValueAt(jXTableSuppliers.getSelectedRow(), 4).toString();

            FoodItem foodItem = new FoodItem();
            Category category = new Category();
            category.setName(categoryName);
            foodItem.setItemId(itemId);
            foodItem.setItemName(itemName);
            foodItem.setImage(image);
            foodItem.setDescription(description);
            foodItem.setCategory(category);


            FormFoodItem form = new FormFoodItem(Main.JFParent, true);
            form.setTitle("Edit Food Item");
            form.setItemNames(itemNames);
            form.setLocationRelativeTo(Main.JFParent);
            form.setFoodItem(foodItem);
            form.setData();
            form.setVisible(true);
            form.dispose();
            getfoodItem("", "");
        } else {
            JOptionPane.showMessageDialog(this, "Select record to edit");
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (jXTableSuppliers.getSelectedRow() >= 0) {
            int id = Integer.valueOf(TableManager.getTableModel(jXTableSuppliers).getValueAt(jXTableSuppliers.getSelectedRow(), 0).toString());
            FoodItem foodItem = new FoodItem();
            foodItem.setItemId(id);
            FoodItemsDao foodItemsDao = new FoodItemsDao();
            foodItemsDao.editDelete(foodItem, "delete");
            getfoodItem("", "");
        } else {
            JOptionPane.showMessageDialog(this, "Select record to edit");
        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jComboBoxFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFieldItemStateChanged
        if (jComboBoxField.getSelectedIndex() != 0) {
            jTextFieldSearch.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxFieldItemStateChanged

    private void jButtonPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPromoActionPerformed
        System.out.println(jXTableSuppliers.getSelectedRow());
        if (jXTableSuppliers.getSelectedRow() >= 0) {
            int id = Integer.valueOf(TableManager.getTableModel(jXTableSuppliers).getValueAt(jXTableSuppliers.getSelectedRow(), 0).toString());
            String itemName = TableManager.getTableModel(jXTableSuppliers).getValueAt(jXTableSuppliers.getSelectedRow(), 2).toString();
            String promoStatus = TableManager.getTableModel(jXTableSuppliers).getValueAt(jXTableSuppliers.getSelectedRow(), 6).toString();
            Double promoPrice = Double.valueOf(TableManager.getTableModel(jXTableSuppliers).getValueAt(jXTableSuppliers.getSelectedRow(), 5).toString());

            FoodItem foodItem = new FoodItem();
            foodItem.setItemId(id);
            foodItem.setItemName(itemName);
            foodItem.setPromoPrice(promoPrice);
            foodItem.setPromoStatus(promoStatus);
            FormPromo formPromo = new FormPromo(Main.JFParent, true);
            formPromo.setTitle("Add/Edit Promo");
            formPromo.setLocationRelativeTo(Main.JFParent);
            formPromo.setFoodItem(foodItem);
            formPromo.setData();
            formPromo.setVisible(true);
            getfoodItem("", "");
        } else {
            JOptionPane.showMessageDialog(this, "Select record to edit");
        }
    }//GEN-LAST:event_jButtonPromoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonPromo;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxField;
    private javax.swing.JLabel jLabelSpinner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneSuppliers;
    private javax.swing.JTextField jTextFieldSearch;
    private org.jdesktop.swingx.JXTable jXTableSuppliers;
    // End of variables declaration//GEN-END:variables
}
