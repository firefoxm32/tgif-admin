/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.apps;

import com.sun.rowset.internal.Row;
import com.tgif.dao.ServeDao;
import com.tgif.dao.UserDao;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author Mon
 */
public class ServingApp extends javax.swing.JFrame {

    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private String[] header = {"ID", "Item Description", "Qty", "Type","status"};
    private boolean[] cellEditable = {false, false, false, false, false};
    private int[] width = {40, 310, 50, 50, 50};
    private String username;
    private int rowExist;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Creates new form ServingApp
     */
    public ServingApp() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        gridLayout();
    }
    protected JPanel[] jpanel2;
    protected JTable[] jTables;
    protected JLabel[] jLabels;
    protected JButton[] jButtons;
    protected JScrollPane[] jScrollPanes;
    private TaskRunner taskRunner = new TaskRunner();

    private int users() {
        int size = new UserDao().userCount();
        return size;
    }
    
    private void gridLayout() {
        int size = users();
        jpanel2 = new JPanel[size];
        jTables = new JTable[size];
        jLabels = new JLabel[size];
        jButtons = new JButton[size];
        jScrollPanes = new JScrollPane[size];
        
        jPanel1.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < 6; i++) {
            jpanel2[i] = new JPanel();
            jTables[i] = new JTable();
            jLabels[i] = new JLabel("Table #" + (i + 1), SwingConstants.CENTER);
            jButtons[i] = new JButton();
            jScrollPanes[i] = new JScrollPane();
            jpanel2[i].setPreferredSize(new Dimension(500, 300));
            jpanel2[i].setLayout(new BoxLayout(jpanel2[i], BoxLayout.Y_AXIS));

            jScrollPanes[i].add(jTables[i]);

            TableManager.setModel(jTables[i], jScrollPanes[i], null, header, false, false, 0, cellEditable, width);

            jTables[i].setGridColor(Color.BLACK);
            jTables[i].setAlignmentX(CENTER_ALIGNMENT);
            jTables[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            jTables[i].setMaximumSize(new Dimension(getMaximumSize().width, getMaximumSize().height));
            jTables[i].setRowHeight(jTables[i].getRowHeight() * 2);
            jLabels[i].setOpaque(true);

            jLabels[i].setAlignmentX(CENTER_ALIGNMENT);
            jLabels[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
            jLabels[i].setBackground(Color.yellow);
            jLabels[i].setMaximumSize(new Dimension(getMaximumSize().width, 20));

            jButtons[i].setText("SERVE");
            jButtons[i].setAlignmentX(CENTER_ALIGNMENT);
            jButtons[i].setFont(new Font("Tahoma", Font.BOLD, 22));
            jButtons[i].setMaximumSize(new Dimension(getMaximumSize().width, 40));

            jpanel2[i].add(jLabels[i]);
            jpanel2[i].add(jScrollPanes[i]);
            jpanel2[i].add(jButtons[i]);
            jpanel2[i].setBackground(Color.GRAY);

            jPanel1.add(jpanel2[i]);
        }

        threading();

        btnClickListener(jTables.length);
        this.pack();
    }

    private void threading() {
        taskRunner.setTask(new ServingApp.TaskOrder());
        taskRunner.setDelay(1000);
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

    private void getOrders(String tableNumber, JTable table) {
        ServeDao serveDao = new ServeDao();
        List<OrderDetail> orderDetail = serveDao.getDetailOrders(tableNumber);
        for (int x = 0; x < orderDetail.size(); x++) {
            String sauces = "";
            for (int i = 0; i < orderDetail.get(x).getSauces().size(); i++) {
                sauces += orderDetail.get(x).getSauces().get(i).getAbbreviation() + ", ";
            }
            String subSauces = "";
            if (!sauces.isEmpty()) {
                subSauces = sauces.substring(0, sauces.length() - 2);
            }
            String description = orderDetail.get(x).getServing().getAbbreviation()
                    + ", Sauce/s: " + subSauces
                    + ", Side Dish: " + orderDetail.get(x).getSideDish().getAbbreviation();
            String readyStatus = (orderDetail.get(x).getReadyStatus().equalsIgnoreCase("R")) ? "R" : "NR";
            if (!isDataExist(orderDetail.get(x).getId(), table)) {
                TableManager.getTableModel(table).addRow(new Object[]{
                    orderDetail.get(x).getId(),
                    orderDetail.get(x).getFoodItem().getItemName() + ", Serving: "
                    + description,
                    orderDetail.get(x).getQty(), 
                    orderDetail.get(x).getOrderType(), 
                    readyStatus
                });
            } else {
                int row = rowExist;
                String status = table.getValueAt(row, 4).toString();
                if(!status.equalsIgnoreCase(readyStatus)) {
                    table.setValueAt(readyStatus, row, 4);
                }
            }
            
        }
    }

    private boolean isDataExist(int id, JTable table) {
        for (int y = 0; y < table.getRowCount(); y++) {
            if (table.getValueAt(y, 0).equals(id)) {
                rowExist = y;
                return true;
            }
        }
        return false;
    }
    int j;

    private void btnClickListener(int size) {
        for (j = 0; j < size; j++) {

            jButtons[j].addMouseListener(new MouseAdapter() {
                int x;

                {
                    x = j;
                }

                @Override
                public void mouseClicked(MouseEvent me) {
                    super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
                    int row = jTables[x].getSelectedRow();
                    if (row == -1) {
                        joption("Select item in table " + (x + 1) + " to serve");
                        return;
                    }
                    String isReady = jTables[x].getValueAt(row, 4).toString();
                    if (isReady.equalsIgnoreCase("NR")) {
                        joption("This food not yet ready");
                        return;
                    }
                    if (confirmation() == 1) {
                        return;
                    }
                    serveOrder(Integer.valueOf(jTables[x].getValueAt(row, 0).toString()));
                    TableManager.getTableModel(jTables[x]).removeRow(row);
                }
            });
        }
    }
    
    private void joption(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    private Integer confirmation() {
        int res=JOptionPane.showConfirmDialog(this, "Serve this order?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.NO_OPTION) {
            return res;
        }
            
        return res;
    }
    private void serveOrder(int item_id) {
        ServeDao serveDao = new ServeDao();
        serveDao.edit(String.valueOf(item_id));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 5, 5));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new UserDao().logout(getUsername());
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new UserDao().logout(getUsername());
    }//GEN-LAST:event_formWindowClosed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
