/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author JPlans
 */
public class TextListener {

    private static JTextField text;

    public static void install(JTextField src) {
        text = src;
        text.addFocusListener(new MyListener());
        text.addKeyListener(new MyListener());
    }

    public static class MyListener implements KeyListener, FocusListener {

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            text = (JTextField) ke.getSource();
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                text.transferFocus();
            }
        }

        @Override
        public void focusGained(FocusEvent fe) {
            text = (JTextField) fe.getSource();
            //if()
            text.selectAll();
            text.setForeground(Color.BLACK);
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }
}
