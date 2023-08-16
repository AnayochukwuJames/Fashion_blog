package com.example.week_eight_task.Repository;

import com.example.week_eight_task.Model.Like;
import com.example.week_eight_task.Model.Post;
import com.example.week_eight_task.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
    List<Like> findByPost(Post post);
    Like findByUserAndPost(User user, Post post);
}
