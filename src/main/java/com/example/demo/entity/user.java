package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity   // to make gpa entity
 @Table(name = "user")
public class user {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "first_name")
	private String firrstName ;
	
	@Column(name = "last_name")
	private String lastName ;
	
	@Column(name = "email")
	private String email ;
	
	public user() {
		
	}
	public user(String firrstName, String lastName, String email) {
		super();
		this.firrstName = firrstName;
		this.lastName = lastName;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirrstName() {
		return firrstName;
	}
	public void setFirrstName(String firrstName) {
		this.firrstName = firrstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
