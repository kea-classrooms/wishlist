package com.example.wishlist.controller;

import com.example.wishlist.DTOs.BuildPartDTO;
import com.example.wishlist.DTOs.ComponentDTO;
import com.example.wishlist.DTOs.UserBuildDTO;
import com.example.wishlist.DTOs.UserDTO;
import com.example.wishlist.repository.Wishlist_DB_Repository;
import com.example.wishlist.service.WishlistService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("wishlist")
public class WishlistController {
    private WishlistService service;

    public WishlistController(ApplicationContext context, @Value("${wishlist.repository.impl}") String impl) {
        this.service = new WishlistService((Wishlist_DB_Repository) context.getBean(impl));
    }

    @GetMapping("/")
    public String welcome(Model model){
        List<UserDTO> users = service.getAllUsers();
        UserDTO selectedUser = new UserDTO();
        model.addAttribute("users", users);
        model.addAttribute("selectedUser", selectedUser);
        return "login";
    }

    @GetMapping("/user-builds/{userID}")
    public String showUserBuilds(Model model, @PathVariable int userID){
        UserDTO user = service.getUser(userID);
        model.addAttribute("user", user);

        List<UserBuildDTO> userBuilds = service.getUserBuilds(userID);
        model.addAttribute("userBuilds", userBuilds);

        return "show-builds";
    }

    @GetMapping("build/{buildID}")
    public String showBuild(Model model, @PathVariable int buildID){
        UserBuildDTO build = service.getBuild(buildID);
        model.addAttribute("build", build);

        List<String> componentTypes = service.getComponentTypes();
        model.addAttribute("componentTypes", componentTypes);

        List<ComponentDTO> allParts = service.getAllParts();
        model.addAttribute("allParts", allParts);
        return "show-build";
    }

    @PostMapping("build/{buildID}")
    public String showBuild(@ModelAttribute("build") UserBuildDTO build, @PathVariable int buildID){
        service.updateBuild(build);
        return "build-updated";
    }
}
