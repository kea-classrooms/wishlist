package com.example.wishlist.DTOs;

public class BuildPartDTO {
    int partID, numberCount;
    boolean isWish;
    String name, partType;

    public BuildPartDTO() {
    }

    public BuildPartDTO(int partID, int numberCount, boolean isWish) {
        this.partID = partID;
        this.numberCount = numberCount;
        this.isWish = isWish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartID() {
        return partID;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
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

    public boolean isWish() {
        return isWish;
    }

    public void setWish(boolean wish) {
        isWish = wish;
    }
}
