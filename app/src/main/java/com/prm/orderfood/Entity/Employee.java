package com.prm.orderfood.Entity;

import java.io.Serializable;

/**
 * Created by Tung Pham on 7/15/2018.
 */

public class Employee implements Serializable {
    private int empID;
    private String empName;
    private String empAddress;
    private String empPhone;
    private int empRole;
    private String roleName;

    public Employee() {
    }

    public Employee(int empID, String empName, String empAddress, String empPhone, int empRole, String roleName) {
        this.empID = empID;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empRole = empRole;
        this.roleName = roleName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public int getEmpRole() {
        return empRole;
    }

    public void setEmpRole(int empRole) {
        this.empRole = empRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
