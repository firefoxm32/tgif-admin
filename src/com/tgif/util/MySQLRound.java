/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

/**
 *
 * @author adrian
 */
public class MySQLRound {

    public static double get(double d, int places) {
        String[] input = String.valueOf(d).replace(".", "@").split("@");
        String wholeNumber = input[0];
        String decimalValue = input[1];
        int len = decimalValue.length();
        if (len <= places) {
            for (int x = 0; x <= (places - len); x++) {
                decimalValue = decimalValue + "0";
            }
        }
        char[] c = decimalValue.toCharArray();
        String numToRound = "";
        for (int index = 0; index < places; index++) {
            numToRound = numToRound + c[index];
        }
        String succeedingDigit = c[places] + "";
        int counter = Integer.valueOf(succeedingDigit) >= 5 ? 1 : 0;
        int divisor = 1;
        for (int i = 0; i < places; i++) {
            divisor *= 10;
        }
        String newValue = String.valueOf(Integer.valueOf(wholeNumber + numToRound) + counter);
        return Double.valueOf(newValue) / divisor;
    }
}