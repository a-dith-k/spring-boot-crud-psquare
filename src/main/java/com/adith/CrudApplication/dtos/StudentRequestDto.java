package com.adith.CrudApplication.dtos;

public class StudentRequestDto {
	Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	String username;
	String firstName;
	String lastName;
	String gender;
	Integer streamId;
	String classRoom;
	
	public StudentRequestDto( String username, String firstName, String lastName, String gender, Integer streamId,
			String classRoom) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.streamId = streamId;
		this.classRoom = classRoom;
	}
	public StudentRequestDto(Integer id, String username, String firstName, String lastName, String gender, Integer streamId,
			String classRoom) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.streamId = streamId;
		this.classRoom = classRoom;
		this.id=id;
	}
	
	public StudentRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getStreamId() {
		return streamId;
	}
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
