package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.assertj.core.internal.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm"); //yyyy-MM-dd'T'HH:mm:ssZ example
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public String events(@RequestParam(value="page")Integer page,Model model,HttpSession session,HttpServletRequest request) {
		int count=0,sizeofeventlist;
		session=request.getSession(false);
		count=0;
		count=count*page;
		int end=count+6;
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}
		String email=(String) session.getAttribute("email");
		List<User> list=es.findemail(email);
		User user=list.get(0);
		List<Events> eventlist=es.findbyuser(user);
		sizeofeventlist=eventlist.size();
		if(sizeofeventlist%6==0) {
			sizeofeventlist/=6;
		}
		else {
			sizeofeventlist=(sizeofeventlist/6)+1;
		}
		model.addAttribute("list",eventlist);
		model.addAttribute("page",page);
		model.addAttribute("count",count);
		model.addAttribute("end",end);
		model.addAttribute("size",sizeofeventlist);
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
	public String processaddevent(@ModelAttribute(value="event")@Valid Events event,@RequestParam(value="submit")String submit,BindingResult bindingResult,Model model,HttpSession session,HttpServletRequest request) throws IOException, ServletException {
		if(submit.equals("submit")) {
		String email=(String) session.getAttribute("email");
		Part file=request.getPart("file");
		String filename=es.copyfile(file);
		event.setImage(filename);
		logger.info("{}",bindingResult.toString());
		User u=new User();
		List list=es.findemail(email);
		event.setUser((User) list.get(0));
		es.save(event);
		return "redirect:/";
		}
		else
			return "redirect:/eventdetail";
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
