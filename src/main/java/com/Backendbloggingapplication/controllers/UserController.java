package com.Backendbloggingapplication.controllers;

import com.Backendbloggingapplication.payloads.ApiResponse;
import com.Backendbloggingapplication.payloads.UserDto;
import com.Backendbloggingapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser=this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }
    @PutMapping("/updateUser/{userID}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("/updateUser/{userID}") Integer uid){
      UserDto updatedUser=  this.userService.updateUser(userDto,uid);
      return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{userID}")
    public ResponseEntity<ApiResponse> deletedUser(@PathVariable("userId")Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",true),HttpStatus.OK );


    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(UserDto userDto){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(UserDto userDto,@PathVariable("userId") Integer userID){
        return ResponseEntity.ok(this.userService.getUserById(userID));
    }
}
