/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.tgif.model.Category;
import com.tgif.model.User;
import com.tgif.util.Globals;
import com.tgif.util.SharedPrefs;
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
public class UserDao {
    OkHttpClient client = new OkHttpClient();

    public List<User> getUserData() {
        List<User> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/get-users.php")
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
                    
                    String username = object.getString("username");
                    int tableNumber = object.getInt("table_number");
                    String userType = object.getString("user_type");
                    String password = object.getString("password");
                    
                    User user = new User();
                    user.setUsername(username);
                    user.setTableNumber(tableNumber);
                    user.setUserType(userType);
                    user.setPassword(password);
                    
                    list.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void save(User user, String action) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("username", user.getUsername())
                .add("password", user.getPassword())
                .add("table_number", String.valueOf(user.getTableNumber()))
                .add("user_type", user.getUserType())
                .add("action",action)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.URI)
                .addPathSegment("admin/add-user.php")
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
    
    public User login(User user) {
        User u = user;
        RequestBody body = new FormBody.Builder()
                .add("username", user.getUsername())
                .add("password", user.getPassword())
                .add("user_type", user.getUserType())
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("login.php")
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
            
            user.setUserType(jsonData.getString("user_type"));
            if ("error".equals(status)) {
                JOptionPane.showMessageDialog(null, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
    
    public void logout(String username) {
        RequestBody body = new FormBody.Builder()
                .add("username", username)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("logout.php")
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
            System.out.println("status: "+status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
