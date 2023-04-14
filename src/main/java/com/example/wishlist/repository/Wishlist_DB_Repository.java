package com.example.wishlist.repository;

import com.example.wishlist.DTOs.BuildPartDTO;
import com.example.wishlist.DTOs.ComponentDTO;
import com.example.wishlist.DTOs.UserBuildDTO;
import com.example.wishlist.DTOs.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("Wishlist_DB_Repository")
public class Wishlist_DB_Repository {
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String query = "SELECT uName, userID FROM USERR";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new UserDTO(rs.getString("uName"), rs.getInt("userID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public UserDTO getUser(int id) {
        UserDTO user = null;
        try {
            Connection con = DBManager.getConnection();
            String query = "SELECT uName, userID FROM USERR WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserDTO(rs.getString("uName"), rs.getInt("userID"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<UserBuildDTO> getUserBuilds(int id) {
        List<UserBuildDTO> userBuilds = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM BUILD WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userBuilds.add(new UserBuildDTO(rs.getInt("userID"), rs.getInt("buildID"), rs.getString("buildName")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return userBuilds;
    }
    public UserBuildDTO getBuild(int buildID) {
        UserBuildDTO build = null;
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM BUILD WHERE buildID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, buildID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                build = new UserBuildDTO(rs.getInt("userID"), rs.getInt("buildID"), rs.getString("buildName"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return build;
    }

    public List<BuildPartDTO> getBuildParts(int buildID) {
        List<BuildPartDTO> parts = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM BUILD_PART WHERE buildID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, buildID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parts.add(new BuildPartDTO(rs.getInt("partID"), rs.getInt("numberCount"), rs.getBoolean("isWish")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return parts;
    }

    public String getPartName(int partID) {
        String name = "";
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM COMPUTERPART WHERE partID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, partID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("pName");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return name;
    }

    public String getPartType(int partID) {
        String type = "";
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM COMPUTERPART WHERE partID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, partID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                type = rs.getString("pType");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return type;
    }
    public List<String> getAllComponentTypes() {
        List<String> types = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT DISTINCT(pType) FROM COMPUTERPART";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                types.add(rs.getString("pType"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return types;
    }

    public List<ComponentDTO> getAllComponents() {

        List<ComponentDTO> parts = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM COMPUTERPART";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parts.add(new ComponentDTO(rs.getInt("partID"), rs.getInt("pPrice"), rs.getString("pType"), rs.getString("pName")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return parts;
    }
}
