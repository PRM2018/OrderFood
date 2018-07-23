package com.prm.orderfood.Entity;

public class Food {
    private int fId;
    private String fName;
    private double fPrice;
    private int fQuantity;
    private String fImg;
    private String fDes;

    public Food() {
    }

    public Food(String fName, double fPrice, int fQuantity, String fImg, String fDes) {
        this.fName = fName;
        this.fPrice = fPrice;
        this.fQuantity = fQuantity;
        this.fImg = fImg;
        this.fDes = fDes;
    }

    public Food(int fId, String fName, double fPrice, int fQuantity, String fImg, String fDes) {
        this.fId=fId;
        this.fName = fName;
        this.fPrice = fPrice;
        this.fQuantity = fQuantity;
        this.fImg = fImg;
        this.fDes = fDes;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public double getfPrice() {
        return fPrice;
    }

    public void setfPrice(double fPrice) {
        this.fPrice = fPrice;
    }

    public int getfQuantity() {
        return fQuantity;
    }

    public void setfQuantity(int fQuantity) {
        this.fQuantity = fQuantity;
    }

    public String getfImg() {
        return fImg;
    }

    public void setfImg(String fImg) {
        this.fImg = fImg;
    }

    public String getfDes() {
        return fDes;
    }

    public void setfDes(String fDes) {
        this.fDes = fDes;
    }

    @Override
    public String toString() {
        return fName;
    }
}
