package DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBContext.DBConnection;
import Entity.Employee;

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
        String sql = "select * from EmployeeTBL where employeeId  = ?";
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return emp;
    }
}
