package com.example.wishlist.repository;

import com.example.wishlist.DTOs.UserIDListNameDTO;
import com.example.wishlist.model.ComputerPart;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("Wishlist_DB_Repository")
public class Wishlist_DB_Repository {

    public List<ComputerPart> getPartsOrdered(String orderBy) {
        List<ComputerPart> parts = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM COMPUTERPART ORDER BY ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orderBy);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                parts.add(new ComputerPart(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return parts;
    }

    public void addWish(Wish wish){
        try{
            Connection con = DBManager.getConnection();
            String query = "INSERT INTO WISH(partID, numberCount, listID) VALUE (?, ?, ? )";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, wish.getPartID());
            ps.setInt(2, wish.getNumberCount());
            ps.setInt(3, wish.getListID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Wishlist getWishListByID(int id) {
        Wishlist wishlist = null;
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM WISHLIST WHERE listID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                wishlist = new Wishlist(rs.getInt("listID"), rs.getInt("userID"), rs.getString("listName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishlist;
    }

    public List<Wish> getWishesFromListID(int listID) {
        List<Wish> wishes = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM WISH WHERE listID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, listID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                wishes.add(new Wish(rs.getInt("partID"), rs.getInt("numberCount"), rs.getInt("listID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishes;
    }
}
