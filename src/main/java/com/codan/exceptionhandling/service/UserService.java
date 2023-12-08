package com.codan.exceptionhandling.service;

import com.codan.exceptionhandling.Dto.UserRequest;
import com.codan.exceptionhandling.entity.User;
import com.codan.exceptionhandling.exception.UserNotFoundException;
import com.codan.exceptionhandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(@RequestBody UserRequest userRequest) {
        User user
                = User.build(0, userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("user not found with id : " + id);
        }
    }
}
