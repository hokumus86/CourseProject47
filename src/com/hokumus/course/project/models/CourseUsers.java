package com.hokumus.course.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.project.models.base.BaseEntity;

@Entity
@Table(name = "course_users")
public class CourseUsers extends BaseEntity {

	private Long id;
	private String userName;
	transient private String password;
	private UserRoleTypes role;
	private String email;
	private String phoneNumber;
	
	@SequenceGenerator(name = "seq_course_users",initialValue = 1, sequenceName = "seq_course_users_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_course_users",strategy = GenerationType.SEQUENCE)
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 100)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length = 100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Enumerated
	@Column(name = "role_id")
	public UserRoleTypes getRole() {
		return role;
	}
	public void setRole(UserRoleTypes role) {
		this.role = role;
	}
	@Column(length = 250)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 50)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
