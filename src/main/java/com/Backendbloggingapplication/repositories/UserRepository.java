package com.Backendbloggingapplication.repositories;

import com.Backendbloggingapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
