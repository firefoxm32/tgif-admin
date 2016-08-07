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
    private String description;
    private Category category;

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
}
