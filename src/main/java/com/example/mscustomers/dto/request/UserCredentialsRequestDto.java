package com.example.mscustomers.dto.request;

import com.example.mscustomers.annotation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCredentialsRequestDto {
    @NotEmpty(message = "The email should not be empty!")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotEmpty(message = "The password should not be empty!")
    @Size(min = 8,message = "The password must be at least 8 digits")
    @ValidPassword
    private String password;

}
