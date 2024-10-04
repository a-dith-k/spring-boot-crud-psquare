package com.adith.CrudApplication.entities;


public class Student {
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", stream=" + streamId
				+ ", classRoom=" + classRoom + "]";
	}
	public Student() {

	}
	private Integer id;
	private String username;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer streamId;
	private String classRoom;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getClassRoom() {
		return classRoom;
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
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public Student( String username, String firstName, String lastName, String gender, Integer streamId,
			String classRoom) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.streamId = streamId;
		this.classRoom = classRoom;
	}
	
	public Student(Integer id, String username, String firstName, String lastName, String gender, Integer streamId,
			String classRoom) {
		this.id=id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.streamId = streamId;
		this.classRoom = classRoom;
	}
	public Integer getStreamId() {
		return streamId;
	}
	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}
	

}
