/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.connection.DBConnection;
import com.tgif.dao.CashierDao;
import com.tgif.dao.ServeDao;
import com.tgif.model.TransactionDetail;
import com.tgif.model.TransactionHeader;
import com.tgif.util.TableManager;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Mon
 */
public class FormTransactionDetail extends javax.swing.JDialog {
//    private String transactionId;
    
    private String[] header = {"Detail", "price", "quantity"};
    private boolean[] cellEditable = {false, false, false};
    private int[] width = {578, 100, 100};
    JasperReport jasperReport;
    JasperPrint jasperPrint;
    private String uName;
    /**
     * Creates new form FormTransactionDetail
     */
    public FormTransactionDetail(java.awt.Frame parent, boolean modal, int tableNumber, String username) {
        super(parent, modal);
        initComponents();
        this.setTitle("Table " + tableNumber + " Order Details");
        jLabelTableNumber.setText(String.valueOf(tableNumber));
        jButtonCheckOut.requestFocus();
        initTable();
        this.uName = username;
    }

    private void initTable() {
        TableManager.setModel(jTableTransactionDetails, jScrollPane1, null, header, false, false, 0, cellEditable, width);
        jTableTransactionDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jTableTransactionDetails.setRowHeight(jTableTransactionDetails.getRowHeight() * 2);
        getTransactionDetails();
    }
    private double cashAmount;
    private double subTotal;
    private double seniorDiscount;
    private String memberId;

    private void getTransactionDetails() {
        double credit = 0.0;
        double cash = 0.0;
        CashierDao cashierDao = new CashierDao();
        TableManager.getTableModel(jTableTransactionDetails).setRowCount(0);
        for (TransactionDetail detail : cashierDao.getTransactionDetails(Integer.valueOf(jLabelTableNumber.getText()))) {
            jTextFieldTransactionId.setText(detail.getTransactionId());
            jLabelHolderName.setText(detail.getCcName());
            jLabelNumber.setText(detail.getCcNumber());
            String sauce = "";
            credit = detail.getCredit();
            cash = detail.getCash();
            memberId = detail.getMemberId();
            for (int i = 0; i < detail.getSauce().size(); i++) {
                sauce += detail.getSauce().get(i).getSauceName() + ", ";
            }
            String sauces = "";
            if (!sauce.isEmpty()) {
                sauces = sauce.substring(0, sauce.length() - 2);
            }
            String sideDish = "";
            if (!detail.getSideDish().getSideDishName().toString().equalsIgnoreCase("null")) {
                sideDish = detail.getSideDish().getSideDishName();
            }

            String details = detail.getFoodItem().getItemName() + ", Serving: ( " + detail.getServing().getServingName() + " ), "
                    + "Sauce/s: ( " + sauces + " ), Side Dish: ( " + sideDish + " )";
            TableManager.getTableModel(jTableTransactionDetails).addRow(new Object[]{
                details,
                detail.getPrice(),
                detail.getQuantity()
            });
        }
        cashAmount = cash;
        subTotal = credit;
        payments(0);
    }
    private double memberDiscount;
    private double serviceCharge;
    private double total;
    private double change;

    private void payments(double sDiscount) {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        jLabelSubTotal.setText(formatter.format(subTotal));
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");
        String d = dateFormatter.format(new Date());
        System.out.println("d: "+d);
        System.out.println("MEMBER ID: "+memberId);
        if (!memberId.trim().isEmpty()) {
            if (d.equalsIgnoreCase("Monday")) {
                memberDiscount = subTotal * .30;
                System.out.println("MONDAY: "+memberDiscount);
            } else {
                memberDiscount = subTotal * .20;
                System.out.println("NOT MONDAY: "+memberDiscount);
            }
        }
        serviceCharge = subTotal * .03;
        jLabelMembershipDiscount.setText(formatter.format(memberDiscount * -1));
        jLabelSeniorDiscount.setText(formatter.format(sDiscount * -1));
        jLabelServiceCharge.setText(formatter.format(serviceCharge));

        total = subTotal + serviceCharge - memberDiscount - sDiscount;
        jLabelTotal.setText(formatter.format(total));
        jLabelCash.setText(formatter.format(cashAmount));
        change = cashAmount - total;
        jLabelChange.setText(formatter.format(change));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransactionDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelChange = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCash = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelSubTotal = new javax.swing.JLabel();
        jButtonCheckOut = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelTableNumber = new javax.swing.JLabel();
        jTextFieldTransactionId = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabelSeniorDiscount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelMembershipDiscount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelServiceCharge = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jLabelHolderName = new javax.swing.JLabel();
        jButtonCancelPayment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1105, 555));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(1105, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(1105, 527));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTransactionDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTransactionDetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 780, 460));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("CC Number:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 140, 30));

        jLabelChange.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelChange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelChange.setText("0.00");
        jPanel1.add(jLabelChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 160, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Change:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 130, 30));

        jLabelCash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelCash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCash.setText("0.00");
        jPanel1.add(jLabelCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Sub Total Bill:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 30));

        jLabelSubTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSubTotal.setText("0.00");
        jPanel1.add(jLabelSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, 30));

        jButtonCheckOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCheckOut.setText("Check Out");
        jButtonCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckOutActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 300, 60));

        jButtonClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, 110, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Table Number:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabelTableNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTableNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTableNumber.setText("0");
        jPanel1.add(jLabelTableNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 160, 30));

        jTextFieldTransactionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTransactionIdActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTransactionId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 140, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Senior Discount");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        jLabelSeniorDiscount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSeniorDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSeniorDiscount.setText("0.00");
        jPanel1.add(jLabelSeniorDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Member Discount:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 130, 30));

        jLabelMembershipDiscount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMembershipDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMembershipDiscount.setText("0.00");
        jPanel1.add(jLabelMembershipDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 160, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Service Charge:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, 30));

        jLabelServiceCharge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelServiceCharge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelServiceCharge.setText("0.00");
        jPanel1.add(jLabelServiceCharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Total Bill:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 30));

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText("0.00");
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Cash Amount:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("CC Holder Name:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 30));

        jLabelNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 200, 30));

        jLabelHolderName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelHolderName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabelHolderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 160, 30));

        jButtonCancelPayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCancelPayment.setText("Cancel Payment");
        jButtonCancelPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelPaymentActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 480, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckOutActionPerformed
        CashierDao cashierDao = new CashierDao();
        int result = JOptionPane.showConfirmDialog(this, "Check Out", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
//            JOptionPane.showMessageDialog(this, "Cancel");
            return;
        }
        String seniorCitizenStatus;
        if (jCheckBox1.isSelected()) {
            seniorCitizenStatus = "senior";
        } else {
            seniorCitizenStatus = "not senior";
        }
        TransactionHeader transactionHeader = new TransactionHeader();
        transactionHeader.setTransactionId(jTextFieldTransactionId.getText());
        transactionHeader.setCashAmount(cashAmount);
        transactionHeader.setTableNumber(Integer.valueOf(jLabelTableNumber.getText()));
        transactionHeader.setSeniorDiscount(seniorDiscount);
        transactionHeader.setMemberDiscount(Double.valueOf(jLabelMembershipDiscount.getText().replace(",", "")));
        transactionHeader.setCcName(jLabelHolderName.getText());
        transactionHeader.setCcNumber(jLabelNumber.getText());
        transactionHeader.setCashierId(this.uName); // username = id

        if (!transactionHeader.getTransactionId().equalsIgnoreCase("")) {
            cashierDao.save(transactionHeader);
            printReport();
            this.dispose();
        } else {
            System.out.println("transaction_header: " + transactionHeader);
            System.out.println("null");
        }
    }//GEN-LAST:event_jButtonCheckOutActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if (jCheckBox1.isSelected()) {
            seniorDiscount = subTotal * .20;
            payments(seniorDiscount);
        } else {
            seniorDiscount = 0;
            payments(seniorDiscount);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jTextFieldTransactionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTransactionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTransactionIdActionPerformed

    private void jButtonCancelPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelPaymentActionPerformed
        new ServeDao().cancelPayment(jTextFieldTransactionId.getText());
        dispose();
    }//GEN-LAST:event_jButtonCancelPaymentActionPerformed
    private void printReport() {

        try {

            HashMap map = new HashMap();

            map.put("transaction_id", jTextFieldTransactionId.getText().trim());
            System.out.println(map);
            String path = "/report/tgif_recipe.jasper";

            print(map, path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(HashMap params, String reportPath) {
        try {
            // System.out.println(params);
            //JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource("/sample_report/sample_print.jasper"));
            jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource(reportPath));

            // JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params , db.connect());
            DBConnection db = new DBConnection();
            jasperPrint = JasperFillManager.fillReport(jasperReport, params, db.connect());
            JasperViewer.viewReport(jasperPrint, true);
        } catch (Exception e) {
//            MessageDialog.show(CustomerService.JFParent, e);
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelPayment;
    private javax.swing.JButton jButtonCheckOut;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCash;
    private javax.swing.JLabel jLabelChange;
    private javax.swing.JLabel jLabelHolderName;
    private javax.swing.JLabel jLabelMembershipDiscount;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelSeniorDiscount;
    private javax.swing.JLabel jLabelServiceCharge;
    private javax.swing.JLabel jLabelSubTotal;
    private javax.swing.JLabel jLabelTableNumber;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransactionDetails;
    private javax.swing.JTextField jTextFieldTransactionId;
    // End of variables declaration//GEN-END:variables
}
