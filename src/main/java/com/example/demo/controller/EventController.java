package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.assertj.core.internal.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Events;
import com.example.demo.entity.User;
import com.example.demo.service.EventService;

@Controller
public class EventController<CustomObject> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EventService es;
	

	
	@RequestMapping("/events")
	public String events(Model model,HttpSession session,HttpServletRequest request) {
		session=request.getSession(false);
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		String email=(String) session.getAttribute("email");
		List<User> list=es.findemail(email);
		User user=list.get(0);
		List<Events> eventlist=es.findbyuser(user);
		model.addAttribute("list",eventlist);
		return "events";
	}
	
	@RequestMapping(value="/eventdetail",method=RequestMethod.GET)
	public String eventdetail(@RequestParam(value="eventName")String eventName,Model model) {
		List<Events> eventlist=es.find();
		List<User> userlist=new ArrayList<>();
		User user=new User();
		for(int i=0;i<eventlist.size();i++) {
		user=eventlist.get(i).getUser();
		userlist.add(user);
		}
		model.addAttribute("eventlist",eventlist);
		model.addAttribute("userlist",userlist);
		
		return "eventdetail";
	}
	
	@RequestMapping("/addevent")
	public String addevent(Model model,HttpServletRequest request,HttpSession session) {
		session=request.getSession(false);
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		Events event=new Events();
		model.addAttribute("event",event);
		return "addevent";
	}
	
	@RequestMapping("processaddevent")
	public String processaddevent(@ModelAttribute(value="event")Events event,Model model,HttpSession session) {
		String email="abc@gmail.com"; //(String) session.getAttribute("email");
		User u=new User();
		List list=es.findemail(email);
		event.setUser((User) list.get(0));
		es.save(event);
		return "redirect:/";
	}
	
	@RequestMapping(value="/editevent", method=RequestMethod.GET)
	public String editevent(@RequestParam(value="eventName")String eventName , Model model) {
		List<Events> eventlist=es.findbyeventname(eventName);
		Events event=eventlist.get(0);
		model.addAttribute("event",event);
		return "editevent";
	}
	
	@RequestMapping(value="/processeditevent", method=RequestMethod.POST)
	public String processeditevent(@ModelAttribute(value="event")Events event) {
		es.save(event);
		return "redirect:events";
	}
	@RequestMapping(value="/deleteevent", method=RequestMethod.GET)
	public String deleteevent(@RequestParam(value="eventName")String eventName) {
		List<Events> eventlist=es.findbyeventname(eventName);
		Events event=eventlist.get(0);
		es.delete(event);
		return "redirect:events";
	
	}
}
