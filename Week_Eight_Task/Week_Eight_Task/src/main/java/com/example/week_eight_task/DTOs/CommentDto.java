package com.example.week_eight_task.DTOs;

import com.example.week_eight_task.Model.Post;
import com.example.week_eight_task.Model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private long id;
    private String content;
    private User user;
    private Post post;
}
