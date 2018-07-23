package com.prm.orderfood.Entity;

public class Employee {
    private int eId;
    private String eName;
    private String eAddress;
    private String ePhone;
    private int roleId;

    public Employee() {
    }

    public Employee(String eName, String eAddress, String ePhone, int roleId) {
        this.eName = eName;
        this.eAddress = eAddress;
        this.ePhone = ePhone;
        this.roleId = roleId;
    }

    public Employee(int eId, String eName, String eAddress, String ePhone, int roleId) {
        this.eId = eId;
        this.eName = eName;
        this.eAddress = eAddress;
        this.ePhone = ePhone;
        this.roleId = roleId;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return  eName ;
    }
}
