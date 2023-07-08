package com.example.mscustomers.entity;

import com.example.mscustomers.dto.enumeration.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private Long id;
    private String fullName;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;

}
