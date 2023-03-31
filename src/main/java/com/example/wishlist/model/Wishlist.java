package com.example.wishlist.model;

public class Wishlist {

    //COMPUTERPART
    private String pName;
    private int pPrice;
    private String pType;

    //USERR
    private String uName;

    //WISHLIST
    private int userID;
    private String listName;

    //COMPUTERPART
    private int partID;
    private int numberCount;
    private int listID;

    //SHARED
    private int sharedToUserID;

    public Wishlist(String pName, int pPrice, String pType, String uName,
                    int userID, String listName, int partID, int numberCount,
                    int listID, int sharedToUserID) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pType = pType;
        this.uName = uName;
        this.userID = userID;
        this.listName = listName;
        this.partID = partID;
        this.numberCount = numberCount;
        this.listID = listID;
        this.sharedToUserID = sharedToUserID;
    }

    public String getpName() {
        return pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public String getpType() {
        return pType;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "pName='" + pName + '\'' +
                "pPrice='" + pPrice + '\'' +
                "pType='" + pType + '\'' +
                '}';
    }

}
