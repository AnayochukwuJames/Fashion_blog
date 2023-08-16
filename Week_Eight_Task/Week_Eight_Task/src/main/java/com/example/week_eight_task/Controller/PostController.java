package com.example.week_eight_task.Controller;

import com.example.week_eight_task.DTOs.PostDto;
import com.example.week_eight_task.Exception.ResourceNotFoundException;
import com.example.week_eight_task.Model.Post;
import com.example.week_eight_task.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createPost(@RequestBody PostDto post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body("Post created successfully with ID: " + createdPost.getId());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getPost(@PathVariable Long userId) {
        Post postDto = postService.findPostById(userId);
        if (postDto != null) {
            return ResponseEntity.ok().body("Post retrieved successfully for user ID: " + userId + "\n" + postDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok().body("Post Successfully deleted: " + "postId " + postId);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost) {
        Post updated = postService.updatePost(postId, updatedPost);
        return ResponseEntity.ok("Post updated successfully with ID: " + updated.getId());
    }
}

