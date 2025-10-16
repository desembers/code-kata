package com.example.investing.domain.user.repository;

import com.example.investing.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> existsByEmail(String email);
    List<Users> findByEmail(String email);
}
