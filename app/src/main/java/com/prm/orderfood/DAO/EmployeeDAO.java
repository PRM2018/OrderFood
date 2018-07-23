package com.prm.orderfood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prm.orderfood.DBContext.DBConnection;
import com.prm.orderfood.Entity.Employee;

/**
 * Created by Tung Pham on 7/15/2018.
 */

public class EmployeeDAO {
    public EmployeeDAO() {
    }

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

    public Employee getEmployeeProfile(int empID) {
        Employee emp = new Employee();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select emp.*,role.roleName from EmployeeTBL emp\n" +
                "left join RoleTBL role\n" +
                "on emp.roleId = role.roleId where employeeId = ?";
        try {
            con = DBConnection.Getconnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, empID);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setEmpID(rs.getInt("employeeId"));
                emp.setEmpName(rs.getString("employeeName"));
                emp.setEmpAddress(rs.getString("employeeAddress"));
                emp.setEmpPhone(rs.getString("employeePhone"));
                emp.setEmpRole(rs.getInt("roleId"));
                emp.setRoleName(rs.getString("roleName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return emp;
    }

    public boolean updateEmpInfo(String address, String empPhone, int empRoleID, int empID){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update EmployeeTBL set employeeAddress = ?, employeePhone = ?, roleId = ? where employeeId = ?";
        boolean check = false;
        try{
            con = DBConnection.Getconnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,address);
            ps.setString(2,empPhone);
            ps.setInt(3,empRoleID);
            ps.setInt(4,empID);
            ps.executeUpdate();

            check = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(con,ps,null);
        }
        return check;
    }
}
