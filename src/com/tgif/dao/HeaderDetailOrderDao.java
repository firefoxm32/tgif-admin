/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.sun.corba.se.spi.oa.OADefault;
import com.sun.jmx.remote.util.OrderClassLoaders;
import com.tgif.model.Category;
import com.tgif.model.FoodItem;
import com.tgif.model.OrderDetail;
import com.tgif.model.OrderHeader;
import com.tgif.model.Sauce;
import com.tgif.model.Serving;
import com.tgif.model.SideDish;
import com.tgif.util.Globals;
import com.tgif.util.URLBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Mon
 */
public class HeaderDetailOrderDao {

    OkHttpClient client = new OkHttpClient();

    public List<OrderHeader> getHeaderOrders() {
        List<OrderHeader> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/get-header-orders.php")
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

                    int id = object.getInt("id");
                    int tableNumber = object.getInt("table_number");

                    OrderHeader header = new OrderHeader();
                    header.setId(id);
                    header.setTableNumber(tableNumber);
                    list.add(header);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<OrderDetail> getDetailOrders() {
        List<OrderDetail> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/get-detail-orders.php")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            JSONObject jsonData = new JSONObject(result);

            String status = jsonData.getString("status");
            System.out.println("status: " + status);
            if (jsonData == null) {
                JOptionPane.showMessageDialog(null, "error connection");
            } else {
//                System.out.println("status:" + status);
                //parse students array object
                JSONArray arrData = jsonData.getJSONArray("items");


                for (int i = 0; i < arrData.length(); i++) {
                    JSONObject object = arrData.getJSONObject(i);

                    int id = object.getInt("id");
                    int tableNumber = object.getInt("table_number");
                    int itemId = object.getInt("item_id");
                    String itemName = object.getString("item_name");
                    String servingName = object.getString("serving");
                    String sideDishName = object.get("side_dish").toString();
//                    if ( != null) {
//                        sideDishName = object.getString("side_dish");
//                    } else {
//                        sideDishName = "";
//                    }


                    int qty = object.getInt("qty");

                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setId(id);
                    orderDetail.setTableNumber(tableNumber);
                    orderDetail.setQty(qty);

                    FoodItem foodItem = new FoodItem();
                    foodItem.setItemId(itemId);
                    foodItem.setItemName(itemName);
                    orderDetail.setFoodItem(foodItem);

                    Serving serving = new Serving();
                    serving.setServingName(servingName);
                    orderDetail.setServing(serving);

                    SideDish sideDish = new SideDish();
                    sideDish.setSideDishName(sideDishName);
                    orderDetail.setSideDish(sideDish);

                    JSONArray arrSauce = object.getJSONArray("sauces");
                    System.out.println("sauces: "+arrSauce);
                    List<Sauce> sauces = new ArrayList<>();
                    for (int j = 0; j < arrSauce.length(); j++) {
                        JSONObject jsonSauce = arrSauce.getJSONObject(j);
                        Sauce sauce = new Sauce();
                        sauce.setSauceName(jsonSauce.getString("sauce_name"));
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
}
