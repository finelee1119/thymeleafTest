package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data","Hello <b>Spring!</b>");
        return "/basic/text-basic";
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        // 1
        Users userA = new Users("장원영", 21);
        Users userB = new Users("안유진", 22);

        // 2-1
        List<Users> list = new ArrayList<>(Arrays.asList(userA, userB));

        // 2-2
        Map<String, Users> map = new HashMap<>();
        map.put("jang", userA);
        map.put("ahn", userB);

        // 3
        model.addAttribute("userJang",userA);
        model.addAttribute("userList",list);
        model.addAttribute("userMap",map);

        // 4
        return "basic/variable";
    }

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localTime", LocalDateTime.now());
        return "date";
    }
}
