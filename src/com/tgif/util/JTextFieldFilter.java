/*
 * JTextFieldFilter.java
 *
 * Created on June 8, 2007, 1:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.tgif.util;

/**
 *
 * @author darkoasis09
 */
import javax.swing.text.*;

public class JTextFieldFilter extends PlainDocument {

    public static final String LOWERCASE =
            "abcdefghijklmnopqrstuvwxyz ,.";
    public static final String UPPERCASE =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
    public static final String ALPHA =
            LOWERCASE + UPPERCASE;
    public static final String NUMERIC =
            "0123456789";
    public static final String FLOAT =
            NUMERIC + ".";
    public static final String ALPHA_NUMERIC =
            ALPHA + NUMERIC;
    public static final String ACCTNUMBER =
            NUMERIC + UPPERCASE;
    public static final String NUMERIC_UPPERCASE =
            UPPERCASE + NUMERIC + " ";
    public static final String ITEMCODE =
            NUMERIC_UPPERCASE + "-";
    protected String acceptedChars = null;
    protected boolean negativeAccepted = false;
    protected int maxlength = 0;
    protected int decPlaces = 0;
    //NUMERIC_UPPERCASE = NUMERIC_UPPERCASE + ",";

    public JTextFieldFilter() {
        this(ALPHA_NUMERIC);
    }

    public JTextFieldFilter(String acceptedchars) {
        acceptedChars = acceptedchars;
    }

    public JTextFieldFilter(String acceptedchars, int length) {
        acceptedChars = acceptedchars;
        maxlength = length;
    }

    public JTextFieldFilter(String acceptedchars, int length, int decimal) {
        acceptedChars = acceptedchars;
        maxlength = length;
        decPlaces = decimal;
    }

    public JTextFieldFilter(int length) {
        acceptedChars = ALPHA_NUMERIC;
        maxlength = length;
    }

    public void setNegativeAccepted(boolean negativeaccepted) {
        if (acceptedChars.equals(NUMERIC)
                || acceptedChars.equals(FLOAT)
                || acceptedChars.equals(ALPHA_NUMERIC)) {
            negativeAccepted = negativeaccepted;
            acceptedChars += "-";
        }
    }

    /*    public void insertString
     (int offset, String  str, AttributeSet attr)
     throws BadLocationException {
     if (str == null) 
     return;

     if (acceptedChars.contentEquals(UPPERCASE) || acceptedChars.contentEquals(NUMERIC_UPPERCASE))
     str = str.toUpperCase();
     else if (acceptedChars.contentEquals(LOWERCASE))
     str = str.toLowerCase();
     else if (acceptedChars.contentEquals(ACCTNUMBER))
     str = str.toUpperCase();
        
     for (int i=0; i < str.length(); i++) {
     if (acceptedChars.indexOf(str.charAt(i)) == -1)
     return;
     }

     if(acceptedChars.equals(FLOAT))
     {
     //System.out.println("asd");
     if(maxlength > 0 && getText(0, getLength()).indexOf(".") > -1 && getText(0, getText(0, getLength()).indexOf(".")).length() == maxlength)
     {
     return;
     }
     else if(maxlength > 0 && getLength() == maxlength)
     return;
     }
     else if(maxlength > 0 && getLength() == maxlength)
     {
     return;
     }
        
     if (acceptedChars.equals(ACCTNUMBER) && maxlength == 4 && str.indexOf(",") == -1 && str.indexOf(" ") == -1)
     {
     if(UPPERCASE.indexOf(str) != -1 && offset != getLength() && offset != 0)
     {
     return;
     }
     else if(UPPERCASE.indexOf(str) != -1 && offset==0)
     {
     super.insertString(0, "001", attr);
     offset = 3;
     }
     else if(UPPERCASE.indexOf(str) != -1)
     {
     String strTemp = getText(0, getLength());
     super.remove(0, getLength());
     super.insertString(0, UserDefinedFunction.str_pad(strTemp, 3, "0", 0), attr);
     offset = 3;
     }
     }
                
     if (acceptedChars.equals(FLOAT) ||
     (acceptedChars.equals(FLOAT + "-") && negativeAccepted)) {
     if (str.indexOf(".") != -1) {
     if (getText(0, getLength()).indexOf(".") != -1) {
     return;
     }
     }
            
     if(str.indexOf(".") == 0 && getLength() == 0)
     {
     super.insertString(0, "0", attr);
     offset = 1;
     }
            
     if(str.indexOf("0") == 0 && ( getText(0, getLength()).indexOf(".") > 0 || getLength() > 0) && offset == 0)
     return;
            
     if(getText(0, getLength()).indexOf(".") != -1 && decPlaces > 0)
     {
     if((getText(getText(0, getLength()).indexOf("."), getLength()).length()) > decPlaces )
     return;
     }
            
     if(getText(0, 1).equals("0") && str.indexOf(".") == -1 && getText(0, getLength()).indexOf(".") == -1)
     {
     super.remove(0, 1); //replace(0, 1, "", attr);
     offset = 0;
     }
     }
        
     if (negativeAccepted && str.indexOf("-") != -1) {
     if (str.indexOf("-") != 0 || offset != 0 ) {
     return;
     }
     }
     System.out.println(offset + " " + str + " " + attr);
     super.insertString(offset, str, attr);
     }
     */
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (maxlength > 0 && maxlength == getLength()) {
            return;
        }

        if (str == null) {
            return;
        }

        str = str.toUpperCase();
        //System.out.println(acceptedChars + " | " + UPPERCASE);
        if (acceptedChars.equals(UPPERCASE)) {
            super.insertString(offset, str.toUpperCase(), attr);
            return;
        }
        /*
         if (acceptedChars.equals(UPPERCASE))
         str = str.toUpperCase();
         else if (acceptedChars.equals(LOWERCASE))
         str = str.toLowerCase();
         */

        for (int i = 0; i < str.length(); i++) {
            if (acceptedChars.indexOf(str.valueOf(str.charAt(i))) == -1) {
                //System.out.println(str.valueOf(str.charAt(i)));
                return;
            }
        }

        if (acceptedChars.equals(FLOAT)
                || (acceptedChars.equals(FLOAT + "-") && negativeAccepted)) {
            if (str.indexOf(".") != -1) {
                if (getText(0, getLength()).indexOf(".") != -1) {
                    return;
                }
            }
        }

        if (negativeAccepted && str.indexOf("-") != -1) {
            if (str.indexOf("-") != 0 || offset != 0) {
                return;
            }
        }

        super.insertString(offset, str, attr);
    }
}
