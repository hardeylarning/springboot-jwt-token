package com.rocktecj.springbootjwtdemo.repo;

import com.rocktecj.springbootjwtdemo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
