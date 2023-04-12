package com.example.wishlist.model;

import java.util.List;

public class Wishlist {
    private int listID, userID;
    private String listName;
    List<Wish> wishes;

    public Wishlist(int listID, int userID, String listName) {
        this.listID = listID;
        this.userID = userID;
        this.listName = listName;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public boolean containsPart(int partID){
        for (Wish wish : wishes) {
            if (wish.getPartID() == partID) return true;
        }
        return false;
    }

    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
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
    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
