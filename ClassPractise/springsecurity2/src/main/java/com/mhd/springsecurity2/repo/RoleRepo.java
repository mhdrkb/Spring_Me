package com.mhd.springsecurity2.repo;

import com.mhd.springsecurity2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role , Long> {
    Role findByRoleName(String roleName);
}
