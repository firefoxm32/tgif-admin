/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.tgif.model.Category;
import com.tgif.model.FoodItem;
import com.tgif.model.Sauce;
import com.tgif.model.Serving;
import com.tgif.model.SideDish;
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
                .host(Globals.HTTP + Globals.ip + Globals.URI)
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
                    String categoryName = object.getString("menu_name");
                    String foodItemName = object.getString("item_name");
                    String image = object.getString("image");
                    String itemStatus = object.getString("status");
                    String description = String.valueOf(object.get("description"));
                    String promoStatus = object.getString("promo_status");

                    FoodItem foodItem = new FoodItem();

                    Category category = new Category();
                    category.setId(id);
                    category.setName(categoryName);

                    foodItem.setItemId(itemId);
                    foodItem.setItemName(foodItemName);
                    foodItem.setImage(image);
                    foodItem.setStatus(itemStatus);
                    foodItem.setDescription(description);
                    foodItem.setCategory(category);
                    foodItem.setPromoStatus(promoStatus);

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
                .add("menu_id", String.valueOf(foodItem.getCategory().getId()))
                .add("item_name", foodItem.getItemName())
                .add("image", foodItem.getImage())
                .add("description", foodItem.getDescription())
                .add("serving_name", foodItem.getServingName())
                .add("price", foodItem.getPrice())
                .add("sauce_name", foodItem.getSauceName())
                .add("side_dish_name", foodItem.getSideDishName())
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
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
                System.out.println("error: " + jsonData.get("error"));
                System.out.println("sql: " + jsonData.getString("sql"));
            } else {
                JOptionPane.showMessageDialog(null, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editDelete(FoodItem foodItem, String action) {
//        System.out.println("FOODITEM: "+foodItem.getItemName());
        //post param
        RequestBody body = null;
        if (action.equalsIgnoreCase("delete")) {
            body = new FormBody.Builder()
                    .add("item_id", String.valueOf(foodItem.getItemId()))
                    .add("action", action).build();
        } else {
            body = new FormBody.Builder()
                    .add("item_id", String.valueOf(foodItem.getItemId()))
                    .add("menu_id", String.valueOf(foodItem.getCategory().getId()))
                    .add("item_name", foodItem.getItemName())
                    .add("image", foodItem.getImage())
                    .add("description", foodItem.getDescription())
                    .add("serving_name", foodItem.getServingName())
                    .add("price", foodItem.getPrice())
                    .add("sauce_name", foodItem.getSauceName())
                    .add("side_dish_name", foodItem.getSideDishName())
                    .add("serving_id", foodItem.getServingId())
                    .add("sauce_id", foodItem.getSauceId())
                    .add("side_dish_id", foodItem.getSideDishId())
                    .add("r_serving_id", foodItem.getrServingId())
                    .add("r_sauce_id", foodItem.getrSauceId())
                    .add("r_side_dish_id", foodItem.getrSideDishId())
                    .add("action", action).build();
        }


        System.out.println("body: " + body);
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
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
                System.out.println("erro: " + jsonData.get("error"));
                System.out.println("sql: " + jsonData.getString("sql"));
            } else {
                JOptionPane.showMessageDialog(null, message);
                System.out.println("sql: " + jsonData.get("sql"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FoodItem getFoodItemDetails(int param) {
        FoodItem foodItem = new FoodItem();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/get-food-item-details.php")
                .addQueryParameter("item_id", String.valueOf(param))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            JSONObject jsonData = new JSONObject(result);

            String status = jsonData.getString("status");

            JSONObject json = jsonData.getJSONObject("item");
            if (json != null) {
                List<Serving> servings = new ArrayList<>();
                System.out.println("servings: " + json.get("servings"));
                if (!json.get("servings").toString().equalsIgnoreCase("null")) {
                    JSONArray arrServings = json.getJSONArray("servings");
                    for (int i = 0; i < arrServings.length(); i++) {
                        JSONObject jsonServing = arrServings.getJSONObject(i);
                        Serving serving = new Serving();
                        serving.setServingId(jsonServing.getInt("serving_id"));
                        serving.setServingName(jsonServing.getString("serving_name"));
                        serving.setPrice(jsonServing.getDouble("price"));
                        serving.setAbbreviation(jsonServing.getString("serving_code"));
                        servings.add(serving);
                    }
                }
                List<Sauce> sauces = new ArrayList<>();
                if (!json.get("sauces").toString().equalsIgnoreCase("null")) {
                    JSONArray arrSauces = json.getJSONArray("sauces");

                    for (int i = 0; i < arrSauces.length(); i++) {
                        JSONObject jsonSauce = arrSauces.getJSONObject(i);
                        Sauce sauce = new Sauce();
                        sauce.setSauceId(jsonSauce.getInt("sauce_id"));
                        sauce.setSauceName(jsonSauce.getString("sauce_name"));
                        sauce.setAbbreviation(jsonSauce.getString("sauce_code"));
                        sauces.add(sauce);
                    }
                }
                List<SideDish> sideDishes = new ArrayList<>();
                if (!json.get("side_dishes").toString().equalsIgnoreCase("null")) {
                    JSONArray arrSideDishes = json.getJSONArray("side_dishes");
                    for (int i = 0; i < arrSideDishes.length(); i++) {
                        JSONObject jsonSideDish = arrSideDishes.getJSONObject(i);
                        SideDish sideDish = new SideDish();
                        sideDish.setSideDishId(jsonSideDish.getInt("side_dish_id"));
                        sideDish.setSideDishName(jsonSideDish.getString("side_dish_name"));
                        sideDish.setAbbreviation(jsonSideDish.getString("side_dish_code"));
                        sideDishes.add(sideDish);
                    }
                }

                foodItem.setServings(servings);
                foodItem.setSauces(sauces);
                foodItem.setSideDishes(sideDishes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foodItem;
    }

    public void addEditPromo(FoodItem foodItem) {
        RequestBody body = new FormBody.Builder()
                .add("item_id", String.valueOf(foodItem.getItemId()))
                //                .add("promo_price", String.valueOf(foodItem.getPromoPrice()))
                .add("promo_status", foodItem.getPromoStatus())
                .build();
        System.out.println("body: " + body);
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/add-edit-promo.php")
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
                System.out.println("erro: " + jsonData.get("error"));
                System.out.println("sql: " + jsonData.getString("sql"));
            } else {
                JOptionPane.showMessageDialog(null, message);
                System.out.println("sql: " + jsonData.get("sql"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
