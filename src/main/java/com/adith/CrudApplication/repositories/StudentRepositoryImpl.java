package com.adith.CrudApplication.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.adith.CrudApplication.entities.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
	 Logger logger = LoggerFactory.getLogger(StudentRepositoryImpl.class);
	
	private final JdbcTemplate jdbcTemplate;

	public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> getAllStudents() {
		final String GET_ALL_STUDENTS="SELECT * FROM get_all_students()";
		final String GET_ALL_STUDENTS_CURSOR="SELECT * FROM get_all_students_by_cursor()";
		
		return jdbcTemplate.query(GET_ALL_STUDENTS_CURSOR,(rs, rowNum) -> {
			Student s=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getInt(7),rs.getString(5));
			return s;
		});
		//return jdbcTemplate.query("SELECT * FROM STUDENT",BeanPropertyRowMapper.newInstance(Student.class));
	}

	
//	 public List<StudentResponse> getStudentsWithStreamName() {
//	        String sql = "SELECT s.id, s.name, st.name AS stream " +
//	                     "FROM student s " +
//	                     "JOIN stream st ON s.stream_id = st.id";
//	        
//	        return jdbcTemplate.query(sql, new StudentRowMapper());
//	    }

	   
	@Override
	public void deleteStudent(Integer studentId) {
		Integer deletedStudentId=jdbcTemplate
				.execute("Select delete_student_get_id(?) AS s_id",
							(PreparedStatement ps) ->{
										ps.setInt(1, studentId);
										ResultSet rs=ps.executeQuery();
										if(rs.next()) {
											return rs.getInt("s_id");
										}
										return null;
							});
		logger.info("Deleted Student ID: {}",deletedStudentId);
//		System.out.println(id);
		//SimpleJdbcCall deleteStudent=new SimpleJdbcCall(jdbcTemplate).withFunctionName("delete_student");
		//deleteStudent.execute(Map.of("s_id",studentId));
		 //jdbcTemplate.update("DELETE FROM Student WHERE id=?", studentId);
	}
	
	@Override
	public void createStudent(Student student) {
		   SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("insert_student_data");
		   Map<String, Object> inParams = new HashMap<String, Object>();
		    inParams.put("username", student.getUsername());
		    inParams.put("first_name", student.getFirstName());
		    inParams.put("last_name", student.getLastName());
		    inParams.put("gender", student.getGender());
		    inParams.put("stream_id", student.getStreamId());
		    inParams.put("class_room", student.getClassRoom());
		    jdbcCall.execute(inParams);
		//jdbcTemplate.update("INSERT INTO Student (username,first_name,last_name,gender,stream_id,class_room) VALUES(?,?,?,?,?,?)",student.getUsername(),student.getFirstName(),student.getLastName(),student.getGender(),student.getStreamId(),student.getClassRoom());
	}

	@Override
	public Student getStudent(Integer studentId) {
		return jdbcTemplate.queryForObject("get_student(?)",(rs, rowNum) ->{
			Student s=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getInt(7),rs.getString(5));
			return s;
		} );
		//return jdbcTemplate.queryForObject("Select * from student where id=?",BeanPropertyRowMapper.newInstance(Student.class),studentId);
	}

	@Override
	public void updateStudent(Student student) {
			
			SimpleJdbcCall simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withFunctionName("update_student");
			Map<String, Object> inParams = new HashMap<String, Object>();
		    inParams.put("s_username", student.getUsername());
		    inParams.put("s_first_name", student.getFirstName());
		    inParams.put("s_last_name", student.getLastName());
		    inParams.put("s_gender", student.getGender());
		    inParams.put("s_stream_id", student.getStreamId());
		    inParams.put("s_class_room", student.getClassRoom());
		    inParams.put("s_id", student.getId());
			simpleJdbcCall.execute(inParams);
			//String query="select update_student(?,?,?,?,?,?,?)";
			//jdbcTemplate.update(query,student.getId(),student.getUsername(),student.getFirstName(),student.getLastName(),student.getGender(),student.getStreamId(),student.getClassRoom());
		  //String sql = "UPDATE student SET username=?,first_name=?,last_name=?,gender=?,stream_id=?,class_room=? WHERE id=?";
	      //jdbcTemplate.update(sql,student.getUsername(),student.getFirstName(),student.getLastName(),student.getGender(),student.getStreamId(),student.getClassRoom(),student.getId());
	
		//
	}

	@Override
	public Optional<Student> getStudentByUsername(String username) {
		
		Student s=jdbcTemplate.queryForObject("select * from student where username=?",BeanPropertyRowMapper.newInstance(Student.class), username);
		return Optional.of(s);
	}

}


