package com.example.wishlist.service;

import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.Wishlist_DB_Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    Wishlist_DB_Repository wishlist_db_repository;

    WishlistService(Wishlist_DB_Repository wishlist_db_repository) {
        this.wishlist_db_repository = wishlist_db_repository;


   /* public void createWish(String pName, int pPrice, String pType) {
        wishlist_db_repository.
   */}

    /*public List<Wishlist> getWishlist() {
    return wishlist_db_repository }*/
}