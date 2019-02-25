package com.mhd.springdifferentlayers.service;

import com.mhd.springdifferentlayers.dto.StudentDTO;
import com.mhd.springdifferentlayers.entity.Student;

import java.util.List;

public interface StudentService {
    void saveOrUpdate(StudentDTO studentDTO);
    void deleteById(Long id);
    Student findById(Long id);
    Student findByEmailAddress(String email);

    List<StudentDTO> getAll();
    long countNoOfStudent(String email);
}
