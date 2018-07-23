package com.prm.orderfood.Model;

import com.prm.orderfood.DBContext.DBConnection;
import com.prm.orderfood.Entity.Employee;
import com.prm.orderfood.Entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) { /* ignored */}
        }
    }

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

    public ArrayList<Employee> getAllEmpForAdmin() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Employee> empLst = new ArrayList<>();
        try {
            String sql = "select emp.*,role.roleName from EmployeeTBL emp left join RoleTBL role on emp.roleId = role.roleId";
            con = DBConnection.Getconnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.seteId(rs.getInt(1));
                emp.seteName(rs.getString(2));
                emp.seteAddress(rs.getString(3));
                emp.setePhone(rs.getString(4));
                emp.setRoleId(rs.getInt(5));
                emp.seteRole(rs.getString(6));
                empLst.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return empLst;
    }
}
