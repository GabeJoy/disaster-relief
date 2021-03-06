package com.example.demo.Security;

import com.example.demo.Models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsername(String userName);
}
