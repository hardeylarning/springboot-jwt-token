package com.rocktecj.springbootjwtdemo.repo;

import com.rocktecj.springbootjwtdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
