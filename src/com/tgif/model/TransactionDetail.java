/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Mon
 */
public class TransactionDetail {

    private String transactionId;
    private Double price;
    private int quantity;
    private int tableNumber;
    private Date dateOrder;
    private FoodItem foodItem;
    private Serving serving;
    private List<Sauce> sauce;
    private SideDish sideDish;
    private Double credit;
    private Double debit;
    private Double cash;
    private String memberId;
    private String ccNumber;
    private String ccName;
   
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Serving getServing() {
        return serving;
    }

    public void setServing(Serving serving) {
        this.serving = serving;
    }

    public List<Sauce> getSauce() {
        return sauce;
    }

    public void setSauce(List<Sauce> sauce) {
        this.sauce = sauce;
    }

    public SideDish getSideDish() {
        return sideDish;
    }

    public void setSideDish(SideDish sideDish) {
        this.sideDish = sideDish;
    }
}
