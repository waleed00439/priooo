package com.example.project2.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class User {

    @NotEmpty(message = "ID must not be empty")
    @Length(min = 3, max = 3, message = "ID have to be 3 character long")
    private String ID;
    @NotEmpty(message = "username must not be empty")
    @Length(min = 5, max = 5, message = "username have to be 5 character long")
    private String username;
    @NotEmpty(message = "password must not be empty")
    @Pattern(regexp = "AzAzz1212", message = "please enter strong password")
    private String password;
    @NotEmpty(message = "email can't be empty")
    @Email(message = "Please enter a valid email")
    private String email;
    @NotEmpty(message = "role can't be empty")
    @Pattern(regexp = "(Admin|Customer)", message = "Role must be in admin or Customer only")
    private String role;
    private int balance;
}
