package com.tgif.util;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class CheckBoxHeader extends JCheckBox
        implements TableCellRenderer, MouseListener {

    protected CheckBoxHeader rendererComponent;
    protected int column;
    protected boolean mousePressed = false;

    public CheckBoxHeader(ItemListener itemListener) {
        this.rendererComponent = this;
        this.rendererComponent.addItemListener(itemListener);
    }

    public CheckBoxHeader(ActionListener actionListener) {
        this.rendererComponent = this;
        this.rendererComponent.addActionListener(actionListener);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (table != null) {
            JTableHeader header = table.getTableHeader();
            if (header != null) {
                this.rendererComponent.setForeground(header.getForeground());
                this.rendererComponent.setBackground(header.getBackground());
                this.rendererComponent.setFont(header.getFont());
                header.addMouseListener(this.rendererComponent);
            }
        }

        setColumn(column);
        this.rendererComponent.setText((value == null) ? "" : value.toString());
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));

        return this.rendererComponent;
    }

    protected void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return this.column;
    }

    public void handleClickEvent(MouseEvent e) {
        if (this.mousePressed) {
            this.mousePressed = false;

            JTableHeader header = (JTableHeader) (JTableHeader) e.getSource();
            JTable tableView = header.getTable();
            TableColumnModel columnModel = tableView.getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX());
            int column = tableView.convertColumnIndexToModel(viewColumn);

            if ((viewColumn == this.column) && (e.getClickCount() == 1) && (column != -1)) {
                doClick();
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        handleClickEvent(e);

        ((JTableHeader) e.getSource()).repaint();
    }

    public void mousePressed(MouseEvent e) {
        this.mousePressed = true;
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}