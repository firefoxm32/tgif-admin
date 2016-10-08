/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.tgif.model.FoodItem;
import com.tgif.model.OrderDetail;
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
public class ServeDao {

    OkHttpClient client = new OkHttpClient();

    public List<OrderDetail> getDetailOrders(String tableNumber) {
        List<OrderDetail> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/get-detail-orders.php")
                .addQueryParameter("table_number", tableNumber)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            JSONObject jsonData = new JSONObject(result);

            String status = jsonData.getString("status");
            System.out.println("STATUS: "+status);
            if (jsonData == null) {
                JOptionPane.showMessageDialog(null, "error connection");
            } else {
//                System.out.println("status:" + status);
                //parse students array object
                JSONArray arrData = jsonData.getJSONArray("items");


                for (int i = 0; i < arrData.length(); i++) {
                    JSONObject object = arrData.getJSONObject(i);
                    OrderDetail orderDetail = new OrderDetail();

                    orderDetail.setId(object.getInt("id"));
                    orderDetail.setQty(object.getInt("quantity"));
                    orderDetail.setReadyStatus(object.getString("ready_status"));
                    orderDetail.setOrderType(object.getString("order_type"));
                    
                    orderDetail.setStatus(object.getString("status"));

                    FoodItem foodItem = new FoodItem();
                    foodItem.setItemId(object.getInt("item_id"));
                    foodItem.setItemName(object.getString("item_name"));

                    Serving serving = new Serving();
                    serving.setServingName(object.getString("serving"));
                    serving.setAbbreviation(object.getString("serving_code"));

                    SideDish sideDish = new SideDish();
                    sideDish.setSideDishName(String.valueOf(object.get("side_dish")));
                    sideDish.setAbbreviation(String.valueOf(object.get("side_dish_code")));

                    orderDetail.setFoodItem(foodItem);
                    orderDetail.setServing(serving);
                    orderDetail.setSideDish(sideDish);

                    JSONArray arrSauce = object.getJSONArray("sauces");
                    List<Sauce> sauces = new ArrayList<>();
                    for (int j = 0; j < arrSauce.length(); j++) {
                        JSONObject objSauce = arrSauce.getJSONObject(j);
                        Sauce sauce = new Sauce();
                        sauce.setSauceName(objSauce.getString("sauce_name"));
                        sauce.setAbbreviation(objSauce.getString("sauce_code"));
                        sauces.add(sauce);
                    }
                    orderDetail.setSauces(sauces);
                    list.add(orderDetail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void edit(String id) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("id", id)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/serve-order.php")
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
//                JOptionPane.showMessageDialog(null, message);
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cancelPayment(String transactionId) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("transaction_id", transactionId)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/cancel-payment.php")
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
            String statuss = jsonData.getString("status");
            String message = jsonData.getString("message");
            String sql = jsonData.getString("sql");
            System.out.println("SQL: "+sql);
            if ("error".equals(statuss)) {
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateServeStatus(String status, int id) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("id", String.valueOf(id))
                .add("ready_status", status)
                .build();
        //build url
        System.out.println("URL: " + Globals.HTTP + Globals.ip + Globals.URI);
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/update-ready-status.php")
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
            String statuss = jsonData.getString("status");
            String message = jsonData.getString("message");

            if ("error".equals(statuss)) {
                JOptionPane.showMessageDialog(null, message);
            } else {
//                JOptionPane.showMessageDialog(null, message);
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
