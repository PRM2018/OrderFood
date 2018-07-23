package com.prm.orderfood.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prm.orderfood.DBContext.DBConnection;
import com.prm.orderfood.Entity.Table;

/**
 * Created by Tung Pham on 7/23/2018.
 */

public class TableDAO {
    public TableDAO() {
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

    public ArrayList<Table> getAllTableInfo(){
        ArrayList<Table> tableLst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from TableTBL";
        try{
            con = DBConnection.Getconnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Table table = new Table();
                table.setTableID(rs.getInt("tableID"));
                table.setTableName(rs.getString("tableName"));
                table.setTableActive(rs.getInt("isActive"));
                table.setTableStatus(rs.getInt("status"));
                tableLst.add(table);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(con,ps,rs);
        }
        return tableLst;
    }
}
