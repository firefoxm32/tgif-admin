/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.dao;

import com.tgif.model.Membership;
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
public class MembershipDAO {
    OkHttpClient client = new OkHttpClient();

    public List<Membership> getMembers() {
        List<Membership> list = new ArrayList();
        //build url with query param (optional)
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/get-members.php")
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
                    
                    Membership membership = new Membership();
                    membership.setMemberId(object.getString("member_id"));
                    membership.setName(object.getString("name"));
                    membership.setAddress(object.getString("address"));
                    membership.setStatus(object.getString("membership_status"));
                    membership.setContactNumber(object.getString("contact_number"));
                    
                    list.add(membership);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void save(Membership membership, String action) {
        //post param
        RequestBody body = new FormBody.Builder()
                .add("membership_id", membership.getMemberId())
                .add("name", membership.getName())
                .add("address", membership.getAddress())
                .add("contact_number", membership.getContactNumber())
                .add("membership_status", membership.getStatus())
                .add("action", action)
                .build();
        //build url
        String url = new URLBuilder()
                .host(Globals.HTTP + Globals.ip + Globals.URI)
                .addPathSegment("admin/add-edit-membership.php")
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
