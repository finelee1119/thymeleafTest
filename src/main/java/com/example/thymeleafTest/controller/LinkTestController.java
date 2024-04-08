package com.example.thymeleafTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class LinkTestController {
    @GetMapping("/main")
    public String main() {
        return "/articles/main";
        // 뷰 이름인 "main"을 반환하면 스프링 부트는 해당 뷰 파일(html)을 찾아서 반환합니다.
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        String title = "/articls/list";
        String message = "전체 게시글 읽기 성공";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/list_all";
    }

    @GetMapping("/{id}")
    public String listOne(@PathVariable("id") int id, Model model) {
        String title = "/articls/{" + id + "}";
        String message = id + "번 게시글 읽기 성공";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/list_one";
    }

    @GetMapping("/create")
    public String newInfo(@RequestParam("name") String name,
                          @RequestParam("height") int height,
                          @RequestParam("weight") int weight, Model model) {
        String title = "/articls/create?name="+name+"&height="+height+"&weight"+weight;
        String message = name+"의 키는 "+height+", 몸무게는 "+weight+"입니다.";

        model.addAttribute("title", title);
        model.addAttribute("message", message);
        return "/articles/new";
    }


//
    @GetMapping("/update")
    public String update(Model model) {
        String title = "/articls/";
        String message = "번 게시글 읽기 성공";

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
