package com.example.demothymeleaf.controller;


import com.example.demothymeleaf.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private static final List<Category> categories = new ArrayList<>();
    static {
        categories.add(new Category("Business", "/business"));
        categories.add(new Category("Tech", "/tech"));
    }

    @GetMapping("/new/mansion/{lc}/{pf}/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("message", "message");

        modelAndView.setViewName("prefectureTop");

        return modelAndView;
    }
}
