package com.example.week_eight_task.Service;

import com.example.week_eight_task.DTOs.CommentDto;
import com.example.week_eight_task.Model.Comment;
import jakarta.transaction.Transactional;

public interface CommentService {
    @Transactional
    Comment createComment(Long postId, Comment commentRequest);

//    Comment createComment(Long postId, CommentDto commentRequest);
    void deleteComment(Long commentId);
    Comment findCommentById(long commentId);
}
