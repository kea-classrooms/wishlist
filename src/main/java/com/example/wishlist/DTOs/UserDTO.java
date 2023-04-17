package com.example.wishlist.DTOs;

public class UserDTO {
    private String uName;
    private int userID;


    public UserDTO(String uName, int userID) {
        this.uName = uName;
        this.userID = userID;
    }

    public UserDTO() {

    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
