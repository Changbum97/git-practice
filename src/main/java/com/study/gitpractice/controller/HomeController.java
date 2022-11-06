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

        List<String> operations = new ArrayList<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        model.addAttribute("operations", operations);

        return "home";
    }

    @PostMapping("/")
    public String add(@ModelAttribute Numbers numbers, Model model) {

        if(numbers.getOp().equals("+")) {
            numbers.setAnswer(numbers.getX() + numbers.getY());
        } else if(numbers.getOp().equals("-")) {
            numbers.setAnswer(numbers.getX() - numbers.getY());
        } else if(numbers.getOp().equals("*")) {
            numbers.setAnswer(numbers.getX() * numbers.getY());
        } else {
            numbers.setAnswer(numbers.getX() / numbers.getY());
        }

        histories.add(numbers);
        model.addAttribute("numbers", numbers);
        model.addAttribute("histories", histories);

        List<String> operations = new ArrayList<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        model.addAttribute("operations", operations);

        return "home";
    }
}
