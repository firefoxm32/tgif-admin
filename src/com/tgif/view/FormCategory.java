/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.view;

import com.tgif.dao.CategoryDao;
import com.tgif.model.Category;
import com.tgif.util.Globals;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Mon
 */
public final class FormCategory extends javax.swing.JDialog {

    private Category category;
    private String formAction = "add";
    private List<String> menuNames;

    public void setMenuNames(List<String> menuNames) {
        this.menuNames = menuNames;
    }
    

    /**
     * Creates new form FormCategory
     */
    public FormCategory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setData() {
        if (this.category != null) {
            System.out.println("not null");
            jTextFieldMenuName.setText(this.category.getName());
        } else {
            System.out.println("null");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMenuName = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 54, 25));

        jTextFieldMenuName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldMenuName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMenuNameKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldMenuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 370, 30));

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 60, -1));

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if(this.menuNames.contains(jTextFieldMenuName.getText().toLowerCase())) {
            JOptionPane.showMessageDialog(this, "Menu name already exist");
           return; 
        }
        
        if (jTextFieldMenuName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input name");
            jTextFieldMenuName.requestFocus();
            return;
        }

        CategoryDao categoryDao = new CategoryDao();

        if (this.category != null) {
            this.category.setName(jTextFieldMenuName.getText().trim());
            this.formAction = "edit";
        } else {
            this.category = new Category();
            this.category.setName(jTextFieldMenuName.getText().trim());
        }
        categoryDao.save(this.category, this.formAction);
        jTextFieldMenuName.setText("");
    }//GEN-LAST:event_jButtonSaveActionPerformed
    private static final String IMGUR_CLIENT_ID = "...";
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "Square Logo")
                .addFormDataPart("image", "Not_Found.png",
                RequestBody.create(MEDIA_TYPE_PNG, new File("C:\\Users\\Mon\\Desktop\\Not_Found.png")))
                .build();

        Request request = new Request.Builder()
                //        .header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
                .url(Globals.IMAGE_URI)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        System.out.println(response.body().string());
    }

    public static void uploadImage(String url, String sourceImageFile) {

        try {
            File sourceFile = new File(sourceImageFile);

            System.out.println("File...::::" + sourceFile + " : " + sourceFile.exists());

            final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    //                    .addFormDataPart("member_id", memberId)
                    .addFormDataPart("file", sourceFile.getName(), RequestBody.create(MEDIA_TYPE_PNG, sourceFile))
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
//            return new JSONObject(response.body().string());

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
//        return null;
    }

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jTextFieldMenuNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMenuNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonSave.doClick();
        }
    }//GEN-LAST:event_jTextFieldMenuNameKeyPressed

    public void upload(String url, File file) {
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart(
                    "file",
                    file.getName(),
                    RequestBody.create(MediaType.parse("text/plain"), file))
                    .addFormDataPart("other_field", "other_field_value")
                    .build();
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = client.newCall(request).execute();
//            RequestBody requestBody = new MultipartBody.Builder()
//            .addFormDataPart("group", getGroup())
//            .addFormDataPart("type", getType())
//            .addFormDataPart("entity", Integer.toString(getEntity()))
//            .addFormDataPart("reference", Integer.toString(getReference()))
//            .addFormDataPart("task_file", "file.png", RequestBody.create(MediaType.parse("image/png"), file))
//                                                    .build();
//            Request request = new Request.Builder().url(url).post(requestBody).build();
//            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldMenuName;
    // End of variables declaration//GEN-END:variables
}
