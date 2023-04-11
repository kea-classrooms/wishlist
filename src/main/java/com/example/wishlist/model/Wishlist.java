package com.example.wishlist.model;

import java.util.List;

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

    //WISH
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
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
        this.sharedToUserID = sharedToUserID;
    }
    public int getUserID() {
        return userID;
    }

    public String getpName() {
        return pName;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getpPrice() {
        return pPrice;
    }
    public int getTotalPrice() {
        return totalPrice;
    }

    public String getpType() {
        return pType;
    }
    public String getListName() {
        return listName;
    }
    public void setListName(String listName) {
        this.listName = listName;
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
