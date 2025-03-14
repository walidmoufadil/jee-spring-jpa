package com.enset.sdia.repository;

import com.enset.sdia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepo extends JpaRepository<User, String> {
    public User findByUsername(String username);
}
