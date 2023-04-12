package com.example.wishlist.controller;

import com.example.wishlist.model.ComputerPart;
import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.Wishlist_DB_Repository;
import com.example.wishlist.service.WishlistService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("wishlist")
public class WishlistController {
    private WishlistService service;

    public WishlistController(ApplicationContext context, @Value("${wishlist.repository.impl}") String impl) {
        this.service = new WishlistService((Wishlist_DB_Repository) context.getBean(impl));
    }

    @GetMapping("/add")
    public String addWishList(Model model) {
        List<ComputerPart> computerParts = service.getPartsOrderedBy("pType");
        model.addAttribute("computerParts", computerParts);

        Wishlist list = service.getWishListByID(1);
        model.addAttribute("wishList", list);


        return "WishListUI";
    }

    @PostMapping("/add")
    public String wishListSuccess(@ModelAttribute("wishlist") Wishlist wishlist) {
        System.out.println(wishlist);

        return "Wish_Success";
    }
}
