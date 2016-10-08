/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;


import com.tgif.model.Category;
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
public class CategoryDao {

    OkHttpClient client = new OkHttpClient();

    public List<Category> getMenusData(String param) {
        List<Category> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/get-food-menus.php")
                .addQueryParameter("param", param)
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
                    String name = object.getString("menu_name");
                    int itemsCount = object.getInt("ctr");

                    Category category = new Category();
                    category.setId(id);
                    category.setName(name);
                    category.setItemsCount(itemsCount);
                    list.add(category);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save(Category category, String action) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("label", category.getName())
                .add("id", String.valueOf(category.getId()))
                .add("action", action)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/add-edit-delete-food-category.php")
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

            System.out.println("status:" + status);
            System.out.println("message:" + message);

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
