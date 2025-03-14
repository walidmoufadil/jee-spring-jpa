package com.enset.sdia.repository;

import com.enset.sdia.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Long> {
    public Role findByRolename(String roleName);
}
