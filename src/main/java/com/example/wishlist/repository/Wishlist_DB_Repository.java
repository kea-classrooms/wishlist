package com.example.wishlist.repository;

import com.example.wishlist.DTOs.BuildPartDTO;
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
                parts.add(new BuildPartDTO(rs.getInt("partID"), rs.getInt("numberCount"), rs.getBoolean("isWish"), getBuild(buildID)));
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

    public List<BuildPartDTO> getAllComponents() {

        List<BuildPartDTO> parts = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM COMPUTERPART";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parts.add(new BuildPartDTO(rs.getInt("partID"), 1, false, null));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return parts;
    }

    public UserBuildDTO updateParts(UserBuildDTO build) {
        for (int partID : build.getUpdatedParts()) {
            int newPartID = partID;
            if (newPartID != 0){
                BuildPartDTO part = updatePart(build.getBuildID(), newPartID);
                build.addPart(part);
            }
        }
        return build;
    }

    private BuildPartDTO updatePart(int buildID, int newPartID) {
        BuildPartDTO part = new BuildPartDTO();
        try{
            Connection con = DBManager.getConnection();
            String query1 = "SELECT * FROM BUILD_PART INNER JOIN COMPUTERPART USING(partID) WHERE (pType, buildID) = (?,?)";
            PreparedStatement pstm = con.prepareStatement(query1);
            pstm.setString(1, getPartType(newPartID));
            pstm.setInt(2, buildID);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                String query2 = "UPDATE BUILD_PART SET partID = ? WHERE (buildID, partID) = (?, ?)";
                PreparedStatement pstm2 = con.prepareStatement(query2);
                pstm2.setInt(1, newPartID);
                pstm2.setInt(2, buildID);
                pstm2.setInt(3, rs.getInt("partID"));
                pstm2.executeUpdate();
                part = new BuildPartDTO(newPartID, 1, true, getBuild(buildID));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return part;
    }

    public void getPart(int partID) {

    }

    public void createWish(BuildPartDTO wish, UserBuildDTO build) {
        try{
            Connection con = DBManager.getConnection();
            String query1 = "SELECT partID FROM COMPUTERPART WHERE pName = ?";
            PreparedStatement pstm = con.prepareStatement(query1);
            pstm.setString(1, wish.getName());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int partID = rs.getInt("partID");
                String query2 = "INSERT INTO BUILD_PART(partID, numberCount, buildID, isWish) VALUES (?, ?, ?, 1);";
                pstm = con.prepareStatement(query2);
                pstm.setInt(1, partID);
                pstm.setInt(2, wish.getNumberCount());
                pstm.setInt(3, build.getBuildID());
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BuildPartDTO> getWishes(int userID) {
        List<BuildPartDTO> wishes = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM BUILD_PART INNER JOIN BUILD USING (buildID) INNER JOIN COMPUTERPART USING (partID) WHERE userID = ? AND isWish = 1";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, userID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                BuildPartDTO wish = new BuildPartDTO(rs.getInt("partID"), rs.getInt("numberCount"), true, getBuild(rs.getInt("buildID")));
                wish.setName(rs.getString("pName"));
                wish.setPartType(rs.getString("pType"));
                wish.setPrice(rs.getInt("pPrice"));
                wishes.add(wish);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishes;
    }
}
