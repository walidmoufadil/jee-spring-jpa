package com.enset.sdia.service.Impl;

import com.enset.sdia.entity.Role;
import com.enset.sdia.entity.User;
import com.enset.sdia.repository.IRoleRepo;
import com.enset.sdia.repository.IUserRepo;
import com.enset.sdia.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class IUserServiceImpl implements IUserService {
    private IUserRepo iUserRepo;
    private IRoleRepo iRoleRepo;

    @Override
    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return iUserRepo.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return iRoleRepo.save(role);
    }

    @Override
    public List<User> getAllUsers() {
        return iUserRepo.findAll();
    }

    @Override
    public User getUser(String id) {
        return iUserRepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    @Override
    public void deleteUser(String id) {
        iUserRepo.deleteById(id);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = iUserRepo.findByUsername(username);
        Role role = iRoleRepo.findByRolename(rolename);
        if(user.getRoles() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public Role findRoleByRolename(String rolename) {
        return iRoleRepo.findByRolename(rolename);
    }

    @Override
    public User authenticate(String username, String password) {
        User user = iUserRepo.findByUsername(username);
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Credentials");
    }
}
