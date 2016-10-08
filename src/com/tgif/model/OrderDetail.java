/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.model;

import java.util.List;

/**
 *
 * @author Mon
 */
public class OrderDetail {
    private int id;
    private int tableNumber;
    private int qty;
    private String readyStatus;
    private String status;
    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getReadyStatus() {
        return readyStatus;
    }

    public void setReadyStatus(String readyStatus) {
        this.readyStatus = readyStatus;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    private FoodItem foodItem;
    private Serving serving;
    private List<Sauce> sauces;
    private SideDish sideDish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
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

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) {
        this.sauces = sauces;
    }

    public SideDish getSideDish() {
        return sideDish;
    }

    public void setSideDish(SideDish sideDish) {
        this.sideDish = sideDish;
    }
}
