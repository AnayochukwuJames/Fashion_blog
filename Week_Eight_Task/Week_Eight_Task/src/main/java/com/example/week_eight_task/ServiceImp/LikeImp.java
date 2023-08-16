package com.example.week_eight_task.ServiceImp;

import com.example.week_eight_task.DTOs.LikeDto;
import com.example.week_eight_task.Model.Like;
import com.example.week_eight_task.Repository.LikeRepository;
import com.example.week_eight_task.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeImp implements LikeService{
    private LikeRepository likeRepository;
    @Autowired
    public LikeImp(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like addLike(LikeDto likeDto) {
        Like like = new Like();
        return likeRepository.save(like);
    }

    @Override
    public Like removeLike(Long likeId) {
        likeRepository.deleteById(likeId);
        return null;
    }
}
