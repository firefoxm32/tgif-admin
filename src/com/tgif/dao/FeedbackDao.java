/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.tgif.model.Feedback;
import com.tgif.util.Globals;
import com.tgif.util.URLBuilder;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Mon
 */
public class FeedbackDao {
    OkHttpClient client = new OkHttpClient();

    public List<Feedback> getFeedbacks() {
        List<Feedback> list = new ArrayList<>();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/get-feedback.php")
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
                int id = object.getInt("id");
                String customerName = object.getString("customer_name");
                String message = object.getString("message");

                Feedback feedback = new Feedback();
                feedback.setId(id);
                feedback.setCustomerName(customerName);
                feedback.setMessage(message);
                
                list.add(feedback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
