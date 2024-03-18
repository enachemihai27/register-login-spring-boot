package com.example.registerlogin.service;

import com.example.registerlogin.dto.UserDto;
import com.example.registerlogin.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto) throws Exception;

    User findByEmail(String email);

    List<UserDto> findAllUsers();

    void setActiveUser(String email) throws Exception;
}
