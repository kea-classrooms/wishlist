package com.example.wishlist.model;

public class Wish {
    private int wishID, partID, numberCount, listID;

    public Wish(int wishID, int partID, int numberCount, int listID) {
        this.wishID = wishID;
        this.partID = partID;
        this.numberCount = numberCount;
        this.listID = listID;
    }

    public int getWishID() {
        return wishID;
    }

    public void setWishID(int wishID) {
        this.wishID = wishID;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public void setNumberCount(int numberCount) {
        this.numberCount = numberCount;
    }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }
}
