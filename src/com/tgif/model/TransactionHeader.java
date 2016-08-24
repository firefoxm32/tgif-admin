/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.model;

import java.util.Date;

/**
 *
 * @author Mon
 */
public class TransactionHeader {
    private String transactionId;
    private int tableNumber;
    private Date transactionDate;
    private String cashierId; //username
    private Double cashAmount;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }
}
