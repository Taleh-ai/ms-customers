package com.example.mscustomers.dto.request;

import com.example.mscustomers.annotation.ValidPassword;
import com.example.mscustomers.dto.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

        @NotEmpty(message = "The first name should not be empty!")
        private String firstName;
        @NotEmpty(message = "The last name should not be empty!")
        private String lastName;

        @NotEmpty(message = "The phone number should not be empty!")
        @Pattern(regexp="\\+\\d{12}", message="Invalid number format!")
        private String phone;

        @NotNull(message = "Gender is required")
        private Gender gender;

        @NotNull(message = "Date of birth must not be null")
        @Past(message = "Date of birth must be in the past")
        private LocalDate birthDate;

        @NotEmpty(message = "The email should not be empty!")
        @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
        private String email;

        @NotEmpty(message = "The password should not be empty!")
        @Size(min = 8,message = "The password must be at least 8 digits")
        @ValidPassword
        private String password;

        private  String role;
}
