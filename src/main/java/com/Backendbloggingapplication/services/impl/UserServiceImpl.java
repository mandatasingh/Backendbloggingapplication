package com.Backendbloggingapplication.services.impl;

import com.Backendbloggingapplication.entities.User;
import com.Backendbloggingapplication.exceptions.ResourceNotFoundException;
import com.Backendbloggingapplication.payloads.UserDto;
import com.Backendbloggingapplication.repositories.UserRepository;
import com.Backendbloggingapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) {
        User user1=this.dtoToUser(user);
        User savedUser=this.userRepository.save(user1);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer id) {
        User user1=this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        user1.setPasswords(user.getPasswords());
        User updatedUser=this.userRepository.save(user1);
        UserDto userDto=this.userToDto(updatedUser);
        return userDto;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=this.userRepository.findAll();
        List<UserDto> userDtos=users.stream().map(this::userToDto).toList();
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
       User user= this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        this.userRepository.delete(user);
    }
    @Override
    public void getUserByEmail(String email){
//        User user=this.userRepository.
    }

    private User dtoToUser(UserDto user){
        User user1=new User();
        user1.setUserID(user.getUserID());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        user1.setPasswords(user.getPasswords());

        return user1;
    }

    public UserDto userToDto(User user)
    {
       UserDto userDto=new UserDto();
       userDto.setUserID(user.getUserID());
       userDto.setName(user.getName());
       userDto.setEmail(user.getEmail());
       userDto.setAbout(user.getAbout());
       userDto.setPasswords(user.getPasswords());

        return userDto;
    }
}
