package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class GenericService {

	@Autowired
	EventService es;
	
	public boolean checkSession(HttpSession session,HttpServletRequest request) { 
	session=request.getSession(false);
	if (session.getAttribute("userid") == null) {
		return true;
	}
	return false;
}
	
	public int pagesize(int size){
		double sizeofeventlist= es.eventCount();
		int totalPages  =(int) Math.ceil(sizeofeventlist / size);
		return totalPages;
	}
	
	public int pagesizeforSearch(User user,String searchitem,int size){
		double sizeofeventlist= es.eventcountforSearch(user,searchitem);
		int totalPages  =(int) Math.ceil(sizeofeventlist / size);
		return totalPages;
	}
}
