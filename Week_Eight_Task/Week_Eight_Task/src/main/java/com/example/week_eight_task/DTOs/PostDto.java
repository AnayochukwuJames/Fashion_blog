package com.example.week_eight_task.DTOs;

import com.example.week_eight_task.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PostDto {
    private long id;
    private String content;
    private User user;
    private PostDto post;
}
