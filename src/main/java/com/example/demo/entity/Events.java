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

@Entity
public class Events {
	
	
	@Id
	private int event_pk_id;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_time", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private String eventTime;
	
	private int rating;
	
	private int price;
	
	/*@CreationTimestamp
	private Timestamp creationTime;
	
	@UpdateTimestamp
	private Timestamp updateTime;*/
	
	@Column(name="event_description")
	private String eventDescription;
	
	@ManyToOne
	@JoinColumn(name="event_fk_id",nullable=false,referencedColumnName="user_pk_id")
	private User user;
	
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public int getEvents_id() {
		return event_pk_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Events [event_pk_id=" + event_pk_id + ", eventName=" + eventName + ", eventTime=" + eventTime
				+ ", rating=" + rating + ", price=" + price + ", eventDescription=" + eventDescription + ", user="
				+ user + "]";
	}
}
