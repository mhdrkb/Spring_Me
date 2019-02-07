package com.mhd.webmvcwiththymleaf.repository;

import com.mhd.webmvcwiththymleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //to declare this as bean. for repository ofcourse ose Repository annotation , Service annotation for service bean
public interface UserRepo extends JpaRepository<User, Long> {
}
