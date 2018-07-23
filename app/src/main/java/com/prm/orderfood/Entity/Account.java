package com.prm.orderfood.Entity;

public class Account {
    private String accName;
    private String accPass;
    private int employeeId;

    public Account() {
    }

    public Account(String accName, String accPass, int employeeId) {
        this.accName = accName;
        this.accPass = accPass;
        this.employeeId = employeeId;
    }

    public Account(String accName, String accPass) {
        this.accName = accName;
        this.accPass = accPass;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
