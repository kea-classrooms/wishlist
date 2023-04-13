package com.example.wishlist.service;

import com.example.wishlist.repository.Wishlist_DB_Repository;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    Wishlist_DB_Repository wishlist_db_repository;

    WishlistService(Wishlist_DB_Repository wishlist_db_repository) {
        this.wishlist_db_repository = wishlist_db_repository;
    }
}