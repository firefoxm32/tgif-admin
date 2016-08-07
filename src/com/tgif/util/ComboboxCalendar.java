/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.awt.Dimension;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author adrian
 */
public class ComboboxCalendar {

    private static Calendar cal = Calendar.getInstance();
    private static final int START_YEAR = 1900;
    private static final int SUCCEEDING_YEAR = 10;
    private static Dimension PREFERRED_SIZE;

    public static void setMonths(JComboBox jcombobox) {
        initialize(jcombobox);
        jcombobox.setModel(new DefaultComboBoxModel(new DateFormatSymbols().getMonths()));
        jcombobox.removeItemAt(jcombobox.getItemCount() - 1);
        jcombobox.setSelectedIndex(cal.get(cal.MONTH));
        jcombobox.setPreferredSize(PREFERRED_SIZE);
    }

    public static void setYears(JComboBox jcombobox) {
        initialize(jcombobox);
        int currentYear = cal.get(cal.YEAR);
        for (int year = START_YEAR; year <= (currentYear + SUCCEEDING_YEAR); year++) {
            jcombobox.addItem("" + year);
        }
        jcombobox.setSelectedItem(String.valueOf(currentYear));
        jcombobox.setPreferredSize(PREFERRED_SIZE);
    }

    private static void initialize(JComboBox jcombobox) {
        PREFERRED_SIZE = jcombobox.getPreferredSize();
        AutoCompleteDecorator.decorate(jcombobox);
        jcombobox.removeAllItems();
    }
}
