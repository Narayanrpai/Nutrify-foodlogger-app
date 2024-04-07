package com.narayan.foodlogger.controllers;

import com.narayan.foodlogger.model.NutritionixBaseProduct;
import com.narayan.foodlogger.model.PasswordResetToken;
import com.narayan.foodlogger.model.User;
import com.narayan.foodlogger.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("PasswordResetToken", new PasswordResetToken());

        return "login.html";
    }

    @GetMapping({"/", "/home", "/homepage"})
    public String homepage(Model model){
        User user = userService.getCurrentUser();
        if (user == null){
            model.addAttribute("isAuthenticated", false);
        }else{
            model.addAttribute("isAuthenticated", true);
        }

        return "index.html";
    }

    @GetMapping("/nutritionix")
    public String searchNutritionix(Model model){
        model.addAttribute("NutritionixBaseProduct", new NutritionixBaseProduct());

        return "nutritionix.html";
    }

}
