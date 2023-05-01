package com.github.javamultiplex.controller;

import com.github.javamultiplex.entity.Post;
import com.github.javamultiplex.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rohit Agarwal on 01/05/23 9:51 pm
 * @copyright github.com/javamultiplex
 */
@RestController
@RequestMapping("/api/v1")
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
