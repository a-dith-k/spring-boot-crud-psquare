package com.adith.CrudApplication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.adith.CrudApplication.entities.Student;
@Repository
public interface StudentRepository {
	
	List<Student>getAllStudents();

	void deleteStudent(Integer studentId);

	void createStudent(Student student);

	Student getStudent(Integer studentId);

	void updateStudent(Student student);

	Optional<Student> getStudentByUsername(String username);

	

}
