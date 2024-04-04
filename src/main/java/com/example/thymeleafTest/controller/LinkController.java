package com.example.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {
    @GetMapping("/mylink/link")
    public String linkTest(Model model) {
        model.addAttribute("name", "장원영");
        model.addAttribute("age", 21);
        return "/link/linkView";
    }

    @GetMapping("hello")
    public String helloPage() {
        return "/link/hello_page";
    }
}

