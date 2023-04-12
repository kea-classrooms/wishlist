package com.example.wishlist.service;

import com.example.wishlist.DTOs.UserIDListNameDTO;
import com.example.wishlist.model.ComputerPart;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.Wishlist_DB_Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    Wishlist_DB_Repository db;

    public WishlistService(Wishlist_DB_Repository wishlist_db_repository) {
        this.db = wishlist_db_repository;
    }

    public List<ComputerPart> getPartsOrderedBy(String pType) {
       return db.getPartsOrdered(pType);
    }

    public Wishlist getWishListByID(int id) {
        Wishlist wishlist = db.getWishListByID(id);
        List<Wish> wishes = db.getWishesFromListID(wishlist.getListID());
        wishlist.setWishes(wishes);
        return wishlist;
    }

    public Wishlist addWishes(int id, List<Wish> wishes){

    }
}