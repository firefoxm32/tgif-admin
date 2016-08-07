/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author adrian
 */
public class TableCellAutoAlignment {

    private static int ALIGNMENT;

    public TableCellAutoAlignment() {
    }

    public static void set(JTable table) {
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
                Object value = table.getValueAt(rowIndex, columnIndex);
                if (value.getClass() == String.class) {
                    table.setValueAt(" " + String.valueOf(value).trim(), rowIndex, columnIndex);
                    ALIGNMENT = SwingConstants.LEFT;
                }
                if (value.getClass() == Integer.class || value.getClass() == Double.class) {
                    table.setValueAt(value + " ", rowIndex, columnIndex);
                    ALIGNMENT = SwingConstants.RIGHT;
                }
                table.getColumnModel().getColumn(columnIndex).setCellRenderer(new MyTableRenderAlignment(ALIGNMENT));
            }
        }
    }
}
