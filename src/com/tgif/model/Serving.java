/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.model;

/**
 *
 * @author Mon
 */
public class Serving {
    private int servingId;
    private String servingName;
    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public int getServingId() {
        return servingId;
    }

    public void setServingId(int servingId) {
        this.servingId = servingId;
    }

    public String getServingName() {
        return servingName;
    }

    public void setServingName(String servingName) {
        this.servingName = servingName;
    }
}
