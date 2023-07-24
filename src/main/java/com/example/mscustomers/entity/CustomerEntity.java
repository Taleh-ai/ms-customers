package com.example.mscustomers.entity;

import com.example.mscustomers.dto.enumeration.Gender;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

    String password;
    
    private  String role;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartEntity> cartEntity;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderEntity> ordersEntity;


}
