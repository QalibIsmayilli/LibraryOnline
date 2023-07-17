package com.company.library.repository;

import com.company.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> , JpaSpecificationExecutor<User> {
    Optional<User> findUserByUsername(String username);
}
