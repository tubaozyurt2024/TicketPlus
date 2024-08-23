package com.patika.ticketplusservice.converter;

import com.patika.ticketplusservice.model.User;
import com.patika.ticketplusservice.request.UserRequest;
import com.patika.ticketplusservice.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {


   // private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .role(user.getRole())
                .email(user.getEmail())
                .userType(user.getUserType())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public User convert(UserRequest userRequest) {
        return User.builder()
                .userType(userRequest.getUserType())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
              //  .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole())
                .build();
    }

    public List<UserResponse> convert(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        users.stream().forEach(user -> userResponses.add(convert(user)));
        return userResponses;
    }
}
