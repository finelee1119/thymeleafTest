package com.example.thymeleafTest.controller;

import com.example.thymeleafTest.vo.FormDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("dto", new FormDto());
        //modelHobbies(model);
        return "/form-test/form";
    }

    private void modelHobbies(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("game", "게임하기");
        map.put("running", "러닝하기");
        model.addAttribute("hobbies", map);
    }

    @PostMapping("/form")
    public String postForm(@ModelAttribute("dto") FormDto dto) {
        log.info("======== formDto.name = " + dto.getName());
        log.info("======== formDto.trueOrFalse = " + dto.isTrueOrFalse());
        List<String> hobbies = dto.getHobbies();
        for (String hobby : hobbies) {
            log.info("dto.hobby = " + hobby);
        }
        return "/form-test/form";
    }

    @ModelAttribute("hobbies")
    private Map<String, String> favorite() {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("game", "게임하기");
        map.put("running", "러닝하기");
        return map;
    }
}
