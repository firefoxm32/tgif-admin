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
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Mon
 */
public class KitchenApp extends javax.swing.JFrame {
    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private String[] header = {"ID", "Item Description", "Qty"};
    private boolean[] cellEditable = {false, false, false};
    private int[] width = {35, 353, 62};
    /**
     * Creates new form KitchenApp
     */
    public KitchenApp() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        gridLayout();
    }
    
    protected JPanel[] jpanel2;
    protected JTable[] jTables;
    protected JLabel[] jLabels;
//    protected JButton[] jButtons;
    protected JScrollPane[] jScrollPanes;
    private TaskRunner taskRunner = new TaskRunner();

    private void gridLayout() {
        jpanel2 = new JPanel[6];
        jTables = new JTable[6];
        jLabels = new JLabel[6];
//        jButtons = new JButton[6];
        jScrollPanes = new JScrollPane[6];

        GridLayout gLayout = new GridLayout(2, 3);
        gLayout.setHgap(5);
        gLayout.setVgap(5);
        jPanel1.setLayout(gLayout);
        jPanel1.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < 6; i++) {
            jpanel2[i] = new JPanel();
            jTables[i] = new JTable();
            jLabels[i] = new JLabel("Table #" + (i + 1), SwingConstants.CENTER);
            jScrollPanes[i] = new JScrollPane();
            jpanel2[i].setLayout(new BoxLayout(jpanel2[i], BoxLayout.Y_AXIS));

            jScrollPanes[i].add(jTables[i]);
            jLabels[i].setOpaque(true);
            jLabels[i].setAlignmentX(CENTER_ALIGNMENT);
            jLabels[i].setFont(new Font("Tahoma", Font.BOLD, 26));
            jLabels[i].setBackground(Color.YELLOW);
            jLabels[i].setMaximumSize(new Dimension(getMaximumSize().width, getMinimumSize().height));
            
            TableManager.setModel(jTables[i], jScrollPanes[i], null, header, false, false, 0, cellEditable, width);
            
            jTables[i].setGridColor(Color.BLACK);
            jTables[i].setAlignmentX(CENTER_ALIGNMENT);
            jTables[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
            jTables[i].setMaximumSize(new Dimension(getMaximumSize().width, getMaximumSize().height));
            jTables[i].setRowHeight(jTables[i].getRowHeight() * 2);

            jpanel2[i].add(jLabels[i]);
            jpanel2[i].add(jScrollPanes[i]);
            jpanel2[i].setBackground(Color.GRAY);

            jPanel1.add(jpanel2[i]);
        }

        threading();

        this.pack();
    }

    private void threading() {
        taskRunner.setTask(new KitchenApp.TaskOrder());
        taskRunner.setDelay(2000);
        taskRunner.run();
    }

    private class TaskOrder implements Task {
        @Override
        public void queTask() {
            for (int i = 0; i < jTables.length; i++) {
                int x = i + 1;
                getOrders(String.valueOf(x), jTables[i]);
            }
        }
    }
    protected JTextArea jTextArea;
    private void getOrders(String tableNumber, JTable table) {
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        ServeDao serveDao = new ServeDao();
        List<OrderDetail> orderDetail = serveDao.getDetailOrders(tableNumber);
        for (int x = 0; x < orderDetail.size(); x++) {
            String sauces = "";
            for (int i = 0; i < orderDetail.get(x).getSauces().size(); i++) {
                sauces += orderDetail.get(x).getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = "";
            if (!subSauces.isEmpty()) {
                subSauces = sauces.substring(0, sauces.length() - 2);
            }
            String description = orderDetail.get(x).getFoodItem().getItemName() + ", Serving: "
                    + orderDetail.get(x).getServing().getAbbreviation()
                    + ", Sauce/s: " + subSauces
                    + ", Side Dish: " + orderDetail.get(x).getSideDish().getAbbreviation();
//            jTextArea.setText(description);
            if (!isDataExist(orderDetail.get(x).getId(), table)) {
                TableManager.getTableModel(table).addRow(new Object[]{
                    orderDetail.get(x).getId(),
                    description,
                    orderDetail.get(x).getQty()
                });
            }
        }
    }

    private boolean isDataExist(int id, JTable table) {
        for (int y = 0; y < table.getRowCount(); y++) {
            if (table.getValueAt(y, 0).equals(id)) {
                return true;
            }
        }
        return false;
    }
    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(KitchenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KitchenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KitchenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitchenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setSystemLookAndFeel();
                new KitchenApp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
