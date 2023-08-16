package com.example.week_eight_task.Service;

import com.example.week_eight_task.DTOs.LoginDto;
import com.example.week_eight_task.DTOs.UserDto;
import com.example.week_eight_task.Model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User createUser(UserDto userDto);
//    User deleteUser(Long userId);
    User findUserById(Long userId);

    void deleteById(Long userId);
    User updateUser(Long userId, User updatedUser);

    ResponseEntity<String> loginUser(LoginDto loginDto);
}
