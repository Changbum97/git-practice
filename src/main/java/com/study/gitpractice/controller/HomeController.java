package com.study.gitpractice.controller;

import com.study.gitpractice.domain.Numbers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<Numbers> histories = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("numbers", new Numbers());
        return "home";
    }

    @PostMapping("/")
    public String add(@ModelAttribute Numbers numbers, Model model) {
        numbers.setAnswer(numbers.getX() + numbers.getY());
        histories.add(numbers);
        model.addAttribute("numbers", numbers);
        model.addAttribute("histories", histories);
        return "home";
    }

    @GetMapping("/clear-history")
    public String clearHistories(Model model) {
        histories.clear();
        model.addAttribute("numbers", new Numbers());
        return "redirect:/";
    }
}
