package com.prm.orderfood.Model;

import com.prm.orderfood.DBContext.DBConnection;
import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Entity.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    //Add new employee
    public void addEmployee(Employee e) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = db.Getconnection();
        Statement statement = connection.createStatement();
        String eName = e.geteName();
        String eAddress = e.geteAddress();
        String ePhone = e.getePhone();
        int roleId = e.getRoleId();
        String sql = "insert into EmployeeTBL values('" + eName + "','" + eAddress + "','" + ePhone + "'," + roleId + ")";
        statement.executeUpdate(sql);
        connection.close();
    }

    // List Employee
    public ArrayList<Employee> listAllEmployee() throws SQLException {
        ArrayList<Employee> list = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection connection = db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from EmployeeTBL";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int eId = rs.getInt(1);
            String eName = rs.getString(2);
            String eAddress = rs.getString(3);
            String ePhone = rs.getString(4);
            int roleId = rs.getInt(5);
            list.add(new Employee(eId, eName, eAddress, ePhone, roleId));
        }
        connection.close();// Đóng kết nối
        return list;
    }

    // List Employee
    public Employee employeeById(int eId) throws SQLException {
        Employee employee = new Employee();
        DBConnection db = new DBConnection();
        Connection connection = db.Getconnection();
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select * from EmployeeTBL where employeeId=" + eId;
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String eName = rs.getString(2);
            String eAddress = rs.getString(3);
            String ePhone = rs.getString(4);
            int roleId = rs.getInt(5);
            employee = new Employee(eId, eName, eAddress, ePhone, roleId);
        }
        connection.close();// Đóng kết nối
        return employee;
    }

    //Delete employee
    public void deleteEmployee(int eId) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = db.Getconnection();
        Statement statement = connection.createStatement();
        String sql = "delete from EmployeeTBL where employeeId=" + eId;
        statement.executeUpdate(sql);
        connection.close();
    }

    //Edit Employee
    public void editEmployee(Employee e) throws SQLException {
        DBConnection db = new DBConnection();
        Connection connection = db.Getconnection();
        Statement statement = connection.createStatement();
        String sql = "update EmployeeTBL\n" +
                "set employeeName='" + e.geteName() + "'," +
                " employeeAddress='" + e.geteAddress() + "'," +
                "employeePhone='" + e.getePhone() + "'," +
                "roleId=" + e.getRoleId() + "\n" +
                "where employeeId=" + e.geteId();
        statement.executeUpdate(sql);
        connection.close();
    }
}
