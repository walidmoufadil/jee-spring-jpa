package com.enset.sdia.service;

import com.enset.sdia.entity.Role;
import com.enset.sdia.entity.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    Role addRole(Role role);
    List<User> getAllUsers();
    User getUser(String id);
    void deleteUser(String id);
    void addRoleToUser(String username, String rolename);
    Role findRoleByRolename(String rolename);
    User authenticate(String username, String password);
}
