package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "student_name")
	private String name;
	@Column(name = "admission_year")
	private String admission_year;
	@Column(name = "student_address")
	private String address;
	@Column(name = "student_phone")
	private String phone;
	@Column(name = "student_email")
	private String email;
	
	public Student() {
		
	}
	
	public Student(int id, String name, String admission_year, String address, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.admission_year = admission_year;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmission_year() {
		return admission_year;
	}
	public void setAdmission_year(String admission_year) {
		this.admission_year = admission_year;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
