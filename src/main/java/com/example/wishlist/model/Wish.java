package com.example.wishlist.model;

public class Wish {
    private int partID, numberCount, listID;

    public Wish(int partID, int numberCount, int listID) {
        this.partID = partID;
        this.numberCount = numberCount;
        this.listID = listID;
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
