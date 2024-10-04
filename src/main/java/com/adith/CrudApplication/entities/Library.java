package com.adith.CrudApplication.entities;

import java.time.LocalDate;

public class Library {
	
	private Integer memberId;
	private Integer studentId;
	private LocalDate joinDate;
	private Integer totalBooksRead;
	
	public Library() {
	}
	public Library(Integer memberId, Integer studentId, LocalDate joinDate, Integer totalBooksRead) {
		this.memberId = memberId;
		this.studentId = studentId;
		this.joinDate = joinDate;
		this.totalBooksRead = totalBooksRead;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public Integer getTotalBooksRead() {
		return totalBooksRead;
	}
	public void setTotalBooksRead(Integer totalBooksRead) {
		this.totalBooksRead = totalBooksRead;
	}
	
}
