package com.example.wishlist.repository;

import com.example.wishlist.model.Wishlist;

import java.util.List;

public interface IWishlist_Repository {

    List<Wishlist> getWishListByName(String pName, int listID );

    List<Wishlist> getAllWishes(String pName, int pPrice, String pType);

    List<Wishlist> getWishByName(String pName);

    List<Wishlist> getUserByName(String uName, int userID);

    List<Wishlist> getComputerpartByID(int partID, int numberCount );

    List<Wishlist> getSharedList(String listName);

    //List<Wishlist>
}
