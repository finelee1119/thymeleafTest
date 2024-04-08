package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.Members;
import com.example.thymeleafTest.vo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!!");
        model.addAttribute("nulldata", null);
        model.addAttribute("name", "안유진");
        return "literal";
    }

    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "each";
    }

    @GetMapping("/member")
    public String member(Model model) {
        createMembers(model);
        return "member";
    }

    private void addUsers(Model model) {
        List<Users> userList = new ArrayList<>(
                Arrays.asList(
                        new Users("안유진", 22),
                        new Users("장원영", 21),
                        new Users("이서", 18),
                        new Users("가을", 23),
                        new Users("리즈", 21),
                        new Users("레이", 21)
                )
        );
        model.addAttribute("users", userList);

        for (Users item : userList) {

        }
    }

    private void createMembers(Model model) {
        List<Members> membersList = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            if (i < 10) {
                membersList.add(new Members(i, "Name_0" + i, "addr_0" + i, LocalDateTime.now()));
            } else {
                membersList.add(new Members(i, "Name_" + i, "addr_" + i, LocalDateTime.now()));
            }
        }

        model.addAttribute("members", membersList);
    }

}
