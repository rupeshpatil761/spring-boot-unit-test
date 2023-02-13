package com.rupesh.springboot.unittest.repository;

import com.rupesh.springboot.unittest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
