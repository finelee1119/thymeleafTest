package com.example.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LinkTestController {
    @GetMapping("/main")
    public String linkTest() {
        return "/articles/main"; // 뷰 이름인 "main"을 반환하면 스프링 부트는 해당 뷰 파일(html)을 찾아서 반환합니다.
    }

    @GetMapping("/articles/list")
    public String listAll() {
        return "/articles/list_all";
    }

    @GetMapping("/articles/{id}")
    public String listOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "/articles/list_one";
    }

    @GetMapping("/articles/create")
    public String newInfo(@RequestParam("name") String name,
                          @RequestParam("weight") int weight,
                          @RequestParam("height") int height,
                          Model model) {
        model.addAttribute("name", name);
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        return "/articles/new";
    }

    @GetMapping("/articles/update")
    public String updateOk() {
        return "/articles/update_ok";
    }

    @GetMapping("/articles/{id}/update")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "/articles/update";
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "/articles/delete";
    }

    @GetMapping("/articles/{id}/articleComment")
    public String commentView(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "/articles/comment_view";
    }

    @GetMapping("/articles/{id}/articleComment/{commentId}/delete")
    public String commentDelete(@PathVariable("id") int id, @PathVariable("commentId") int commentId, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("commentId", commentId);
        return "/articles/comment_delete";
    }
}
