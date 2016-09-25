/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.apps;

import com.tgif.dao.CashierDao;
import com.tgif.model.Table;
import com.tgif.util.Task;
import com.tgif.util.TaskRunner;
import com.tgif.view.FormTransactionDetail;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Mon
 */
public class GridLayoutTest extends javax.swing.JFrame {

    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//    private String[] header = {"id", "Item Description", "Qty"};
//    private boolean[] cellEditable = {false, false, false};
//    private int[] width = {40, 338, 72};
    private JLabel[] jLabeltableNum;
    private JLabel[] jLabelstatus;
    private JPanel[] jpanel2;
    private TaskRunner taskRunner;
    private CashierDao cashierDao;
    private int x;

    /**
     * Creates new form GridLayout
     */
    public GridLayoutTest() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        taskRunner = new TaskRunner();
        cashierDao = new CashierDao();
        gridLayout(6);
    }

    private void gridLayout(int size) {
        jLabelstatus = new JLabel[size];
        jLabeltableNum = new JLabel[size];
        jpanel2 = new JPanel[6];

        GridLayout gLayout = new GridLayout(2, 3);
        gLayout.setHgap(5);
        gLayout.setVgap(5);
        jPanel1.setLayout(gLayout);
        jPanel1.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < size; i++) {
            jpanel2[i] = new JPanel();
            jLabeltableNum[i] = new JLabel("Table #" + (i + 1), SwingConstants.CENTER);
            jLabelstatus[i] = new JLabel("", SwingConstants.CENTER);

            jpanel2[i].setLayout(new BoxLayout(jpanel2[i], BoxLayout.Y_AXIS));

            jLabeltableNum[i].setOpaque(true);
            jLabeltableNum[i].setBackground(Color.YELLOW);
            jLabeltableNum[i].setFont(new Font("Tahoma", Font.PLAIN, 26));
            jLabeltableNum[i].setMaximumSize(new Dimension(getMaximumSize().width, getMinimumSize().height));

            jLabelstatus[i].setOpaque(true);
            jLabelstatus[i].setBackground(Color.LIGHT_GRAY);
            jLabelstatus[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
            jLabelstatus[i].setMaximumSize(new Dimension(getMaximumSize().width, getMaximumSize().height));

            jpanel2[i].add(jLabeltableNum[i]);
            jpanel2[i].add(jLabelstatus[i]);

            jPanel1.add(jpanel2[i]);
        }
        jPanel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        clickedTable();
        threading();

        this.pack();
    }

    private void threading() {
        taskRunner.setTask(new TaskOrder());
        taskRunner.setDelay(5000);
        taskRunner.run();
    }

    private class TaskOrder implements Task {

        @Override
        public void queTask() {
            int i;
            for (i = 0; i < jpanel2.length; i++) {
                setTableStatus(i, jLabelstatus[i]);
            }
        }
    }

    private void setTableStatus(int index, JLabel labelStatus) {
        List<Table> tablesList = cashierDao.getTableStatus();
        if (tablesList.get(index).getStatus().equalsIgnoreCase("w")) {
            labelStatus.setText("Waiting");
            labelStatus.setBackground(Color.LIGHT_GRAY);
        } else if (tablesList.get(index).getStatus().equalsIgnoreCase("o")) {
            labelStatus.setText("Occupied");
            labelStatus.setBackground(Color.GREEN);
        } else if (tablesList.get(index).getStatus().equalsIgnoreCase("c")) {
            labelStatus.setText("Check Out");
            labelStatus.setBackground(Color.RED);
        } else {
            labelStatus.setBackground(Color.BLACK);
        }
        labelStatus.revalidate();
    }

    private void clickedTable() {
        for (x = 0; x < jLabelstatus.length; x++) {
            jpanel2[x].addMouseListener(new MouseAdapter() {
                private int myIndex;

                {
                    this.myIndex = x;
                }

                @Override
                public void mouseClicked(MouseEvent me) {
                    super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
//                    System.out.println("index: " + (myIndex + 1));
                    if (jLabelstatus[myIndex].getText().equalsIgnoreCase("Waiting") || jLabelstatus[myIndex].getText().equalsIgnoreCase("Occupied")) {
                        JOptionPane.showMessageDialog(null, "Not Check Out");
                    } else {
                        callForm(myIndex + 1);
                    }
                }
            });
        }
    }

    private void callForm(int tableNumber) {
        taskRunner.destroy();
        FormTransactionDetail form = new FormTransactionDetail(this, true, tableNumber);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        taskRunner.run();
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

        jPanel1.setAutoscrolls(true);

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
            java.util.logging.Logger.getLogger(GridLayoutTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GridLayoutTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GridLayoutTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GridLayoutTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setSystemLookAndFeel();
                new GridLayoutTest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
