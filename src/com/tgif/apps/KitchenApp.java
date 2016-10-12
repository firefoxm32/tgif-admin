/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.apps;

import com.tgif.dao.ServeDao;
import com.tgif.dao.UserDao;
import com.tgif.model.OrderDetail;
import com.tgif.model.User;
import com.tgif.util.TableManager;
import com.tgif.util.Task;
import com.tgif.util.TaskRunner;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author Mon
 */
public class KitchenApp extends javax.swing.JFrame {

    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private String[] header = {"ID", "Item Description", "Qty", "Type","Status"};
    private boolean[] cellEditable = {false, false, false, false};
    private int[] width = {40, 308, 50, 50,50};
    private String username;
    private int existRow;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
        for (int i = 0; i < size; i++) {
            jpanel2[i] = new JPanel();
            jTables[i] = new JTable();
            jButtons[i] = new JButton();
            jLabels[i] = new JLabel("Table #" + (i + 1), SwingConstants.CENTER);
            jScrollPanes[i] = new JScrollPane();
            jpanel2[i].setPreferredSize(new Dimension(500, 300));
            jpanel2[i].setLayout(new BoxLayout(jpanel2[i], BoxLayout.Y_AXIS));

            jScrollPanes[i].add(jTables[i]);
            jLabels[i].setOpaque(true);
            jLabels[i].setAlignmentX(CENTER_ALIGNMENT);
            jLabels[i].setFont(new Font("Tahoma", Font.BOLD, 26));
            jLabels[i].setBackground(Color.YELLOW);
            jLabels[i].setMaximumSize(new Dimension(getMaximumSize().width, getMinimumSize().height));

            jButtons[i].setText("Ready");
            jButtons[i].setAlignmentX(CENTER_ALIGNMENT);
            jButtons[i].setFont(new Font("Tahoma", Font.BOLD, 22));
            jButtons[i].setMaximumSize(new Dimension(getMaximumSize().width, 40));

            TableManager.setModel(jTables[i], jScrollPanes[i], null, header, false, false, 0, cellEditable, width);

            jTables[i].setGridColor(Color.BLACK);
            jTables[i].setAlignmentX(CENTER_ALIGNMENT);
            jTables[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            jTables[i].setMaximumSize(new Dimension(getMaximumSize().width, getMaximumSize().height));
            jTables[i].setRowHeight(jTables[i].getRowHeight() * 2);

//            jpanel2[i].setPreferredSize(new Dimension(getMinimumSize().height,getMinimumSize().width + 300));
            jpanel2[i].add(jLabels[i]);
            jpanel2[i].add(jScrollPanes[i]);
            jpanel2[i].add(jButtons[i]);
            jpanel2[i].setBackground(Color.GRAY);
            
            jPanel1.add(jpanel2[i]);
        }
        
//        JScrollPane jScrollPane = new JScrollPane(jPanel1, 
//                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
//                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        this.add(jScrollPane);
        threading();
        btnClickListener(jTables.length);
        jtableClickListner(jTables.length);
        this.pack();
    }

    private void threading() {
        taskRunner.setTask(new KitchenApp.TaskOrder());
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
    protected JTextArea jTextArea;

    private void getOrders(String tableNumber, JTable table) {
//        TableManager.getTableModel(table).setNumRows(0);
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
            String serveStatus = (orderDetail.get(x).getReadyStatus().equalsIgnoreCase("R")) ? "R" : "NR";
            String orderType = (orderDetail.get(x).getOrderType().equalsIgnoreCase("DI")) ? "D.I" : "T.O";
            if (!isDataExist(orderDetail.get(x), table)) {
                TableManager.getTableModel(table).addRow(new Object[]{
                    orderDetail.get(x).getId(),
                    description,
                    orderDetail.get(x).getQty(),
                    orderType,
                    serveStatus
                });
            }
        }
        updateTable(orderDetail, table);
    }
    int j;
    private void joption(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
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
                        joption("Select item in table " + (x + 1) + " to ready");
                        return;
                    }
                    int id = Integer.valueOf(jTables[x].getValueAt(row, 0).toString());
                    if (jButtons[x].getText().equalsIgnoreCase("Ready")) {
                        new ServeDao().updateServeStatus("R", id);
                    } else {
                        new ServeDao().updateServeStatus("N", id);
                    }
//                    serveOrder(Integer.valueOf(jTables[x].getValueAt(row, 0).toString()));
                    TableManager.getTableModel(jTables[x]).removeRow(row);
                }
            });
        }
    }
        int s;
    private void jtableClickListner(int size) {
        for(s = 0; s < size; s++) {
            jTables[s].addMouseListener(new MouseAdapter() {
                int x;
                {x=s;}
                @Override
                public void mouseClicked(MouseEvent me) {
                    super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
                    int row = jTables[x].getSelectedRow();
                    String status = jTables[x].getValueAt(row, 4).toString();
                    if (status.equalsIgnoreCase("R")) {
                        jButtons[x].setText("Not Ready");
                    } else {
                        jButtons[x].setText("Ready");
                    }
                    jButtons[x].repaint();
                }
            });
        }
    }
    
    private boolean isDataExist(OrderDetail od, JTable table) {
        for (int y = 0; y < table.getRowCount(); y++) {
            if (table.getValueAt(y, 0).equals(od.getId())) {
                return true;
            }
        }
        return false;
    }

    private void updateTable(List<OrderDetail> ods, JTable jTable) {
        for (int y = 0; y < jTable.getRowCount(); y++) {
            int id = Integer.valueOf(jTable.getValueAt(y, 0).toString());
            boolean isOnList = isOnList(id, ods);
            if(!isOnList) {
                TableManager.getTableModel(jTable).removeRow(y);
            }
        }
//        if (ods.isEmpty()) {
//            TableManager.getTableModel(jTable).setNumRows(0);
//        }
    }
    
    private boolean isOnList(int id, List<OrderDetail> ods) {
        for (int y = 0; y < ods.size(); y++) {
            if (ods.get(y).getId() == id) {
                existRow = y;
                return true;
            }
        }
        return false;
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
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
