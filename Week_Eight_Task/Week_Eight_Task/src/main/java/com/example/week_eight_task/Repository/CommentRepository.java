package com.example.week_eight_task.Repository;

import com.example.week_eight_task.Model.Comment;
import com.example.week_eight_task.Model.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
    @EntityGraph(attributePaths = "post")
    Optional<Comment> findCommentById(Long id);
}
