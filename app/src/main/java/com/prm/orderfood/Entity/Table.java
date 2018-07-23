package com.prm.orderfood.Entity;

import java.io.Serializable;

/**
 * Created by Tung Pham on 7/23/2018.
 */

public class Table implements Serializable {
    private int tableID;
    private String tableName;
    private int tableActive;
    private int tableStatus;

    public Table() {
    }

    public Table(int tableID, String tableName, int tableActive, int tableStatus) {
        this.tableID = tableID;
        this.tableName = tableName;
        this.tableActive = tableActive;
        this.tableStatus = tableStatus;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableActive() {
        return tableActive;
    }

    public void setTableActive(int tableActive) {
        this.tableActive = tableActive;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }
}
