package com.example.project2.modle;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
public class LoginForm {

    @NotEmpty(message = "username can't be empty")
    @Size(min = 3,max = 10,message = "username must be more than 3 char and less than 10 char")
    private String username;
    @NotEmpty(message = "password can't be empty")
    @Size(min = 6,max = 15,message = "password must be more than 6 char and less than 15 char")
    private String password;
}
