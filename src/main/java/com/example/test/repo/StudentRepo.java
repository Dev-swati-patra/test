package com.example.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
