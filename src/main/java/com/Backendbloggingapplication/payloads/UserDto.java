package com.Backendbloggingapplication.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userID;
    private String name;
    private String email;
    private String passwords;
    private String about;
}
