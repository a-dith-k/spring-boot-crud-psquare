package com.adith.CrudApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adith.CrudApplication.dtos.StudentRequestDto;
import com.adith.CrudApplication.exceptions.MailSendFailedException;
import com.adith.CrudApplication.repositories.StreamRepository;
import com.adith.CrudApplication.services.StudentService;

@Controller
@RequestMapping("students")
public class StudentController {
	
	private final StudentService studentService;
	private final StreamRepository repository;
	
	
	public StudentController(StudentService studentService, StreamRepository repository) {
		this.studentService = studentService;
		this.repository = repository;
	}
	//create
	@GetMapping("/create")
	public String createStudentPage(Model model) {
		model.addAttribute("student",new StudentRequestDto());
		model.addAttribute("streams",repository.getAllStreams());
		return "studentpages/create";
	}
	
	 @PostMapping("/create")
	 public String createUser(@ModelAttribute("student") StudentRequestDto request) throws MailSendFailedException {
		 studentService.createStudent(request);
		 return "redirect:/students";
	 }

	@GetMapping("")
	public String getAllStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "studentpages/students";
	}
	
	@GetMapping("/{studentId}")
	public String getStudentById(@PathVariable("studentId") Integer studentId,Model model) {
		model.addAttribute("student",studentService.getStudent(studentId));
		
		return "studentpages/student";
	}

	@GetMapping("/update/{studentId}")
	public String updateStudentPage(@PathVariable("studentId") Integer studentId,Model model) {
		
		model.addAttribute("student",studentService.getExistingStudentRequest(studentId));
		model.addAttribute("streams",repository.getAllStreams());
		return "studentpages/updatePage";
	}
	
	@PostMapping("/update/{studentId}")
	public String updateStudent(@ModelAttribute("student") StudentRequestDto request,@PathVariable("studentId") Integer studentId) {
		studentService.updateStudent(request,studentId);
		return "redirect:/students"; 	 	
	}
	
	@PostMapping("/delete/{studentId}")
	public String deleteStudentById(@PathVariable("studentId")Integer studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/students";
	}
	
	
}
