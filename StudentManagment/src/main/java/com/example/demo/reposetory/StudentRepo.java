package com.example.demo.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
