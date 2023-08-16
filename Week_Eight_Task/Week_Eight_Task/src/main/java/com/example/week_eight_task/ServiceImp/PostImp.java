package com.example.week_eight_task.ServiceImp;

import com.example.week_eight_task.DTOs.PostDto;
import com.example.week_eight_task.Exception.InternalServerErrorException;
import com.example.week_eight_task.Exception.ResourceNotFoundException;
import com.example.week_eight_task.Model.Post;
import com.example.week_eight_task.Model.User;
import com.example.week_eight_task.Repository.PostRepository;
import com.example.week_eight_task.Repository.UserRepository;
import com.example.week_eight_task.Service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostImp implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
@Autowired
    public PostImp(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPost(PostDto postRequest) {
        User user = userRepository.findById(postRequest.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + postRequest.getUser().getId()));

        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setUser(user);
        post.setId(post.getId());

        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post not found "+ postId));
        postRepository.delete(post);
    }

    @Override
    @Transactional
    public Post updatePost(Long postId, Post postRequest) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Content not found "+ postId));
        User user = userRepository.findById(postRequest.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + postRequest.getUser().getId()));
        post.setContent(postRequest.getContent());
        user.setId(user.getId());

        return postRepository.save(post);
    }

    @Override
    public Post findPostById(long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new InternalServerErrorException("User not found with ID: " + postId));
    }
}
