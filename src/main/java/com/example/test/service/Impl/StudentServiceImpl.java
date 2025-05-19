package com.example.test.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.entity.Student;
import com.example.test.repo.StudentRepo;
import com.example.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getById(long id) {
		return studentRepo.findById(id).get();

	}

	@Override
	public void deleteById(long id) {
		studentRepo.deleteById(id);
	}

}
