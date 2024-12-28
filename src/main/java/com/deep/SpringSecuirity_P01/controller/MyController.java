package com.deep.SpringSecuirity_P01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Controller
//@RequestMapping("/api")
public class MyController {

    @GetMapping("/updates")
    public String updates() {
        return "Updates are publicly accessible";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Contact are publicly accessible";
    }
}
