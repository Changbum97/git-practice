package com.study.gitpractice.controller;

import com.study.gitpractice.domain.Numbers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("numbers", new Numbers());
        return "home";
    }
}
