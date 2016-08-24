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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mon
 */
public class Cashier extends javax.swing.JFrame {

    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel[] jLabeltableNum;
    private JPanel[] jPaneltables;
    private JLabel[] jLabelstatus;
    private JLabel[] jLabelWaiting;
    private int i;
    private int x;
    private TaskRunner taskRunner = new TaskRunner();

    /**
     * Creates new form Kitchen
     */
    public Cashier() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        gridLayout();
//        threading();
    }

    private void threading() {
        taskRunner.setTask(new Cashier.CashierTask());
        taskRunner.setDelay(2000);
        taskRunner.run();
    }

    private List<Table> a() {
        CashierDao cashierDao = new CashierDao();
        List<Table> tablesList = cashierDao.getTableStatus();

        return tablesList;
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
            .addGap(0, 407, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
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

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gridLayout() {
        int tableCount = a().size();
        jPaneltables = new JPanel[tableCount];
        GridLayout gLayout = new GridLayout();
        gLayout.setHgap(5);
        gLayout.setVgap(5);

        if (tableCount == 1) {
            gLayout.setRows(1);
            gLayout.setColumns(1);
        } else if (tableCount
                < 11) {
            if ((tableCount % 2) == 0) {
                gLayout.setRows(2);
                gLayout.setColumns(3);
            } else if ((tableCount % 1) == 0) {
                gLayout.setRows(3);
                gLayout.setColumns(3);
            }
        } else if (tableCount
                > 10) {
            if ((tableCount % 2) == 0) {
                gLayout.setRows(4);
                gLayout.setColumns(4);
            } else if ((tableCount % 1) == 0) {
                gLayout.setRows(5);
                gLayout.setColumns(5);
            }
        } else {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "Error");
            return;
        }
        jPanel1.setLayout(gLayout);
        for (i = 0; i < tableCount; i++) {
            jPaneltables[i] = new JPanel();
            jPaneltables[i].setLayout(new BoxLayout(jPaneltables[i], BoxLayout.Y_AXIS));
            jPanel1.add(jPaneltables[i]);
        }
        jPanel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        threading();

        for (x = 0; x < tableCount; x++) {

            jPaneltables[x].addMouseListener(new MouseAdapter() {
                private int myIndex;
                private int tableNumber;
                // inner class

                {
                    this.myIndex = x;
                }

                @Override
                public void mouseClicked(MouseEvent me) {
                    super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
//                    JOptionPane.showMessageDialog(null, tables[myIndex].getName());
                    if (jLabelstatus[myIndex].getText().equalsIgnoreCase("Waiting") || jLabelstatus[myIndex].getText().equalsIgnoreCase("Occupied")) {
                        JOptionPane.showMessageDialog(null, "Not Check Out");
                    } else {
                        callForm(a().get(myIndex).getTableNumber());
                    }
                }
            });
        }

        pack();
    }

    private class CashierTask implements Task {

        @Override
        public void queTask() {
            setTableBackground(a());
        }
    }
    private List<String> listStatus;
    private List<Integer> listTableNumber;

    private void setTableBackground(List<Table> status) {
        jLabeltableNum = new JLabel[status.size()];
        jLabelstatus = new JLabel[status.size()];
        jLabelWaiting = new JLabel[status.size()];
        listStatus = new ArrayList<>();
        listTableNumber = new ArrayList<>();
        for (x = 0; x < status.size(); x++) {

            jLabelstatus[x] = new JLabel();
            jLabelWaiting[x] = new JLabel();
            listStatus.add(status.get(x).getStatus());
            listTableNumber.add(status.get(x).getTableNumber());

            SwingUtilities.invokeLater(new Runnable() {
                private int _x;

                {
                    this._x = x;
                }

                @Override
                public void run() {
                    if (listStatus.get(_x).equalsIgnoreCase("W")) {
                        jLabelstatus[_x].setText("Waiting");
                        System.out.println("x: " + _x);
                    }
//                    jPaneltables[_x].remove(jLabelstatus[_x]);
                    jPaneltables[_x].removeAll();
                    if (listStatus.get(_x).equalsIgnoreCase("O")) {
                        jPaneltables[_x].setBackground(Color.green);
                        jlabelSettext(listStatus.get(_x), _x);
                    } else if (listStatus.get(_x).equalsIgnoreCase("C")) {
                        jPaneltables[_x].setBackground(Color.red);
                        jlabelSettext(listStatus.get(_x), _x);
                    } else if (listStatus.get(_x).equalsIgnoreCase("W")) {
                        jPaneltables[_x].setBackground(Color.gray);
                        jlabelSettext(listStatus.get(_x), _x);
                    }
                    
                    jLabeltableNum[_x] = new JLabel();
                    jLabeltableNum[_x].setFont(new Font("Tahoma", Font.PLAIN, 24));
                    jLabeltableNum[_x].setText("#" + listTableNumber.get(_x));
                    jLabeltableNum[_x].setAlignmentX(Component.CENTER_ALIGNMENT);
                    jLabeltableNum[_x].revalidate();
                    
                    jLabelstatus[_x].setFont(new Font("Tahoma", Font.PLAIN, 24));
                    jLabelstatus[_x].setAlignmentX(Component.CENTER_ALIGNMENT);

                    jPaneltables[_x].add(jLabeltableNum[_x]);
                    jPaneltables[_x].add(Box.createRigidArea(new Dimension(0, 30)));
                    jPaneltables[_x].add(jLabelstatus[_x]);
                }
            });
        }
    }
    private int y;
    private String strStatus;

    private void jlabelSettext(String status, int yy) {
        this.y = yy;
        if (status.equalsIgnoreCase("O")) {
            strStatus = "Occupied";
        } else if (status.equalsIgnoreCase("C")) {
            strStatus = "Check Out";
        } else if (status.equalsIgnoreCase("W")) {
            System.out.println(status);
            strStatus = "Waiting";
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                jLabelstatus[y].revalidate();
                
                jLabelstatus[y].setText(strStatus);
                jLabelstatus[y].revalidate();
            }
        });
    }

    private void callForm(int tableNumber) {
        taskRunner.destroy();
        FormTransactionDetail form = new FormTransactionDetail(this, true, tableNumber);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        taskRunner.run();
    }

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
            java.util.logging.Logger.getLogger(Cashier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cashier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cashier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cashier.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cashier().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
