package com.example.mscustomers.dto.request;

import com.example.mscustomers.annotation.ValidPassword;
import com.example.mscustomers.dto.enumeration.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

        @NotEmpty(message = "The full name should not be empty!")
        private String firstName;
        @NotEmpty(message = "The full name should not be empty!")
        private String lastName;

        @NotEmpty(message = "The phone number should not be empty!")
        @Pattern(regexp="\\+\\d{12}", message="Telefon nömrəsi düzgün deyil!")
        private String phone;

        @NotNull(message = "Gender is required")
        private Gender gender;

        @NotNull(message = "Date of birth must not be null")
        @Past(message = "Date of birth must be in the past")
        private LocalDate birthDate;
}
