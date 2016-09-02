/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.apps;

import com.tgif.dao.ServeDao;
import com.tgif.model.OrderDetail;
import com.tgif.util.TableManager;
import com.tgif.util.Task;
import com.tgif.util.TaskRunner;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mon
 */
public class Kitchen extends javax.swing.JFrame {
    
    private String[] header = {"Item Description", "Qty"};
    private boolean[] cellEditable = {false, false};
    private int[] width = {378, 40};
    private List<Integer> id;
    /**
     * Creates new form Kitchen
     */
    public Kitchen() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        initTables();
        threading();
    }
    
    private void threading() {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.setTask(new Kitchen.TaskMenu());
        taskRunner.setDelay(3000);
        taskRunner.run();
    }
    
    private class TaskMenu implements Task {

        @Override
        public void queTask() {
            getOrders1("1");
            getOrders2("2");
            getOrders3("3");
            getOrders4("4");
            getOrders5("5");
            getOrders6("6");
        }
    }
    
    private void initTables() {
        TableManager.setModel(jXTable1, jScrollPane1, null, header, false, false, 0, cellEditable, width);
        TableManager.setModel(jXTable2, jScrollPane2, null, header, false, false, 0, cellEditable, width);
        TableManager.setModel(jXTable3, jScrollPane3, null, header, false, false, 0, cellEditable, width);
        TableManager.setModel(jXTable4, jScrollPane4, null, header, false, false, 0, cellEditable, width);
        TableManager.setModel(jXTable5, jScrollPane5, null, header, false, false, 0, cellEditable, width);
        TableManager.setModel(jXTable6, jScrollPane6, null, header, false, false, 0, cellEditable, width);
        jXTable1.setRowHeight(jXTable1.getRowHeight() * 2);
        jXTable1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jXTable2.setRowHeight(jXTable2.getRowHeight() * 2);
        jXTable2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jXTable3.setRowHeight(jXTable3.getRowHeight() * 2);
        jXTable3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jXTable4.setRowHeight(jXTable4.getRowHeight() * 2);
        jXTable4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jXTable5.setRowHeight(jXTable5.getRowHeight() * 2);
        jXTable5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        jXTable6.setRowHeight(jXTable6.getRowHeight() * 2);
        jXTable6.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }   
    
    private void getOrders1(String tableNumber) {
        TableManager.getTableModel(jXTable1).setRowCount(0);
        ServeDao serveDao = new ServeDao();
//        List<OrderDetail> orderDetail = new ArrayList<>();
        id = new ArrayList<>();
        for(OrderDetail orderDetail: serveDao.getDetailOrders(tableNumber)) {
            id.add(orderDetail.getId());
            String sauces="";
            for (int i = 0; i < orderDetail.getSauces().size(); i++) {
                sauces += orderDetail.getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = sauces.substring(0, sauces.length() - 2);
            String description = orderDetail.getServing().getAbbreviation() + 
                    ", Sauce/s: " + subSauces +
                    ", Side Dish: " + orderDetail.getSideDish().getAbbreviation();
            TableManager.getTableModel(jXTable1).addRow(new Object[]{
                orderDetail.getFoodItem().getItemName() + ", Serving: " + 
                description,
                orderDetail.getQty()
            });
        }
    }
    private void getOrders2(String tableNumber) {
        TableManager.getTableModel(jXTable2).setRowCount(0);
        ServeDao serveDao = new ServeDao();
//        List<OrderDetail> orderDetail = new ArrayList<>();
        id = new ArrayList<>();
        for(OrderDetail orderDetail: serveDao.getDetailOrders(tableNumber)) {
            id.add(orderDetail.getId());
            String sauces="";
            for (int i = 0; i < orderDetail.getSauces().size(); i++) {
                sauces += orderDetail.getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = sauces.substring(0, sauces.length() - 2);
            String description = orderDetail.getServing().getAbbreviation() + 
                    ", Sauce/s: " + subSauces +
                    ", Side Dish: " + orderDetail.getSideDish().getAbbreviation();
            TableManager.getTableModel(jXTable2).addRow(new Object[]{
                orderDetail.getFoodItem().getItemName() + ", Serving: " + 
                description,
                orderDetail.getQty()
            });
        }
    }
    private void getOrders3(String tableNumber) {
        TableManager.getTableModel(jXTable3).setRowCount(0);
        ServeDao serveDao = new ServeDao();
//        List<OrderDetail> orderDetail = new ArrayList<>();
        id = new ArrayList<>();
        for(OrderDetail orderDetail: serveDao.getDetailOrders(tableNumber)) {
            id.add(orderDetail.getId());
            String sauces="";
            for (int i = 0; i < orderDetail.getSauces().size(); i++) {
                sauces += orderDetail.getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = sauces.substring(0, sauces.length() - 2);
            String description = orderDetail.getServing().getAbbreviation() + 
                    ", Sauce/s: " + subSauces +
                    ", Side Dish: " + orderDetail.getSideDish().getAbbreviation();
            TableManager.getTableModel(jXTable3).addRow(new Object[]{
                orderDetail.getFoodItem().getItemName() + ", Serving: " + 
                description,
                orderDetail.getQty()
            });
        }
    }
    
    private void getOrders4(String tableNumber) {
        TableManager.getTableModel(jXTable4).setRowCount(0);
        ServeDao serveDao = new ServeDao();
//        List<OrderDetail> orderDetail = new ArrayList<>();
        id = new ArrayList<>();
        for(OrderDetail orderDetail: serveDao.getDetailOrders(tableNumber)) {
            id.add(orderDetail.getId());
            String sauces="";
            for (int i = 0; i < orderDetail.getSauces().size(); i++) {
                sauces += orderDetail.getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = sauces.substring(0, sauces.length() - 2);
            String description = orderDetail.getServing().getAbbreviation() + 
                    ", Sauce/s: " + subSauces +
                    ", Side Dish: " + orderDetail.getSideDish().getAbbreviation();
            TableManager.getTableModel(jXTable4).addRow(new Object[]{
                orderDetail.getFoodItem().getItemName() + ", Serving: " + 
                description,
                orderDetail.getQty()
            });
        }
    }
    private void getOrders5(String tableNumber) {
        TableManager.getTableModel(jXTable5).setRowCount(0);
        ServeDao serveDao = new ServeDao();
//        List<OrderDetail> orderDetail = new ArrayList<>();
        id = new ArrayList<>();
        for(OrderDetail orderDetail: serveDao.getDetailOrders(tableNumber)) {
            id.add(orderDetail.getId());
            String sauces="";
            for (int i = 0; i < orderDetail.getSauces().size(); i++) {
                sauces += orderDetail.getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = sauces.substring(0, sauces.length() - 2);
            String description = orderDetail.getServing().getAbbreviation() + 
                    ", Sauce/s: " + subSauces +
                    ", Side Dish: " + orderDetail.getSideDish().getAbbreviation();
            TableManager.getTableModel(jXTable5).addRow(new Object[]{
                orderDetail.getFoodItem().getItemName() + ", Serving: " + 
                description,
                orderDetail.getQty()
            });
        }
    }
    private void getOrders6(String tableNumber) {
        TableManager.getTableModel(jXTable6).setRowCount(0);
        ServeDao serveDao = new ServeDao();
//        List<OrderDetail> orderDetail = new ArrayList<>();
        id = new ArrayList<>();
        for(OrderDetail orderDetail: serveDao.getDetailOrders(tableNumber)) {
            id.add(orderDetail.getId());
            String sauces="";
            for (int i = 0; i < orderDetail.getSauces().size(); i++) {
                sauces += orderDetail.getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = sauces.substring(0, sauces.length() - 2);
            String description = orderDetail.getServing().getAbbreviation() + 
                    ", Sauce/s: " + subSauces +
                    ", Side Dish: " + orderDetail.getSideDish().getAbbreviation();
            TableManager.getTableModel(jXTable6).addRow(new Object[]{
                orderDetail.getFoodItem().getItemName() + ", Serving: " + 
                description,
                orderDetail.getQty()
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

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jXTable4 = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jXTable5 = new org.jdesktop.swingx.JXTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTable3 = new org.jdesktop.swingx.JXTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jXTable6 = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("#4");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jXTable4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane4.setViewportView(jXTable4);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 340));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 395, -1, 370));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("#1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jXTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jXTable1.setShowHorizontalLines(false);
        jXTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jXTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 340));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 370));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("#2");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jXTable2.setAutoscrolls(false);
        jXTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jXTable2.setRowHeight(20);
        jScrollPane2.setViewportView(jXTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 340));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 0, 440, 370));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("#5");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jXTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane5.setViewportView(jXTable5);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 340));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 395, -1, 370));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("#3");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jXTable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane3.setViewportView(jXTable3);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 340));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 0, 440, 370));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("#6");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 30));

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jXTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jXTable6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane6.setViewportView(jXTable6);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 440, 340));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 395, -1, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1371, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kitchen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTable jXTable2;
    private org.jdesktop.swingx.JXTable jXTable3;
    private org.jdesktop.swingx.JXTable jXTable4;
    private org.jdesktop.swingx.JXTable jXTable5;
    private org.jdesktop.swingx.JXTable jXTable6;
    // End of variables declaration//GEN-END:variables
}
