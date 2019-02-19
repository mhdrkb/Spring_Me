package com.mhd.springsecurity2.repo;

import com.mhd.springsecurity2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findByUserNameOrEmail(String userName, String email);//so you can login with email or username or if you nmobile number so.

    User findByUserName(String username);
}
