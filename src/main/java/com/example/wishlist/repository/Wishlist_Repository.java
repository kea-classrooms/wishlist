package com.example.wishlist.repository;

import com.example.wishlist.model.Wishlist;

import java.util.List;

public interface Wishlist_Repository {

    List<Wishlist> getWishListByName(String pName );
}
