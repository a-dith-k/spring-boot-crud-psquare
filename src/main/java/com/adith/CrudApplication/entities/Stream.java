package com.adith.CrudApplication.entities;

public class Stream {
	
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Stream() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Stream(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
