/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.model;

/**
 *
 * @author Mon
 */
public class SideDish {
    private int sideDishId;
    private String sideDishName;
    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public int getSideDishId() {
        return sideDishId;
    }

    public void setSideDishId(int sideDishId) {
        this.sideDishId = sideDishId;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public void setSideDishName(String sideDishName) {
        this.sideDishName = sideDishName;
    }
}
