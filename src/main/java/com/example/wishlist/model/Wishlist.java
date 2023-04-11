package com.example.wishlist.model;

import java.util.List;

public class Wishlist {
    private int listID, userID, totalPrice;
    private String listName;

    public Wishlist(int userID, String listName) {
        this.userID = userID;
        this.listName = listName;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
