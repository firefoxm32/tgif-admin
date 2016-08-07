/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.tgif.model.Category;
import com.tgif.model.FoodItem;
import com.tgif.util.Globals;
import com.tgif.util.URLBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Mon
 */
public class FoodItemsDao {
    
    OkHttpClient client = new OkHttpClient();
    
    public List<FoodItem> getFoodItems(String field, String value) {
        List<FoodItem> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/get-food-items.php")
                .addQueryParameter("field", field)
                .addQueryParameter("value", value)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            JSONObject jsonData = new JSONObject(result);

            String status = jsonData.getString("status");
            if (jsonData == null) {
                JOptionPane.showMessageDialog(null, "error connection");
            } else {
//                System.out.println("status:" + status);
                //parse students array object
                JSONArray arrData = jsonData.getJSONArray("items");


                for (int i = 0; i < arrData.length(); i++) {
                    JSONObject object = arrData.getJSONObject(i);
                    
                    int itemId = object.getInt("item_id");
                    int id = object.getInt("menu_id");
                    String categoryName = object.getString("label");
                    String foodItemName = object.getString("menu_name");
                    String image = object.getString("image");
//                    String description = object.getString("description");
                    String description = String.valueOf(object.get("description"));
                    
                    FoodItem foodItem = new FoodItem();
                    
                    Category category = new Category();
                    category.setId(id);
                    category.setName(categoryName);
                    
                    foodItem.setItemId(itemId);
                    foodItem.setItemName(foodItemName);
                    foodItem.setImage(image);
                    foodItem.setDescription(description);
                    foodItem.setCategory(category);
                    
                    list.add(foodItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void add(FoodItem foodItem) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("category_id", String.valueOf(foodItem.getCategory().getId()))
                .add("item_name", foodItem.getItemName())
                .add("image", foodItem.getImage())
                .add("description", foodItem.getDescription())
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/add-food-item.php")
                .build();

        //build post request
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            //execute request
            Response response = client.newCall(request).execute();
            //response call
            String result = response.body().string();
            //parse result to json
            JSONObject jsonData = new JSONObject(result);

            //display
            String status = jsonData.getString("status");
            String message = jsonData.getString("message");

            if ("error".equals(status)) {
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editDelete(FoodItem foodItem, String action) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("item_id", String.valueOf(foodItem.getItemId()))
                .add("category_id", String.valueOf(foodItem.getCategory().getId()))
                .add("item_name", foodItem.getItemName())
                .add("image", foodItem.getImage())
                .add("description", foodItem.getDescription())
                .add("action", action)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/edit-delete-food-items.php")
                .build();

        //build post request
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            //execute request
            Response response = client.newCall(request).execute();
            //response call
            String result = response.body().string();
            //parse result to json
            JSONObject jsonData = new JSONObject(result);

            //display
            String status = jsonData.getString("status");
            String message = jsonData.getString("message");
            
            if ("error".equals(status)) {
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
