/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.model;

/**
 *
 * @author Mon
 */
public class Feedback {
    private int id;
    private String customerName;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
