package com.example.week_eight_task.Controller;

import com.example.week_eight_task.DTOs.LikeDto;
import com.example.week_eight_task.Model.Like;
import com.example.week_eight_task.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes/")
public class LikeController {
    private LikeService likeService;
@Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @PostMapping("/like")
    public ResponseEntity<Like> addLike(@RequestBody LikeDto likeDto){
    Like addedLike = likeService.addLike(likeDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(addedLike);
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> removeLike(@PathVariable Long likeId){
    likeService.removeLike(likeId);
    return ResponseEntity.noContent().build();
    }
}
