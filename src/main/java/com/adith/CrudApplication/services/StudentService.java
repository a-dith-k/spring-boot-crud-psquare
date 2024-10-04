package com.adith.CrudApplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adith.CrudApplication.dtos.StudentRequestDto;
import com.adith.CrudApplication.dtos.StudentResponse;
import com.adith.CrudApplication.exceptions.MailSendFailedException;

@Service
public interface StudentService {
	
	List<StudentResponse> getAllStudents();
	
	StudentResponse getStudent(Integer studentId);
	
	void updateStudent(StudentRequestDto updateRequest,Integer studentId);
	
	void deleteStudent(Integer studentId);

	void createStudent(StudentRequestDto request) throws MailSendFailedException;

	StudentRequestDto getExistingStudentRequest(Integer studentId);

}
