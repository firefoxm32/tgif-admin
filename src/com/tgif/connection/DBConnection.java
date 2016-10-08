/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgif.connection;


import com.tgif.util.Globals;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mon
 */
public class DBConnection {
    private Connection db;
    private Statement sql;
//    private ResultSet resultSet;
    private DatabaseMetaData dbmd;
    private String host = "localhost";
    private String databaseName = "tgifriday_db";
    private String userName = "root";
    private String password = "root";

    public Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://" + host + "/" + databaseName, userName, password);
            System.out.println("db: " + db);
            dbmd = db.getMetaData();
            sql = db.createStatement();
//            JOptionPane.showMessageDialog(null, "Connection Successfull", "Connection success", JOptionPane.INFORMATION_MESSAGE);
            db.setAutoCommit(false);
        } catch (Exception exc) {
            System.out.println("db1: " + db);
            JOptionPane.showMessageDialog(null, "No Database Connection", "Connection Error", JOptionPane.ERROR_MESSAGE);
            exc.printStackTrace();
        }
        return db;
    }

    //insert/update/delete (query)
    public void executeQuery(String strSQL) throws SQLException {
        sql.executeUpdate(strSQL);
    }
    //select (query)   

    public ResultSet queryForList(String strSQL) throws SQLException {
        ResultSet result = sql.executeQuery(strSQL);
        result.setFetchSize(sql.getMaxRows());
        return result;
    }

    public void commit() throws SQLException {
        db.commit();
    }

    public void close() throws SQLException {
        db.close();
    }

    public void rollback() throws SQLException {
        db.rollback();
    }
}
