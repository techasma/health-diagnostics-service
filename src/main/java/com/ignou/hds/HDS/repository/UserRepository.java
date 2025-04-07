package com.ignou.hds.HDS.repository;

import com.ignou.hds.HDS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom method to find a user by email
    Optional<User> findByEmail(String email);

    // Custom method to check if an email already exists
    boolean existsByEmail(String email);

}