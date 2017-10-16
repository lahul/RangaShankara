package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Events;
import com.example.demo.entity.User;
import com.example.demo.repository.EventsHib;
import com.example.demo.repository.UserHib;

@Repository
@Transactional
public class EventService<CustomObject> {

	@Autowired
	UserHib uh;

	@Autowired
	EventsHib eh;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public EntityManager entityManager;

	public int check(String email, String password) {
		List<User> list = uh.findByEmailAndPassword(email, password);
		if (list.isEmpty()) {
			return 0;
		} else {
			if (password == list.get(0).getPassword())
				return 1;
			else
				return 1;
		}
	}

	public List<User> findemail(String email) {
		List<User> list = uh.findByEmail(email);
		return list;
	}

	public List<User> findtoken(String token) {
		List<User> list = uh.findByToken(token);
		return list;
	}

	public void save(User user) {
		User u = uh.save(user);
	}

	public void save(Events event) {
		Events e = eh.save(event);
	}

	public List<Events> findallevents() {
		List<Events> list = eh.findAll();
		return list;
	}

	public List<Events> findbyeventname(String eventName) {
		List<Events> list = eh.findByEventName(eventName);
		return list;
	}

	public List<Events> find() {
		List<Events> list = eh.findEvents();
		return list;
	}

	public void delete(Events event) {
		eh.delete(event);
	}
	
	public List<Events> findbyuser(User user){
		List<Events> events=eh.findByUser(user);
		return events;
	}
	/*
	 * public List<Events> find(String eventName){ List result=entityManager.
	 * createQuery("Select e.eventName,e.eventDescription from Events e").
	 * getResultList(); return result; }
	 */
	/*
	 * public void find(String eventName){ Query query =
	 * entityManager.createNativeQuery("select e from Events e"); List<Object[]>
	 * list=query.getResultList(); logger.warn("{}",list); }
	 */
	/*
	 * public void find() { CriteriaBuilder cb=entityManager.getCriteriaBuilder();
	 * CriteriaQuery<User> cq= cb.createQuery(User.class); Root<User>
	 * eventsRoot=cq.from(User.class);
	 * 
	 * TypedQuery<User> query=entityManager.createQuery(cq); List<User>
	 * list=query.getResultList(); System.out.println(list); }
	 */
}

/*
 * public List<Events> find(String eventName){ String query =
 * "SELECT NEW com.example.demo.entity.Events(e.eventName, e.eventDescription) FROM Events e"
 * ; TypedQuery<Events> typedQuery
 * =entityManager.createQuery(query,Events.class); List<Events> results =
 * typedQuery.getResultList(); return results; }
 */