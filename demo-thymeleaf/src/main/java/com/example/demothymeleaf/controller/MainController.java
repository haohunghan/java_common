package com.example.demothymeleaf.controller;


import com.example.demothymeleaf.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/test")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("message", "message");

        modelAndView.setViewName("prefectureTop");

        return modelAndView;
    }
}
