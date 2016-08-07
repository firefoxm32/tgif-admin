/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tgif.util;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author adrian
 */
public class MyTableRenderAlignment extends DefaultTableCellRenderer {
    
    public MyTableRenderAlignment(int alignment) {
        super();
        this.setHorizontalAlignment(alignment);
    }
}
