package com.example.week_eight_task.Service;

import com.example.week_eight_task.DTOs.LikeDto;
import com.example.week_eight_task.Model.Like;

public interface LikeService {
    Like addLike(LikeDto likeDto);
    Like removeLike(Long likeId);
}
