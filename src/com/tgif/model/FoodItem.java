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
public class FoodItem {

    private int itemId;
    private String itemName;
    private String image;
    private String price;
    private String description;
    private String servingName;
    private String sauceName;
    private String sideDishName;
    private String servingId;
    private String sauceId;
    private String sideDishId;
    private String rServingId;
    private String rSauceId;
    private String rSideDishId;
    private String status;
    private String promoStatus;
    private Category category;
    private List<Serving> servings;
    private List<Sauce> sauces;
    private List<SideDish> sideDishes;

    public String getPrice() {
        return price;
    }

    public List<Serving> getServings() {
        return servings;
    }

    public void setServings(List<Serving> servings) {
        this.servings = servings;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) {
        this.sauces = sauces;
    }

    public List<SideDish> getSideDishes() {
        return sideDishes;
    }

    public void setSideDishes(List<SideDish> sideDishes) {
        this.sideDishes = sideDishes;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getServingName() {
        return servingName;
    }

    public void setServingName(String servingName) {
        this.servingName = servingName;
    }

    public String getSauceName() {
        return sauceName;
    }

    public void setSauceName(String sauceName) {
        this.sauceName = sauceName;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public void setSideDishName(String sideDishName) {
        this.sideDishName = sideDishName;
    }

    public String getServingId() {
        return servingId;
    }

    public void setServingId(String servingId) {
        this.servingId = servingId;
    }

    public String getSauceId() {
        return sauceId;
    }

    public void setSauceId(String sauceId) {
        this.sauceId = sauceId;
    }

    public String getSideDishId() {
        return sideDishId;
    }

    public void setSideDishId(String sideDishId) {
        this.sideDishId = sideDishId;
    }

    public String getrServingId() {
        return rServingId;
    }

    public void setrServingId(String rServingId) {
        this.rServingId = rServingId;
    }

    public String getrSauceId() {
        return rSauceId;
    }

    public void setrSauceId(String rSauceId) {
        this.rSauceId = rSauceId;
    }

    public String getrSideDishId() {
        return rSideDishId;
    }

    public void setrSideDishId(String rSideDishId) {
        this.rSideDishId = rSideDishId;
    }
    
    public String getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(String promoStatus) {
        this.promoStatus = promoStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
