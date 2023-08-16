package com.example.week_eight_task.ServiceImp;

import com.example.week_eight_task.DTOs.CommentDto;
import com.example.week_eight_task.Exception.ResourceNotFoundException;
import com.example.week_eight_task.Model.Comment;
import com.example.week_eight_task.Model.Post;
import com.example.week_eight_task.Model.User;
import com.example.week_eight_task.Repository.CommentRepository;
import com.example.week_eight_task.Repository.PostRepository;
import com.example.week_eight_task.Service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentImp implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
@Autowired
    public CommentImp(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @Transactional
    @Override
    public Comment createComment(Long postId, Comment commentRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with ID: " + postId));
        User user = commentRequest.getUser();
        if (user == null) {
            throw new IllegalArgumentException("User information is required.");
        }
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }
    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Comment findCommentById(long commentId) {
        return commentRepository.findCommentById(commentId).orElse(null);
    }
}
