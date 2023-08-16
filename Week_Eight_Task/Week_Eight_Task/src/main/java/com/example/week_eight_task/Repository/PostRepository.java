package com.example.week_eight_task.Repository;

import com.example.week_eight_task.Model.Post;
import com.example.week_eight_task.Model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

    @EntityGraph(attributePaths = "user")
  static Optional<Post> findPostById(Long id) {
        return Optional.empty();
    }
}

