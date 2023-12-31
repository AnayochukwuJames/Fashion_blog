package com.example.week_eight_task.ServiceImp;

import com.example.week_eight_task.DTOs.UserDto;
import com.example.week_eight_task.Exception.ResourceNotFoundException;
import com.example.week_eight_task.Model.Category;
import com.example.week_eight_task.Model.User;
import com.example.week_eight_task.Repository.UserRepository;
import com.example.week_eight_task.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        Category category = Category.valueOf(userDto.getCategory());
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setCategory(category);
        return userRepository.save(user);
    }
    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
    }
    public void deleteById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found "+ userId));
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setCategory(updatedUser.getCategory());

        return userRepository.save(existingUser);
    }
}
