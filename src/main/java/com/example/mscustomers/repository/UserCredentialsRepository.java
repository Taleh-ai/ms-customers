package com.example.mscustomers.repository;

import com.example.mscustomers.entity.UserCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, Long> {
    UserCredentialsEntity findUserCredentialsEntitiesByEmail(String email);
}
