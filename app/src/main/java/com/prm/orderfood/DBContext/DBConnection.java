package com.prm.orderfood.DBContext;

import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tung Pham on 7/14/2018.
 */

public class DBConnection {

    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "sa";
    private static final String DB_NAME = "AndroidProject";
    private static final String SERVER_IP = "192.168.107.81:1433;";

    private static Connection CONNECTION = null;

    public static Connection Getconnection() {

        Log.i("Android", " SQL SERVER Connect.");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String connString;
        try {
            Log.i("SQL Looking", "Start Looking for server");
            String driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driver).newInstance();
            connString = "jdbc:jtds:sqlserver://"
                    + SERVER_IP
                    + ";databaseName="
                    + DB_NAME
                    + ";user="
                    + USER_NAME
                    + ";password="
                    + PASSWORD
                    + ";";

            CONNECTION = DriverManager.getConnection(connString);
            Log.i("Connection", "open DB Class");
        } catch (Exception e) {

            Log.w("Error connection", e.getMessage());
        }
        return CONNECTION;
    }

    public static void closeDatabase() {

        try {
            CONNECTION.close();
            Log.i("Connection", "Close DB Class");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
