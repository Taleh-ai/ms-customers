package com.example.mscustomers.entity;

import com.example.mscustomers.dto.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    private String email;

    private String phoneNumber;

    @CreationTimestamp
    private Date creation_date;

    @UpdateTimestamp
    private Date update_date;

    String password;
    
    private  String role;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartEntity> cartEntity;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderEntity> ordersEntity;

}
