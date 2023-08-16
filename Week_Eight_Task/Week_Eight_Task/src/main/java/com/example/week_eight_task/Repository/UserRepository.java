package com.example.week_eight_task.Repository;

import com.example.week_eight_task.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findFirstByEmail(String email);

    Optional<User> findById(Long userId);

}
