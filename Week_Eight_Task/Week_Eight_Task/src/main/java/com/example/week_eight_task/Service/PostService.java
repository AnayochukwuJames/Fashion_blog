package com.example.week_eight_task.Service;

import com.example.week_eight_task.DTOs.PostDto;
import com.example.week_eight_task.Model.Post;

public interface PostService {
//    Post createPost(PostDto postRequest);

   Post createPost(PostDto postRequest);
   void deletePost(Long postId);
   Post updatePost(Long postId, Post postRequest);

    Post findPostById(long postId);
}
