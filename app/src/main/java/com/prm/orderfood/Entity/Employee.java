package com.prm.orderfood.Entity;

public class Employee {
    private int eId;
    private String eName;
    private String eAddress;
    private String ePhone;
    private int roleId;
    private String eRole;

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

    public Employee(int eId, String eName, String eAddress, String ePhone, int roleId, String eRole) {
        this.eId = eId;
        this.eName = eName;
        this.eAddress = eAddress;
        this.ePhone = ePhone;
        this.roleId = roleId;
        this.eRole = eRole;
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

    public String geteRole() {
        return eRole;
    }

    public void seteRole(String eRole) {
        this.eRole = eRole;
    }

    @Override
    public String toString() {
        return  eName ;
    }
}
