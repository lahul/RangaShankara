package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Events {
	
	
	@Id
	private int eventPkId;
	
	@Column(name="event_name")
	private String eventName;
	
	
	/*@Column(name="event_time", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)*/
	private Date eventTime;
	
	private Integer price;
	
	private String organizer;
	
	private String longitude;
	
	private String latitude;
	
	private String location;
	
	private String image;
	
	private Integer phoneNo;
	

	@ManyToOne
	@JoinColumn(name="user_fk_id", nullable=false)
	private User user;
	
	/*@CreationTimestamp
	private Timestamp creationTime;
	
	@UpdateTimestamp
	private Timestamp updateTime;*/
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getPhoneNo() {
		return phoneNo;
	}

	public int getEventPkId() {
		return eventPkId;
	}

	public void setEventPkId(int eventPkId) {
		this.eventPkId = eventPkId;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="event_description")
	private String eventDescription;
	

	
	public Events() {} 
	
	public Events(String eventName, String eventDescription) {
		this.eventName = eventName;
		this.eventDescription = eventDescription;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}



	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}



	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	
	
	
}
