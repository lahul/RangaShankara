package com.example.demo.repository;

import java.util.Arrays;
import java.util.List;

import org.mockito.internal.matchers.Find;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Events;
import com.example.demo.entity.User;

@RepositoryRestResource
public interface EventsHib extends CrudRepository<Events, String>{

	public List<Events> findAll();
	public List<Events> findByEventName(String eventName);

	/*@Query("Select e.eventName, e.eventDescription from Events e INNER JOIN e.user where e.eventName=:event")
	public List<Object> findEvents(@Param("event")String event);*/
	
	/*@Query("Select NEW map(e.eventName, e.eventDescription) from Events e  where e.eventName=:event")
	public List<Events> findEvents(@Param("event")String event);*/
	
	/*@Query("Select e from Events e join e.user u")
	public List<Object> findEvents();*/
	
	@Query(value="select * from Events e inner join user u on u.user_pk_id=e.event_fk_id",nativeQuery=true)
	public List<Events> findEvents();
	/*
	@Query("Select e.user from Events e where e.eventName=:event")
	public List<Object> findEvents(@Param("event")String event);
	*/
	
	public Events save(Events event);
	public void delete(Events event);
	
	@Query("select count(e) from Events e")
	public int CountEvents();
	
	@Query("Select e from Events e where e.user=?1")
	public List<Events> findByUser(User user,Pageable pageable);
}
