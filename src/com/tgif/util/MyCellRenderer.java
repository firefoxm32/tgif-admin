package com.tgif.util;

/**
 *
 * @author adp
 */
import java.awt.Component;
import java.text.*;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.*;

public class MyCellRenderer extends DefaultTableCellRenderer {

    public static final int rightAligned = SwingConstants.RIGHT;
    public static final int leftAligned = SwingConstants.LEFT;
    public static final int center = SwingConstants.CENTER;
    protected int alignment = -1;
    private NumberFormat nf;
    private Format formatter = new SimpleDateFormat("MM/dd/yyyy");
    private DecimalFormat dec = new DecimalFormat("#,###");
    private DecimalFormat dec2 = new DecimalFormat("#,##0.00");

    public MyCellRenderer() {
        super();
    }
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected,
                                            hasFocus, row, column);
        setToolTipText(String.valueOf(table.getValueAt(row, column)));
        return this;
    }
    public MyCellRenderer(int strAlignment) {
        alignment = strAlignment;
    }

    public void setValue(Object value) {

        if (nf == null) {
            nf = NumberFormat.getIntegerInstance();
        }

        if (value == null) {
            setText("");
        } else if (value.getClass() == Double.class) {
            setText(dec2.format(Double.valueOf(value.toString())));
            if (alignment == -1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
            } else {
                setHorizontalAlignment(alignment);
            }
        } else if (value.getClass() == java.sql.Date.class || value.getClass() == Date.class) {
            setText(formatter.format(value));
            if (alignment == -1) {
                setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                setHorizontalAlignment(alignment);
            }
        } else if (value.getClass() == String.class) {
            setText("  " + String.valueOf(value).trim());
            if (alignment != -1) {
                setHorizontalAlignment(alignment);
            }
        } else if (value.getClass() == Integer.class) {
            setText(dec.format(value));
            if (alignment == -1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
            } else {
                setHorizontalAlignment(alignment);
            }
        } else if (value.getClass() == Boolean.class) {
        }
    }
}
