package com.example.wishlist.controller;

import com.example.wishlist.DTOs.BuildPartDTO;
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

        List<BuildPartDTO> wishes = service.getWishes(userID);
        model.addAttribute("wishes", wishes);

        return "show-builds";
    }

    @GetMapping("build/{buildID}")
    public String showBuild(Model model, @PathVariable int buildID){
        UserBuildDTO build = service.getBuild(buildID);
        model.addAttribute("build", build);

        List<String> componentTypes = service.getComponentTypes();
        model.addAttribute("componentTypes", componentTypes);
        return "show-build";
    }

    @GetMapping("create-wish/{buildID}/{partType}")
    public String createWish(Model model, @PathVariable int buildID, @PathVariable String partType){
        UserBuildDTO build = service.getBuild(buildID);
        BuildPartDTO currentPart = build.getPart(partType);
        model.addAttribute("currentPart", currentPart);

        List<BuildPartDTO> allParts = service.getAllParts();
        model.addAttribute("allParts", allParts);

        BuildPartDTO wish = new BuildPartDTO();
        model.addAttribute("wish", wish);

        return "create-wish";
    }

    @PostMapping("create-wish/{buildID}/{partType}")
    public String wishCreated(@ModelAttribute ("wish") BuildPartDTO wish, @PathVariable ("buildID") int buildID, @PathVariable ("partType") String partType, Model model){
        UserBuildDTO build = service.getBuild(buildID);
        model.addAttribute("userID", build.getUserID());
        service.createWish(wish, build);
        return "wish-created";
    }

    @PostMapping("build/{buildID}")
    public String showBuild(@ModelAttribute("build") UserBuildDTO build, @PathVariable int buildID){
        service.updateBuild(build);
        return "build-updated";
    }
}
