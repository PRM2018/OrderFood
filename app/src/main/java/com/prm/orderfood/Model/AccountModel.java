package com.prm.orderfood.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prm.orderfood.DBContext.DBConnection;
import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Entity.Role;

public class AccountModel {
    // Lấy Role đưa vào spinner
    public List<Role> getRoleList() throws SQLException {
        List<Role> list = new ArrayList<>();
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from RoleTBL";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new Role(rs.getInt(1),rs.getString(2)));// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        return list;
    }



    // Kiểm tra ở trang login
    public boolean checkAccountAndPass(String acc,String pass) throws SQLException {
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select COUNT(*) from AccountTBL where account like '"+acc+"' and pass like '"+pass+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        int count=0;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            count=rs.getInt(1);// Đọc dữ liệu từ ResultSet
        }
        if(count==1){
            connection.close();// Đóng kết nối
            return true;
        }
        connection.close();// Đóng kết nối
        return false;
    }

    public boolean checkAccountExisted(String acc) throws SQLException {
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select COUNT(*) from AccountTBL where account like '"+acc+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        int count=0;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            count=rs.getInt(1);// Đọc dữ liệu từ ResultSet
        }
        if(count==1){
            connection.close();// Đóng kết nối
            return true;
        }
        connection.close();// Đóng kết nối
        return false;
    }

    public int checkRole(String acc,String pass)throws SQLException{
        int roleId=0;
        DBConnection db=new DBConnection();
        Connection connection=db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select e.roleId\n" +
                "from AccountTBL a,EmployeeTBL e,RoleTBL r\n" +
                "where a.employeeId=e.employeeId and r.roleId=e.roleId and account like '"+acc+"' and pass like '"+pass+"'";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            roleId=rs.getInt(1);// Đọc dữ liệu từ ResultSet
        }
        connection.close();// Đóng kết nối
        return roleId;
    }
}
