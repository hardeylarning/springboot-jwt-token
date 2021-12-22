package com.rocktecj.springbootjwtdemo.service;

import com.rocktecj.springbootjwtdemo.domain.Role;
import com.rocktecj.springbootjwtdemo.domain.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);

    Role saveRole (Role role);

    void addRoleToUser (String username, String roleName);

    User getUser (String username);

    List<User> getUsers();
}
