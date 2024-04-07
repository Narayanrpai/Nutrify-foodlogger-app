package com.narayan.foodlogger.controllers;

import com.narayan.foodlogger.model.PasswordResetToken;
import com.narayan.foodlogger.model.User;
import com.narayan.foodlogger.services.PasswordService;
import com.narayan.foodlogger.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasswordResetController {

    private PasswordService passwordService;
    private UserService userService;

    public PasswordResetController(PasswordService passwordService, UserService userService) {
        this.passwordService = passwordService;
        this.userService = userService;
    }

    @PostMapping("/forgot_password")
    public String forgotPassword(@ModelAttribute("PasswordResetToken") PasswordResetToken token){
        passwordService.generateToken(token.getEmail());

        return "redirect:/home";
    }

    @GetMapping("/process/{token}")
    public String processForgotPassword(Model model, @PathVariable String token){
        User user = passwordService.processToken(token);
        model.addAttribute("user", user);

        return "changepassword.html";
    }

    @PostMapping("/update_password")
    public String updatePassword(@ModelAttribute User user){
        userService.updatePassword(user);

        return "redirect:/home";
    }

}
