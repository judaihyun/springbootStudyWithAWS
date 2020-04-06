package com.first.springboot.web;

import com.first.springboot.domain.posts.Posts;
import com.first.springboot.domain.posts.PostsRepository;
import com.first.springboot.service.posts.PostsService;
import com.first.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,
                              Model model){
        PostsResponseDto dto = postsService.findById(id);
        System.out.println("id : " + id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
