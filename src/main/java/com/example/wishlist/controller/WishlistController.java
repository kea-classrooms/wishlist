package com.example.wishlist.controller;

import com.example.wishlist.repository.Wishlist_DB_Repository;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wishlist")
public class WishlistController {
    private Wishlist_DB_Repository database;

    public WishlistController(ApplicationContext context, @Value("${wishlist.repository.impl}") String impl) {
        this.database = (Wishlist_DB_Repository) context.getBean(impl);
    }

}
