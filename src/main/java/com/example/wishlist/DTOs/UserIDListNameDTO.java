package com.example.wishlist.DTOs;

public class UserIDListNameDTO {
    private int userID;
    private String listName;

    public UserIDListNameDTO(int userID, String listName) {
        this.userID = userID;
        this.listName = listName;
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
