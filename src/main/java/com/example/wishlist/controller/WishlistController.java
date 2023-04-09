package com.example.wishlist.controller;


import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.IWishlist_Repository;
import com.example.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("wishlist")
public class WishlistController {

    IWishlist_Repository iWishlist_repository; //interface reference
    WishlistService wishlistService;

    public WishlistController(ApplicationContext context, @Value("${wishlist_DB.repository.impl") String impl) {
        this.iWishlist_repository = (IWishlist_Repository) context.getBean(impl);

    }

    WishlistController(WishlistService wishlistservice) {
        this.wishlistService = wishlistservice;
    }

    @GetMapping(path = "/")
    //returnerer wishlist
    //sender data mellem html og database
    public String getWishlist(Model model) {
        List<Wishlist> wishlistList = iWishlist_repository.getWishListByName("Christmas list", 2);
        model.addAttribute("Wishlist", wishlistList);
        return "index"; //finder templates mappen og filen
    }

    @GetMapping("/wishlist/count")

}
