/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author adrian
 */
public class HeaderRenderer extends JCheckBox implements TableCellRenderer {

    private final JLabel label = new JLabel("");
    private int targetColumnIndex;

    public HeaderRenderer(JTableHeader header, int index) {
        super((String) null);
        this.targetColumnIndex = index;
        setOpaque(false);
        setFont(header.getFont());
        header.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = (JTableHeader) e.getSource();
                JTable table = header.getTable();
                TableColumnModel columnModel = table.getColumnModel();
                int vci = columnModel.getColumnIndexAtX(e.getX());
                int mci = table.convertColumnIndexToModel(vci);
                if (mci == targetColumnIndex) {
                    TableColumn column = columnModel.getColumn(vci);
                    Object v = column.getHeaderValue();
                    boolean b = Status.DESELECTED.equals(v) ? true : false;
                    TableModel m = table.getModel();
                    for (int i = 0; i < m.getRowCount(); i++) {
                        m.setValueAt(b, i, mci);
                    }
                    column.setHeaderValue(b ? Status.SELECTED : Status.DESELECTED);
                }
            }
        });
    }

    public Component getTableCellRendererComponent(JTable tbl, Object val, boolean isS, boolean hasF, int row, int col) {
        TableCellRenderer r = tbl.getTableHeader().getDefaultRenderer();
        JLabel l = (JLabel) r.getTableCellRendererComponent(tbl, val, isS, hasF, row, col);
        if (targetColumnIndex == tbl.convertColumnIndexToModel(col)) {
            if (val instanceof Status) {
                switch ((Status) val) {
                    case SELECTED:
                        setSelected(true);
                        setEnabled(true);
                        break;
                    case DESELECTED:
                        setSelected(false);
                        setEnabled(true);
                        break;
                    case INDETERMINATE:
                        setSelected(true);
                        setEnabled(false);
                        break;
                }
            } else {
                setSelected(true);
                setEnabled(false);
            }
            label.setIcon(new ComponentIcon(this));
            l.setIcon(new ComponentIcon(label));
            l.setText(null); //XXX: Nimbus???
        }
        return l;
    }

    public void updateUI() {
        setText(null); //XXX: Nimbus??? Header height bug???
        super.updateUI();
    }
}

class HeaderCheckBoxHandler implements TableModelListener {

    private final JTable table;
    private final int targetColumnIndex;

    public HeaderCheckBoxHandler(JTable table, int index) {
        this.table = table;
        this.targetColumnIndex = index;
    }

    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == targetColumnIndex) {
            int vci = table.convertColumnIndexToView(targetColumnIndex);
            TableColumn column = table.getColumnModel().getColumn(vci);
            if (!Status.INDETERMINATE.equals(column.getHeaderValue())) {
                column.setHeaderValue(Status.INDETERMINATE);
            } else {
                boolean selected = true, deselected = true;
                TableModel m = table.getModel();
                for (int i = 0; i < m.getRowCount(); i++) {
                    Boolean b = (Boolean) m.getValueAt(i, targetColumnIndex);
                    selected &= b;
                    deselected &= !b;
                    if (selected == deselected) {
                        return;
                    }
                }
                if (selected) {
                    column.setHeaderValue(Status.SELECTED);
                } else if (deselected) {
                    column.setHeaderValue(Status.DESELECTED);
                } else {
                    return;
                }
            }
            JTableHeader h = table.getTableHeader();
            h.repaint(h.getHeaderRect(vci));
        }
    }
}

class ComponentIcon implements Icon {

    private final JComponent cmp;

    public ComponentIcon(JComponent cmp) {
        this.cmp = cmp;
    }

    public int getIconWidth() {
        return cmp.getPreferredSize().width;
    }

    public int getIconHeight() {
        return cmp.getPreferredSize().height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        SwingUtilities.paintComponent(g, cmp, (Container) c, x, y, getIconWidth(), getIconHeight());
    }
}

enum Status {

    SELECTED, DESELECTED, INDETERMINATE
}