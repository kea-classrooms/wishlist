package com.example.wishlist.DTOs;

import java.util.ArrayList;
import java.util.List;

public class UserBuildDTO {
    private int userID, buildID;
    private String buildName;
    private List<BuildPartDTO> parts;

    private List<String> types;

    public UserBuildDTO(int userID, int buildID, String buildName) {
        this.userID = userID;
        this.buildID = buildID;
        this.buildName = buildName;
        parts = new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBuildID() {
        return buildID;
    }

    public void setBuildID(int buildID) {
        this.buildID = buildID;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public List<BuildPartDTO> getParts() {
        return parts;
    }

    public void addParts(List<BuildPartDTO> parts) {
        this.parts.addAll(parts);
    }

    public boolean containsPart(int id){
        for (BuildPartDTO part : parts) {
            if (part.partID == id) return true;
        }
        return false;
    }
}
