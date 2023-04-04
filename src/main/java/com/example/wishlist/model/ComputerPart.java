package com.example.wishlist.model;

public class ComputerPart {
    private String pName, pType;
    private int partID, pPrice;

    public ComputerPart(int partID, String pName, int pPrice, String pType) {
        this.partID = partID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pType = pType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }
}
