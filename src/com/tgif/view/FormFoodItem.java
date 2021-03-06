/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.dao.CategoryDao;
import com.tgif.dao.FoodItemsDao;
import com.tgif.model.Category;
import com.tgif.model.FoodItem;
import com.tgif.model.Sauce;
import com.tgif.model.Serving;
import com.tgif.model.SideDish;
import com.tgif.util.Globals;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mon
 */
public class FormFoodItem extends javax.swing.JDialog {

    private FoodItem foodItem;
    private List<String> itemNames;
    private String formAction = "add";
    private DefaultListModel<String> listServings;
    private DefaultListModel<Double> listPrices;
    private DefaultListModel<String> listSauces;
    private DefaultListModel<String> listSideDishes;
    private List<Integer> servingIds;
    private List<Integer> sauceIds;
    private List<Integer> sideDishIds;
    private List<Integer> rServingIds;
    private List<Integer> rSauceIds;
    private List<Integer> rSideDishIds;
//    private DecimalFormat formatter = new DecimalFormat("#,##0.00");

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    /**
     * Creates new form FormFoodItem
     */
    public FormFoodItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextFieldimage.setVisible(false);
        jTextFieldItemId.setVisible(false);
        jComboBoxCategoryId.setVisible(false);
        listServings = new DefaultListModel<>();
        listPrices = new DefaultListModel<>();
        listSauces = new DefaultListModel<>();
        listSideDishes = new DefaultListModel<>();

        getCategory();
    }

    public void setData() {
        if (this.foodItem != null) {
            jTextFieldName.setEnabled(false);
            jButtonBrowse.setEnabled(false);
            jTextFieldItemId.setText(String.valueOf(this.foodItem.getItemId()));
            jTextFieldName.setText(this.foodItem.getItemName());
            jComboBoxCategory.setSelectedItem(this.foodItem.getCategory().getName());
//            jTextFieldimage.setText(this.foodItem.getImage());
            jTextFieldimage.setText(Globals.HTTP + Globals.URI + "/images/" + this.foodItem.getImage());
            jTextFieldImageName.setText(this.foodItem.getImage());
            jTextAreaDescription.setText(this.foodItem.getDescription());
            if (this.foodItem.getPromoStatus().equalsIgnoreCase("I")) {
                jRadioButtonNotPromo.setSelected(true);
            } else {
                jRadioButtonPromo.setSelected(true);
            }

            this.formAction = "edit";

            FoodItemsDao foodItemsDao = new FoodItemsDao();
            this.foodItem = foodItemsDao.getFoodItemDetails(Integer.valueOf(jTextFieldItemId.getText()));
            System.out.println("servings:: " + this.foodItem.getServings().size());
            List<Serving> servings = this.foodItem.getServings();
            servingIds = new ArrayList<>();
            if (servings.size() > 0) {
                for (int i = 0; i < servings.size(); i++) {
                    servingIds.add(servings.get(i).getServingId());
                    listServings.addElement(servings.get(i).getServingName());
                    listPrices.addElement(servings.get(i).getPrice());
                    jListServing.setModel(listServings);
                    jListPrice.setModel(listPrices);
                }
            }
            System.out.println("sauces:: " + this.foodItem.getSauces().size());
            List<Sauce> sauces = this.foodItem.getSauces();
            sauceIds = new ArrayList<>();
            if (sauces.size() > 0) {
                for (int i = 0; i < sauces.size(); i++) {
                    sauceIds.add(sauces.get(i).getSauceId());
                    listSauces.addElement(sauces.get(i).getSauceName());
                    jListSauce.setModel(listSauces);
                }
            }
            System.out.println("side_dish: " + this.foodItem.getSideDishes().size());
            List<SideDish> sideDishes = this.foodItem.getSideDishes();
            sideDishIds = new ArrayList<>();
            if (sideDishes.size() > 0) {
                for (int i = 0; i < sideDishes.size(); i++) {
                    sideDishIds.add(sideDishes.get(i).getSideDishId());
                    listSideDishes.addElement(sideDishes.get(i).getSideDishName());
                    jListSideDish.setModel(listSideDishes);
                }
            }

            rServingIds = new ArrayList<>();
            rSauceIds = new ArrayList<>();
            rSideDishIds = new ArrayList<>();
        } else {
            System.out.println("null");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldimage = new javax.swing.JTextField();
        jComboBoxCategory = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxCategoryId = new javax.swing.JComboBox();
        jTextFieldItemId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldServing = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSauces = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSideDish = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListServing = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListPrice = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSauce = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListSideDish = new javax.swing.JList();
        jButtonRemoveServing = new javax.swing.JButton();
        jButtonRemovePrice = new javax.swing.JButton();
        jButtonRemoveSauce = new javax.swing.JButton();
        jButtonRemoveSideDish = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jRadioButtonPromo = new javax.swing.JRadioButton();
        jRadioButtonNotPromo = new javax.swing.JRadioButton();
        jButtonBrowse = new javax.swing.JButton();
        jTextFieldImageName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 23));

        jTextFieldName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 500, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Category:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 23));

        jTextFieldimage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldimage.setEnabled(false);
        jPanel1.add(jTextFieldimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 170, 30));

        jComboBoxCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Category" }));
        jComboBoxCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoryItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 500, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Description:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 70, 23));

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 430, 70));

        jButtonSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 80, 30));

        jButtonCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 80, 30));

        jComboBoxCategoryId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Category Id" }));
        jPanel1.add(jComboBoxCategoryId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 320, -1));
        jPanel1.add(jTextFieldItemId, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 10, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Image:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Serving:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 60, 23));

        jTextFieldServing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldServing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldServingKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldServing, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Sauce:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 60, 23));

        jTextFieldSauces.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldSauces.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSaucesKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldSauces, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 250, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Side Dish:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 90, 23));

        jTextFieldSideDish.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldSideDish.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSideDishKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldSideDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 250, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Price:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, 23));

        jTextFieldPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPriceKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 250, 30));

        jListServing.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jListServing);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 190, 60));

        jListPrice.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jListPrice);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 190, 60));

        jListSauce.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jListSauce);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 190, 60));

        jListSideDish.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jListSideDish);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 190, 60));

        jButtonRemoveServing.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRemoveServing.setText("-");
        jButtonRemoveServing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveServingActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemoveServing, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 40, 60));

        jButtonRemovePrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRemovePrice.setText("-");
        jButtonRemovePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemovePriceActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemovePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 40, 60));

        jButtonRemoveSauce.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRemoveSauce.setText("-");
        jButtonRemoveSauce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveSauceActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemoveSauce, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 40, 60));

        jButtonRemoveSideDish.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRemoveSideDish.setText("-");
        jButtonRemoveSideDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveSideDishActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemoveSideDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 40, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Promo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 60, 30));

        buttonGroup1.add(jRadioButtonPromo);
        jRadioButtonPromo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonPromo.setText("Promo");
        jPanel1.add(jRadioButtonPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, -1, 30));

        buttonGroup1.add(jRadioButtonNotPromo);
        jRadioButtonNotPromo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonNotPromo.setText("Not Promo");
        jPanel1.add(jRadioButtonNotPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, 30));

        jButtonBrowse.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonBrowse.setText("Browse");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, 30));

        jTextFieldImageName.setEnabled(false);
        jPanel1.add(jTextFieldImageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 370, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
//        if (this.itemNames.contains(jTextFieldName.getText().toLowerCase()) && this.formAction.equalsIgnoreCase("add")) {
//            JOptionPane.showMessageDialog(this, "Item name already exist");
//            return;
//        }
        if (jTextFieldName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter item name");
            jTextFieldName.requestFocus();
        } else if (jComboBoxCategory.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select category");
            jComboBoxCategory.requestFocus();
        } else if (listServings.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter serving");
            jTextFieldServing.requestFocus();
        } else if (listPrices.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter price");
            jTextFieldPrice.requestFocus();
        } else if (jTextFieldimage.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select item image");
            jTextFieldimage.requestFocus();
        } else if (jRadioButtonNotPromo.isSelected() == false && jRadioButtonPromo.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Select if promo or not");
        } else if (jTextAreaDescription.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter description");
            jTextAreaDescription.requestFocus();
        } else if (listServings.getSize() != listPrices.getSize()) {

            JOptionPane.showMessageDialog(this, "Servings and Prices not equal.");
        } else {
            FoodItem localFoodItem = new FoodItem();
            Category category = new Category();
            FoodItemsDao foodItemsDao = new FoodItemsDao();
            String price = "";
            String subPrice = "";
            String servingName = "";
            String subServingName = "";
            String sauceName = "";
            String subSauceName = "";
            String sideDishName = "";
            String subSideDishName = "";
            if (listServings.size() > 0) {
                for (int i = 0; i < listServings.size(); i++) {
                    price += listPrices.getElementAt(i) + ",";
                    servingName += listServings.getElementAt(i) + ",";
                }
                subPrice = price.substring(0, price.length() - 1);
                subServingName = servingName.substring(0, servingName.length() - 1);
            }
            if (listSauces.size() > 0) {
                for (int i = 0; i < listSauces.size(); i++) {
                    sauceName += listSauces.getElementAt(i) + ",";
                }
                subSauceName = sauceName.substring(0, sauceName.length() - 1);
            }
            if (listSideDishes.size() > 0) {
                for (int i = 0; i < listSideDishes.size(); i++) {
                    sideDishName += listSideDishes.getElementAt(i) + ",";
                }
                subSideDishName = sideDishName.substring(0, sideDishName.length() - 1);
            }
            System.out.println("action: " + this.formAction);
            if (this.formAction.equals("add") || this.formAction.equals("edit")) {
                localFoodItem.setPrice(subPrice);
                localFoodItem.setServingName(subServingName);
                localFoodItem.setSauceName(subSauceName);
                localFoodItem.setSideDishName(subSideDishName);
                localFoodItem.setItemName(jTextFieldName.getText().trim());
                localFoodItem.setDescription(jTextAreaDescription.getText().trim());
                localFoodItem.setImage(jTextFieldimage.getText().trim());
                category.setId(Integer.valueOf(jComboBoxCategoryId.getSelectedItem().toString()));
                localFoodItem.setCategory(category);
                if (this.formAction.equals("add")) {
                    try {
                        if (createDir()) {
                            if (copyPasteImage()) {
                                foodItemsDao.add(localFoodItem);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Cannot create directory");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String servingId = "";
                    String servId = "";
                    String sauceId = "";
                    String sId = "";
                    String sideDishId = "";
                    String sdId = "";
                    if (servingIds.size() > 0) {
                        for (int i = 0; i < servingIds.size(); i++) {
                            servingId += servingIds.get(i) + ",";
                        }
                        servId = servingId.substring(0, servingId.length() - 1);
                    }
                    if (sauceIds.size() > 0) {
                        for (int i = 0; i < sauceIds.size(); i++) {
                            sauceId += sauceIds.get(i) + ",";
                        }
                        sId = sauceId.substring(0, sauceId.length() - 1);
                    }
                    if (sideDishIds.size() > 0) {
                        for (int i = 0; i < sideDishIds.size(); i++) {
                            sideDishId += sideDishIds.get(i) + ",";
                        }
                        sdId = sideDishId.substring(0, sideDishId.length() - 1);
                    }
                    String rServId = "", rSauceId = "", rSideDishId = "";
                    String _rServId = "", _rSauceId = "", _rSideDishId = "";
                    if (rServingIds.size() > 0) {
                        for (int i = 0; i < rServingIds.size(); i++) {
                            rServId += rServingIds.get(i) + ",";
                        }
                        _rServId = rServId.substring(0, rServId.length() - 1);
                    }
                    if (rSauceIds.size() > 0) {
                        for (int i = 0; i < rSauceIds.size(); i++) {
                            rSauceId += rSauceIds.get(i) + ",";
                        }
                        _rSauceId = rSauceId.substring(0, rSauceId.length() - 1);
                    }
                    if (rSideDishIds.size() > 0) {
                        for (int i = 0; i < rSideDishIds.size(); i++) {
                            rSideDishId += rSideDishIds.get(i) + ",";
                        }
                        _rSideDishId = rSideDishId.substring(0, rSideDishId.length() - 1);
                    }
                    if (jRadioButtonNotPromo.isSelected()) {
                        localFoodItem.setPromoStatus("I");
                    } else {
                        localFoodItem.setPromoStatus("A");
                    }
                    localFoodItem.setrServingId(_rServId);
                    localFoodItem.setrSauceId(_rSauceId);
                    localFoodItem.setrSideDishId(_rSideDishId);
                    localFoodItem.setServingId(servId);
                    localFoodItem.setSauceId(sId);
                    localFoodItem.setSideDishId(sdId);
                    localFoodItem.setItemId(Integer.valueOf(jTextFieldItemId.getText()));
                    
//                    try {
//                        if (createDir()) {
//                            if (copyPasteImage()) {
                                foodItemsDao.editDelete(localFoodItem, this.formAction);
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(this, "Cannot create directory");
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    this.dispose();
                }
            }
            clearData();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jComboBoxCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoryItemStateChanged
        jComboBoxCategoryId.setSelectedIndex(jComboBoxCategory.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxCategoryItemStateChanged

    private void jTextFieldServingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldServingKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!jTextFieldServing.getText().isEmpty()) {
                if (!listServings.contains(jTextFieldServing.getText())) {
                    listServings.addElement(jTextFieldServing.getText());
                    jTextFieldServing.setText("");
                    jListServing.setModel(listServings);
                } else {
                    JOptionPane.showMessageDialog(this, "Serving exist!");
                }
            }
        }
    }//GEN-LAST:event_jTextFieldServingKeyPressed

    private void jTextFieldSaucesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSaucesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!jTextFieldSauces.getText().isEmpty()) {
                if (!listSauces.contains(jTextFieldSauces.getText())) {
                    listSauces.addElement(jTextFieldSauces.getText());
                    jTextFieldSauces.setText("");
                    jListSauce.setModel(listSauces);
                } else {
                    JOptionPane.showMessageDialog(this, "Sauce exist!");
                }
            }
        }
    }//GEN-LAST:event_jTextFieldSaucesKeyPressed

    private void jTextFieldSideDishKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSideDishKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!jTextFieldSideDish.getText().isEmpty()) {
                if (!listSideDishes.contains(jTextFieldSideDish.getText())) {
                    listSideDishes.addElement(jTextFieldSideDish.getText());
                    jTextFieldSideDish.setText("");
                    jListSideDish.setModel(listSideDishes);
                } else {
                    JOptionPane.showMessageDialog(this, "Side Dish exist!");
                }
            }
        }
    }//GEN-LAST:event_jTextFieldSideDishKeyPressed

    private void jTextFieldPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPriceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (Integer.valueOf(jTextFieldPrice.getText().trim()) <= 0) {
                    JOptionPane.showMessageDialog(this, "You inserted zero or negative number");
                    jTextFieldPrice.requestFocus();
                    jTextFieldPrice.selectAll();
                    return;
                }
                listPrices.addElement(Double.valueOf(jTextFieldPrice.getText()));
                jTextFieldPrice.setText("");
                jListPrice.setModel(listPrices);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Not a number");
                jTextFieldPrice.requestFocus();
                jTextFieldPrice.selectAll();
            }
        }
    }//GEN-LAST:event_jTextFieldPriceKeyPressed

    private void jButtonRemoveServingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveServingActionPerformed
        System.out.println("serv pos: " + jListServing.getSelectedIndex() + " " + this.formAction);
        int pos = jListServing.getSelectedIndex();
        if (listServings.size() > 0) {
            if (pos != -1) {
                if (this.formAction.equalsIgnoreCase("edit") && !listServings.isEmpty()) {
                    rServingIds.add(servingIds.get(pos));
                    servingIds.remove(pos);
                    listPrices.removeElementAt(pos);
                }
                listServings.removeElementAt(pos);
            } else {
                JOptionPane.showMessageDialog(this, "Select serving to remove");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No serving");
        }
    }//GEN-LAST:event_jButtonRemoveServingActionPerformed

    private void jButtonRemovePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemovePriceActionPerformed
        System.out.println("p pos: " + jListPrice.getSelectedIndex());
        int pos = jListPrice.getSelectedIndex();
        if (listPrices.size() > 0) {
            if (pos != -1) {
                listPrices.removeElementAt(pos);
            } else {
                JOptionPane.showMessageDialog(this, "Select price to remove");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No price");
        }

    }//GEN-LAST:event_jButtonRemovePriceActionPerformed

    private void jButtonRemoveSauceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveSauceActionPerformed
        System.out.println("s pos: " + jListSauce.getSelectedIndex() + " " + this.formAction);
        int pos = jListSauce.getSelectedIndex();
        if (listSauces.size() > 0) {
            if (pos != -1) {
                listSauces.removeElementAt(pos);
                if (this.formAction.equalsIgnoreCase("edit") && !sauceIds.isEmpty()) {
                    rSauceIds.add(sauceIds.get(pos));
                    sauceIds.remove(pos);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select sauce to remove");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No sauce");
        }
    }//GEN-LAST:event_jButtonRemoveSauceActionPerformed

    private void jButtonRemoveSideDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveSideDishActionPerformed
        System.out.println("sd pos: " + jListSideDish.getSelectedIndex() + " " + this.formAction);
        int pos = jListSideDish.getSelectedIndex();
        if (listSideDishes.size() > 0) {
            if (pos != -1) {
                listSideDishes.removeElementAt(pos);
                if (this.formAction.equalsIgnoreCase("edit") && !sideDishIds.isEmpty()) {
                    rSideDishIds.add(sideDishIds.get(pos));
                    sideDishIds.remove(pos);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select side dish to remove");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No side dish");
        }
    }//GEN-LAST:event_jButtonRemoveSideDishActionPerformed

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "png");
        jFileChooser1.setFileFilter(filter);
        int value = jFileChooser1.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            jTextFieldimage.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
            jTextFieldImageName.setText(jFileChooser1.getSelectedFile().getName());
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private boolean createDir() {
//        File dir = new File(Globals.HTTP + Globals.URI + "/images/" + jTextFieldName.getText().trim().toLowerCase());
        File dir = new File("C:\\xampp\\htdocs\\tgif-api\\images\\"+jTextFieldName.getText().trim().toLowerCase());
        // attempt to create the directory here
        boolean successful = dir.mkdir();
        if (successful) {
            System.out.println("directory was created successfully");
            return true;
        } else {
            // creating the directory failed
            System.out.println("failed trying to create the directory");
            return false;
        }
    }

    private boolean copyPasteImage() {
//        Path path = Paths.get(jTextFieldimage.getText());
        Path path = Paths.get("C:\\Users\\Mon\\Desktop\\test.png");
        System.out.println("PATH: "+path);
        File source = path.toFile();
        System.out.println("FILE: "+source);
        File dest = new File("C:\\xampp\\htdocs\\tgif-api\\images\\"+jTextFieldName.getText().trim().toLowerCase()+"\\"+jTextFieldImageName.getText()+"\\");
        try {
            Files.copy(source.toPath(), dest.toPath());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("E: "+e.getMessage());
            JOptionPane.showMessageDialog(this, "Unable to copy file to destination");
            return false;
        }
    }

    private void getCategory() {
        CategoryDao categoryDao = new CategoryDao();
        for (Category category : categoryDao.getMenusData("")) {
            jComboBoxCategory.addItem(category.getName());
            jComboBoxCategoryId.addItem(category.getId());
        }
    }

    private void clearData() {
        jTextAreaDescription.setText("");
        jTextFieldimage.setText("");
        jTextFieldName.setText("");
        jComboBoxCategory.setSelectedIndex(0);
        listPrices.removeAllElements();
        listSauces.removeAllElements();
        listServings.removeAllElements();
        listSideDishes.removeAllElements();
        jListPrice.setModel(listPrices);
        jListSauce.setModel(listSauces);
        jListServing.setModel(listServings);
        jListSideDish.setModel(listSideDishes);
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonRemovePrice;
    private javax.swing.JButton jButtonRemoveSauce;
    private javax.swing.JButton jButtonRemoveServing;
    private javax.swing.JButton jButtonRemoveSideDish;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JComboBox jComboBoxCategoryId;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListPrice;
    private javax.swing.JList jListSauce;
    private javax.swing.JList jListServing;
    private javax.swing.JList jListSideDish;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonNotPromo;
    private javax.swing.JRadioButton jRadioButtonPromo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldImageName;
    private javax.swing.JTextField jTextFieldItemId;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldSauces;
    private javax.swing.JTextField jTextFieldServing;
    private javax.swing.JTextField jTextFieldSideDish;
    private javax.swing.JTextField jTextFieldimage;
    // End of variables declaration//GEN-END:variables
}
