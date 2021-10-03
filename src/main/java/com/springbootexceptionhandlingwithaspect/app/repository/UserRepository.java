package com.springbootexceptionhandlingwithaspect.app.repository;

import com.springbootexceptionhandlingwithaspect.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
