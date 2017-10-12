package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class User {

	@Id
	private int user_pk_id;
	
	
	private String first_name;
	
	
	private String last_name;
	
	//private String username;
	
	private String password;
	
	
	private String email;
	

	private String phoneNo;

	private String token;
	
	/*
	@OneToMany(mappedBy="user")
	public List<Events> event=new ArrayList<>();
	*/

	@CreationTimestamp
	private Timestamp creationTime;
	
	@UpdateTimestamp
	private Timestamp updateTime;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getUser_id() {
		return user_pk_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailid) {
		this.email = emailid;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
/*
	public List<Events> getEvent() {
		return event;
	}

	public void addEvent(Events event) {
		this.event.add(event);
	}
	
	public void setEvent(List event) {
		this.event.remove(event);
	}

	@Override
	public String toString() {
		return "User [user_pk_id=" + user_pk_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", email=" + email + ", phoneNo=" + phoneNo + ", token=" + token + "]";
	}
	*/
	
}
