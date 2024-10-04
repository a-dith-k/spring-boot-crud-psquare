package com.adith.CrudApplication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.adith.CrudApplication.dtos.StudentRequestDto;
import com.adith.CrudApplication.dtos.StudentResponse;
import com.adith.CrudApplication.entities.Student;
import com.adith.CrudApplication.exceptions.MailSendFailedException;
import com.adith.CrudApplication.repositories.StreamRepository;
import com.adith.CrudApplication.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final  StudentRepository studentRepository;
	private final 	StreamRepository streamRepository;
	private final 	EmailService emailService;

	public StudentServiceImpl(StudentRepository studentRepository, StreamRepository streamRepository, EmailService emailService) {
		this.studentRepository = studentRepository;
		this.streamRepository = streamRepository;
		this.emailService = emailService;
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		List<Student>students=studentRepository.getAllStudents();
		List<StudentResponse> response= new ArrayList<>();
		students.forEach(student->{
			response.add(new StudentResponse(student.getId(), student.getUsername(),student.getFirstName(),student.getLastName(),student.getGender() ,streamRepository.getStreamById(student.getStreamId()), student.getClassRoom()));
		});
		return response;
	}

	@Override
	public StudentResponse getStudent(Integer studentId) {
		return new StudentResponse(1,"user1","Adith", "K","male","A", "B");
	}

	@Override
	public void updateStudent(StudentRequestDto updateRequest,Integer studentId) {
		
		Student student=new Student(studentId,updateRequest.getUsername(),updateRequest.getFirstName(),updateRequest.getLastName(),updateRequest.getGender(),updateRequest.getStreamId(),updateRequest.getClassRoom());
		studentRepository.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(Integer studentId) {
		studentRepository.deleteStudent(studentId);
		
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void createStudent(StudentRequestDto request) throws MailSendFailedException {
		Student student=new Student(request.getUsername(),request.getFirstName(),request.getLastName(),request.getGender(),request.getStreamId(),request.getClassRoom());
		studentRepository.createStudent(student);
		System.out.println("Stored in DAtabase	");
		System.out.println(studentRepository.getStudentByUsername(request.getUsername()));
		emailService.sendSimpleEmail(request.getUsername(),"demo Subject","Demo body");
	}

	@Override
	public StudentRequestDto getExistingStudentRequest(Integer studentId) {
		Student st=studentRepository.getStudent(studentId);
		
		return new StudentRequestDto(st.getId(),st.getUsername(),st.getFirstName(),st.getLastName(),st.getGender(),st.getStreamId(),st.getClassRoom());
	}
	

}
