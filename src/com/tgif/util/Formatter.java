/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.util;

import java.text.ParseException;


/**
 *
 * @author JPlans
 */
public class Formatter {
    
    public static String format(java.util.Date date, String pattern){        
        return new java.text.SimpleDateFormat(pattern).format(date);
    }    
    public static String format(double n, String pattern){
        return new java.text.DecimalFormat(pattern).format(n);
    }
    public static java.util.Date parse(String pattern, String date) throws ParseException{
        return new java.text.SimpleDateFormat(pattern).parse(date);
    }
    //inner class with static variables
    public final class Date {
        public static final String MYSQL_FORMAT = "yyyy/MM/dd";
        public static final String DATE_TIME_FORMAT = MYSQL_FORMAT + " hh:mm:ss a";
    }
    public final class Decimal {
        public static final String CURRENCY_FORMAT = "#,##0.00";
    }        
}
