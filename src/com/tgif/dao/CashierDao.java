/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.tgif.model.FoodItem;
import com.tgif.model.Sauce;
import com.tgif.model.Serving;
import com.tgif.model.SideDish;
import com.tgif.model.Table;
import com.tgif.model.TransactionDetail;
import com.tgif.model.User;
import com.tgif.util.Globals;
import com.tgif.util.URLBuilder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Mon
 */
public class CashierDao {

    OkHttpClient client = new OkHttpClient();

    public List<Table> getTableStatus() {
        List<Table> list = new ArrayList<>();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/get-table-status.php")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            JSONObject jsonData = new JSONObject(result);

            String status = jsonData.getString("status");

            JSONArray arrData = jsonData.getJSONArray("items");
            for (int i = 0; i < arrData.length(); i++) {
                JSONObject object = arrData.getJSONObject(i);
                int tableNumber = object.getInt("table_number");
                String tableStatus = object.getString("status");

                Table table = new Table();
                table.setTableNumber(tableNumber);
                table.setStatus(tableStatus);
                list.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TransactionDetail> getTransactionDetails(int tableNumber) {
        List<TransactionDetail> list = new ArrayList<>();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/get-transaction-details.php")
                .addQueryParameter("table_number", String.valueOf(tableNumber))
                .build();
        System.out.println("url: " + url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            JSONObject jsonData = new JSONObject(result);

            String status = jsonData.getString("status");
            System.out.println("sql: " + jsonData.getString("sql"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            JSONArray arrData = jsonData.getJSONArray("items");
            for (int i = 0; i < arrData.length(); i++) {
                JSONObject object = arrData.getJSONObject(i);
                String transactionId = object.getString("transaction_id");
                Date dateOrder = formatter.parse(String.valueOf(object.get("date_order")));
                Double price = object.getDouble("price");
                int qty = object.getInt("qty");

                FoodItem foodItem = new FoodItem();
                foodItem.setItemId(object.getInt("item_id"));
                foodItem.setItemName(object.getString("item_name"));

                Serving serving = new Serving();
                serving.setServingId(object.getInt("serving_id"));
                serving.setServingName(object.getString("serving_name"));
                serving.setAbbreviation(object.getString("fs_abbreviation"));

                SideDish sideDish = new SideDish();
                sideDish.setSideDishId(object.getInt("side_dish_id"));
                sideDish.setSideDishName(String.valueOf(object.get("side_dish_name")));
                sideDish.setAbbreviation(object.getString("sd_abbreviation"));

                List<Sauce> sauces = new ArrayList<>();
                JSONArray arrSauce = object.getJSONArray("sauces");
                for (int x = 0; x < arrSauce.length(); x++) {
                    JSONObject objSauce = arrSauce.getJSONObject(x);
                    Sauce sauce = new Sauce();
                    sauce.setSauceId(objSauce.getInt("sauce_id"));
                    sauce.setSauceName(objSauce.getString("sauce_name"));
                    sauce.setAbbreviation(objSauce.getString("s_abbreviation"));
                    sauces.add(sauce);
                }

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransactionId(transactionId);
                transactionDetail.setTableNumber(tableNumber);
                transactionDetail.setDateOrder(dateOrder);
                transactionDetail.setPrice(price);
                transactionDetail.setQuantity(qty);
                transactionDetail.setFoodItem(foodItem);
                transactionDetail.setServing(serving);
                transactionDetail.setSideDish(sideDish);
                transactionDetail.setSauce(sauces);
                list.add(transactionDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
