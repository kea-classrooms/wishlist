package com.example.wishlist.service;

import com.example.wishlist.DTOs.*;
import com.example.wishlist.repository.Wishlist_DB_Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    Wishlist_DB_Repository db;

    public WishlistService(Wishlist_DB_Repository wishlist_db_repository) {
        this.db = wishlist_db_repository;
    }

    public List<UserDTO> getAllUsers() {
        return db.getAllUsers();
    }

    public UserDTO getUser(int id) {
        return db.getUser(id);
    }

    public List<UserBuildDTO> getUserBuilds(int id) {
        List<UserBuildDTO> userBuildDTOS = db.getUserBuilds(id);
        for (UserBuildDTO userBuildDTO : userBuildDTOS) {
            userBuildDTO = getBuild(userBuildDTO.getBuildID());
        }
        return userBuildDTOS;
    }

    public UserBuildDTO getBuild(int buildID) {
        UserBuildDTO build = db.getBuild(buildID);
        List<BuildPartDTO> parts = db.getBuildParts(buildID);
        //TODO: Det her skal ryddes op og samles til 1 database kald
        for (BuildPartDTO part : parts) {
            part.setName(db.getPartName(part.getPartID()));
            part.setPartType(db.getPartType(part.getPartID()));
            build.instantiateParts();
            build.addPart(part);
        }

        return build;
    }

    public List<String> getComponentTypes() {
        return db.getAllComponentTypes();
    }

    public List<ComponentDTO> getAllParts() {
        return db.getAllComponents();
    }

    public void updateBuild(UserBuildDTO build) {
        System.out.println(build);
    }
}