package Entity;

public class Employee {
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
}
