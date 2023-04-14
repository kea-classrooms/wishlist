package com.example.wishlist.DTOs;

public class ComponentDTO {

    private int partID, pPrice;
    private String pName, pType;

    public ComponentDTO(int partID, int pPrice, String pType, String pName) {
        this.partID = partID;
        this.pPrice = pPrice;
        this.pType = pType;
        this.pName = pName;
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

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
