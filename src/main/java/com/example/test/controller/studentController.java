package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.test.entity.Student;
import com.example.test.service.StudentService;

@Controller
public class studentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("students", student);
		return "create_student";
	}

	@PostMapping("/studentss")
	public String saveStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable long id, Model model) {
		model.addAttribute("std", studentService.getById(id));
		return "update_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable long id, @ModelAttribute Student student, Model model) {
		Student existStd = studentService.getById(id);
		existStd.setId(student.getId());
		existStd.setFirstName(student.getFirstName());
		existStd.setLastName(student.getLastName());
		existStd.setEmail(student.getEmail());
		studentService.saveStudent(existStd);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteById(id);
		return "redirect:/students";

	}
}
