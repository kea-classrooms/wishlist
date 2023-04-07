package com.example.wishlist.controller;

import com.example.wishlist.model.Wish;
import com.example.wishlist.model.Wishlist;
import com.example.wishlist.repository.Wishlist_DB_Repository;
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
    private Wishlist_DB_Repository database;

    public WishlistController(ApplicationContext context, @Value("${wishlist.repository.impl}") String impl) {
        this.database = (Wishlist_DB_Repository) context.getBean(impl);
    }

    @GetMapping("/add")
    public String addWishList(Model model){
        //TODO: wishlist skal addes til model, sammen med de typer af komponenter/andet data vi skal bruge
        List<String> componentTypes = new ArrayList<>(
                List.of("GPU", "Motherboard", "CPU", "Power Supply", "Headset", "Capture card", "Storage", "CPU cooler")
        );
        Wishlist list = new Wishlist(1, "test");

        model.addAttribute("wishList", list);
        model.addAttribute("componentTypes", componentTypes);
        return "WishListUI";
    }

    @PostMapping("/add")
    public String wishListSuccess(@ModelAttribute("wishlist") Wishlist wishlist){
        System.out.println(wishlist);
        //TODO: Skal kobles til database metode der poster ønskelisten
        return "Wish_Success";
    }
}
