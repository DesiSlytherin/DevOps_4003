package com.afrah.example.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


import com.afrah.example.service.logInService;
import com.afrah.example.domain.logIn;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LogInController {
 
    @Autowired
    private logInService service;
 
    @GetMapping("/")
    public String api()
    {
 
        return "login";
    }
 
    @GetMapping("/reg")
    public String apu() {
        return "reg";
    }
    
    @PostMapping("/log")
    public String login(@ModelAttribute("user") logIn user) {
 
        logIn oauthUser = service.log(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }
 
    @PostMapping("/register")
    public String register(@ModelAttribute("user") logIn user) {
 
        logIn oauthUser = service.register(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/";
        } else {
            return "redirect:/reg";
        }
    }
    
    @GetMapping("/display")
    public String display() {
        return "display";
    }
}
