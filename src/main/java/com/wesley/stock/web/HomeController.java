package com.wesley.stock.web;

import com.wesley.stock.config.auth.LoginUser;
import com.wesley.stock.config.auth.dto.SessionUser;
import com.wesley.stock.service.posts.PostsService;
import com.wesley.stock.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String home(Model model, @LoginUser SessionUser user) {
//        model.addAttribute("posts", postsService.findAll());
//
//        if (user != null) {
//            model.addAttribute("userName", user.getName());
//        }

        log.info("home controller");
        return "home";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
