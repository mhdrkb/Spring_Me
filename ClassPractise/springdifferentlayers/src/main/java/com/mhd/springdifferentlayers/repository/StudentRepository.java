package com.mhd.springdifferentlayers.repository;

import com.mhd.springdifferentlayers.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
    long countAllByEmail(String email);

}
