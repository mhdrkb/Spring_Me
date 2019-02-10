package com.mhd.webmvcwiththymeleaf2.repository;

import com.mhd.webmvcwiththymeleaf2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<User, Long> {
}
