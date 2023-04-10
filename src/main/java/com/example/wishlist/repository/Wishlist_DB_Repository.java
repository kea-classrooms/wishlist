package com.example.wishlist.repository;

import com.example.wishlist.model.ComputerPart;
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

    public List<ComputerPart> getParts() {
        List<ComputerPart> parts = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String query = "SELECT * FROM COMPUTERPART ORDER BY pType";
            PreparedStatement ps = con.prepareStatement(query);
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
}
