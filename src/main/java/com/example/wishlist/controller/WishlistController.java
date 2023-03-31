package com.example.wishlist.controller;


import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.IWishlist_Repository;
import com.example.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("wishlist")
public class WishlistController {

    IWishlist_Repository iWishlist_repository; //interface reference
    WishlistService wishlistService;

    public WishlistController(ApplicationContext context, @Value("wishlist_DB") String impl) {

    }

    WishlistController(WishlistService wishlistservice) {
        this.wishlistService = wishlistservice;
    }

    @GetMapping(path = "/")
    //returnerer wishlist
    public ResponseEntity<List<Wishlist>> getWishlist() {
        return new ResponseEntity<>(wishlist, HttpStatus.OK);
    }

}
