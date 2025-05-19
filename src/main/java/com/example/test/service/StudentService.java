package com.example.test.service;

import java.util.List;

import com.example.test.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);
	Student getById(long id);

	void deleteById(long id);
	
}
