package com.prm.orderfood.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.prm.orderfood.DBContext.DBConnection;
import com.prm.orderfood.Entity.Food;
import com.prm.orderfood.Entity.Food;

public class FoodModel {
    //Add new food
    public void addFood(Food f) throws SQLException {
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement=connection.createStatement();
        String fName=f.getfName();
        double fPrice=f.getfPrice();
        int fQuantity=f.getfQuantity();
        String fImg=f.getfImg();
        String fDes=f.getfDes();
        String sql="insert into FoodTBL values('"+fName+"',"+fPrice+","+fQuantity+",'"+fImg+"','"+fDes+"')";
        statement.executeUpdate(sql);
        connection.close();
    }

    //Add new food
    public void deleteFood(int foodId) throws SQLException {
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement=connection.createStatement();
        String sql="delete from FoodTBL where foodId="+foodId;
        statement.executeUpdate(sql);
        connection.close();
    }

    //Edit food
    public void editFood(Food f) throws SQLException {
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement=connection.createStatement();
        int fId=f.getfId();
        String fName=f.getfName();
        double fPrice=f.getfPrice();
        int fQuantity=f.getfQuantity();
        String fImg=f.getfImg();
        String fDes=f.getfDes();
        String sql="update FoodTBL \n" +
                "set foodName='"+fName+"' ,\n" +
                "\tfoodPrice="+fPrice+",\n" +
                "\tfoodQuantity="+fQuantity+",\n" +
                "\tfoodImg='"+fImg+"',\n" +
                "\tfoodDescription='"+fDes+"'\n" +
                "where foodId="+fId+"";
        statement.executeUpdate(sql);
        connection.close();
    }

    // List All Food
    public ArrayList<Food> listAllFood() throws SQLException {
        ArrayList<Food> list = new ArrayList<>();
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from FoodTBL";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int fId=rs.getInt(1);
            String fName=rs.getString(2);
            Double fPrice=rs.getDouble(3);
            int fQuantity=rs.getInt(4);
            String fImg=rs.getString(5);
            String fDes=rs.getString(6);
            list.add(new Food(fId,fName,fPrice,fQuantity,fImg,fDes));
        }
        connection.close();// Đóng kết nối
        return list;
    }

    // Food by id
    public Food foodById(int foodId) throws SQLException {
        Food food = null;
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * \n" +
                    "from FoodTBL\n" +
                    "where foodId="+foodId;
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int fId=rs.getInt(1);
            String fName=rs.getString(2);
            Float fPrice=rs.getFloat(3);
            int fQuantity=rs.getInt(4);
            String fImg=rs.getString(5);
            String fDes=rs.getString(6);
            food=new Food(fId,fName,fPrice,fQuantity,fImg,fDes);
        }
        connection.close();// Đóng kết nối
        return food;
    }

}
