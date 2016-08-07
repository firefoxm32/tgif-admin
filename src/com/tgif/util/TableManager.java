package com.tgif.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author adp
 */
public class TableManager {

    private static boolean[] scrollableCellEditableX;
    private static boolean[] fixedCellEditableX;
    private static Font fontTyle;    
            
    public TableManager() {
    }
    public static void setFont(Font fontStyle){
        TableManager.fontTyle = fontStyle;
    }
    public static void setModel(JTable table, JScrollPane scrollpane, Object[][] data, String[] headers, boolean isResizable, boolean isNumbered, int selectionMode, boolean[] isEditable, int[] width) {
        final boolean[] setEditable = isEditable;
        if(TableManager.fontTyle == null){
            TableManager.fontTyle = new Font("Tahoma", Font.PLAIN, 12);
        }
        table.setModel(new DefaultTableModel(data, headers) {
            public Class getColumnClass(int c) {
                try {
                    if (getValueAt(0, c).getClass() == Boolean.class) {
                        return Boolean.class;
                    }
                    return getValueAt(0, c).getClass();
                } catch (Exception ex) {
                    return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                return setEditable[column];
            }
        });

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        TableColumnModel tblColumnModel = table.getColumnModel();
        if (width.length > 0) {
            for (int i = 0; i < width.length; i++) {
                tblColumnModel.getColumn(i).setMinWidth(0);
                tblColumnModel.getColumn(i).setPreferredWidth(width[i]);
                tblColumnModel.getColumn(i).setWidth(width[i]);
            }
        }

        for (int vColIndex = 0; vColIndex < table.getColumnCount(); vColIndex++) {
            if (table.getColumnClass(vColIndex) != Boolean.class) {
                TableColumn col = table.getColumnModel().getColumn(vColIndex);
                col.setCellRenderer(new MyCellRenderer());
            }
        }

        JTableHeader tblheader = new JTableHeader();
        tblheader.setColumnModel(tblColumnModel);
        tblheader.setReorderingAllowed(false);
        tblheader.setResizingAllowed(isResizable);
        table.setSelectionMode(selectionMode);
        table.setTableHeader(tblheader);
        scrollpane.setViewportView(table);
        tblheader.setFont(TableManager.fontTyle);
        if (isNumbered) {
            LineNumberTableRowHeader tableLineNumber = new LineNumberTableRowHeader(scrollpane, table);
            tableLineNumber.setBackground(Color.LIGHT_GRAY);
            scrollpane.setRowHeaderView(tableLineNumber);
        }

        setTableHeaderAlignment(table, SwingConstants.CENTER);
        table.setFont(TableManager.fontTyle);
        table.setRowHeight(22);
    }

    public static void scrollToLast(JTable table, int lastRow) {
        Rectangle rec = table.getCellRect(lastRow, 0, true);
        table.scrollRectToVisible(rec);
    }

    public static DefaultTableModel getTableModel(JTable table) {
        return (DefaultTableModel) table.getModel();
    }

    public static void setTableHeaderAlignment(JTable table, int alignment) {
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(alignment);
    }

    public static void setFixedColumnHeader(JTable fixedTable, String[] fixedHeader, Object[][] fixedData, boolean[] fixedCellEditable, int[] fixedWidth,
            JScrollPane jscrollpane,
            JTable scrollableTable, String[] scrollableHeader, Object[][] scrollableData, boolean[] scrollableCellEditable, int[] scrollableWidth) {
        if(TableManager.fontTyle == null){
            TableManager.fontTyle = new Font("Tahoma", Font.PLAIN, 12);
        }
        fixedCellEditableX = fixedCellEditable;
        scrollableCellEditableX = scrollableCellEditable;

        SortableTableModel dm = new SortableTableModel() {
            public Class getColumnClass(int c) {
                try {
                    if (getValueAt(0, c).getClass() == Boolean.class) {
                        return Boolean.class;
                    }
                    return getValueAt(0, c).getClass();
                } catch (Exception ex) {
                    return String.class;
                }
            }

            public boolean isCellEditable(int row, int col) {
                return scrollableCellEditableX[col];
            }

            public void setValueAt(Object obj, int row, int col) {
                switch (col) {
                    default:
                        super.setValueAt(obj, row, col);
                }
            }
        };
        dm.setDataVector(scrollableData, scrollableHeader);
        scrollableTable.setColumnModel(new GroupableTableColumnModel());
        scrollableTable.setTableHeader(new GroupableTableHeader((GroupableTableColumnModel) scrollableTable.getColumnModel()));
        scrollableTable.setModel(dm);
        scrollableTable.setSelectionMode(0);
        scrollableTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollableTable.getTableHeader().setResizingAllowed(true);
        scrollableTable.getTableHeader().setReorderingAllowed(false);
        scrollableTable.setFont(TableManager.fontTyle);
        scrollableTable.setRowHeight(22);
        GroupableTableColumnModel cm = (GroupableTableColumnModel) scrollableTable.getColumnModel();
        if (scrollableWidth.length > 0) {
            for (int i = 0; i < scrollableWidth.length; i++) {
                cm.getColumn(i).setMinWidth(scrollableWidth[i]);
                cm.getColumn(i).setMaxWidth(scrollableWidth[i]);
                cm.getColumn(i).setPreferredWidth(scrollableWidth[i]);
                cm.getColumn(i).setWidth(scrollableWidth[i]);
            }
        }

        for (int vColIndex = 0; vColIndex < scrollableTable.getColumnCount(); vColIndex++) {
            if (scrollableTable.getColumnClass(vColIndex) != Boolean.class) {
                TableColumn col = scrollableTable.getColumnModel().getColumn(vColIndex);
                col.setCellRenderer(new MyCellRenderer());
            }
        }
        scrollableTable.getTableHeader().setFont(TableManager.fontTyle);
        scrollableTable.getTableHeader().setForeground(Color.BLACK);
        ////////////////////////////////////////////////////////////////////////////

        SortableTableModel dmFixed = new SortableTableModel() {
            public Class getColumnClass(int c) {
                try {
                    if (getValueAt(0, c).getClass() == Boolean.class) {
                        return Boolean.class;
                    }
                    return getValueAt(0, c).getClass();
                } catch (Exception ex) {
                    return String.class;
                }
            }

            public boolean isCellEditable(int row, int col) {
                return fixedCellEditableX[col];
            }

            public void setValueAt(Object obj, int row, int col) {
                switch (col) {
                    default:
                        super.setValueAt(obj, row, col);
                        return;
                }
            }
        };

        dmFixed.setDataVector(fixedData, fixedHeader);
        fixedTable.setFont(TableManager.fontTyle);
        fixedTable.setColumnModel(new GroupableTableColumnModel());
        fixedTable.setTableHeader(new GroupableTableHeader((GroupableTableColumnModel) fixedTable.getColumnModel()));
        fixedTable.setModel(dmFixed);
        fixedTable.setSelectionMode(0);
        fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        GroupableTableColumnModel cm2 = (GroupableTableColumnModel) fixedTable.getColumnModel();
        fixedTable.getTableHeader().setResizingAllowed(false);
        fixedTable.getTableHeader().setReorderingAllowed(false);
        fixedTable.getTableHeader().setFont(TableManager.fontTyle);
        fixedTable.getTableHeader().setForeground(Color.BLACK);
        fixedTable.setRowHeight(22);

        if (fixedWidth.length > 0) {
            for (int i = 0; i < fixedWidth.length; i++) {
                cm2.getColumn(i).setMinWidth(0);
                cm2.getColumn(i).setMaxWidth(fixedWidth[i] + 1);
                cm2.getColumn(i).setPreferredWidth(fixedWidth[i]);
                cm2.getColumn(i).setWidth(fixedWidth[i]);
            }
        }

        for (int vColIndex = 0; vColIndex < fixedTable.getColumnCount(); vColIndex++) {
            if (fixedTable.getColumnClass(vColIndex) != Boolean.class) {
                TableColumn col = fixedTable.getColumnModel().getColumn(vColIndex);
                col.setCellRenderer(new MyCellRenderer());
            }
        }

        JViewport view = new JViewport();
        view.setView(fixedTable);
        view.setPreferredSize(fixedTable.getPreferredSize());
        jscrollpane.setRowHeader(view);
        jscrollpane.setViewportView(scrollableTable);
        jscrollpane.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable.getTableHeader());

    }
    /* List Selection Code */
//    public void addListSelection() {
//        jTableJO = new JTable() {
//            public void valueChanged(ListSelectionEvent e) {
//                super.valueChanged(e);
//                checkSelection(false, jTableJO);
//            }
//        };
//        fixedTable = new JTable() {
//            public void valueChanged(ListSelectionEvent e) {
//                super.valueChanged(e);
//                checkSelection(true, fixedTable);
//            }
//        };
//    }
//
//    private void checkSelection(boolean isFixedTable, JTable table) {
//
//        if (table == fixedTable || table == jTableJO) {
//            int fixedSelectedIndex = fixedTable.getSelectedRow();
//            int selectedIndex = jTableJO.getSelectedRow();
//            if (fixedSelectedIndex != selectedIndex) {
//                if (isFixedTable) {
//                    if (fixedSelectedIndex >= 0) {
//                        jTableJO.setRowSelectionInterval(fixedSelectedIndex,
//                                fixedSelectedIndex);
//                        TableManager.scrollToLast(jTableJO, fixedSelectedIndex);
//                    }
//                } else {
//                    if (selectedIndex >= 0) {
//                        fixedTable.setRowSelectionInterval(selectedIndex, selectedIndex);
//                    }
//                }
//            }
//        }
//    }
}