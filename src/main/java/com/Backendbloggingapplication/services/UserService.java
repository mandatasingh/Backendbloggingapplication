package com.Backendbloggingapplication.services;

import com.Backendbloggingapplication.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user,Integer id);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);
    void getUserByEmail(String email);

}
