package com.example.demo.controller;

import static org.mockito.Matchers.intThat;

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
import java.util.HashMap;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Events;
import com.example.demo.entity.User;
import com.example.demo.service.EventService;
import com.example.demo.service.GenericService;

@Controller
public class EventController {

	final static int PAGE_SIZE=8;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EventService es;
	
	@Autowired
	GenericService gs;
	
	/* changing the default format of the Date type to suit to datetime format*/
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm"); //yyyy-MM-dd'T'HH:mm:ssZ example
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	/*Mapping for the events page it will display the events for the particular user
	 * if user is not logged in then login page is shown
	 */
	
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public String events(@RequestParam(value="page",defaultValue="0")int page,@RequestParam(value="searchitem",defaultValue="")String searchitem,Model model,HttpSession session,HttpServletRequest request) {
		int searchflag; 
		List<Events> eventlist;
		int totalPages;
		if(gs.checkSession(session,request)) {
			return "redirect:/login";
		}
		String email=(String) session.getAttribute("email");
		List<User> list=es.findemail(email);
		User user=list.get(0);
		if(searchitem.length()!=0) {
			searchflag=Integer.parseInt(request.getParameter("searchflag"));
			if(searchflag==0) {
				searchflag=1;
				page=0;
			}
			if(page!=0) {
				page=page-1;
			}
			eventlist=es.search(user,searchitem,new PageRequest(page,PAGE_SIZE));
			totalPages=gs.pagesizeforSearch(user,searchitem,PAGE_SIZE);
			model.addAttribute("searchflag",searchflag);
		}
		else {
		searchflag=0;
		if(page!=0) {
			page=page-1;
		}
		eventlist=es.findbyuser(user,new PageRequest(page, PAGE_SIZE));
		//retrieving 8 event records display in a page

		totalPages=gs.pagesize(PAGE_SIZE);
		}
		model.addAttribute("list",eventlist);
		model.addAttribute("page",page);
		model.addAttribute("totalPages",totalPages);
		String[][] arr=new String[][]{{"home","/"},{"events","/events"}};
		model.addAttribute("arr",arr);
		return "events";
	}
	
	/*Displays the event detail of a particular event includes description of event,organizer etc.
	 * 
	 * 
	 */
	@RequestMapping(value="/eventdetail/{eventPkId}",method=RequestMethod.GET)
	public String eventdetail(@PathVariable(value="eventPkId")int eventPkId,Model model,HttpSession session) {
		Integer id= (Integer) session.getAttribute("userid");
		
		Events eventlist=es.findById(eventPkId);
		
		Integer uid=eventlist.getUser().getUserPkId();
		if(!uid.equals(id)) {
			return "redirect:/error";
		}
		model.addAttribute("eventlist",eventlist);
		String[][] arr=new String[][]{{"home","#"},{"events","/events"},{"event detail","/eventdetail"}};
		model.addAttribute("arr",arr);
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
		String[][] arr=new String[][]{{"home","/"},{"events","/events"},{"add event","/addevent"}};
		model.addAttribute("arr",arr);
		return "addevent";
	}
	
	@RequestMapping("processaddevent")
	public String processaddevent(@ModelAttribute(value="event")@Valid Events event,@RequestParam(value="submit")String submit,BindingResult bindingResult,Model model,HttpSession session,HttpServletRequest request) throws IOException, ServletException {
			String email=(String) session.getAttribute("email");
			Part file=request.getPart("file");
			String location=request.getParameter("formatted_address");
			if(location!=null) {
			event.setLocation(location);
			event.setLatitude(request.getParameter("lat"));
			event.setLongitude(request.getParameter("lng"));
			}
			String filename=Paths.get(file.getSubmittedFileName()).getFileName().toString();
			if(!filename.isEmpty()) {
			es.copyfile(file,filename);
			event.setImage(filename);
			logger.info("{}",bindingResult.toString());
			User u=new User();
			List list=es.findemail(email);
			event.setUser((User) list.get(0));
			es.save(event);
			return "redirect:/events";
			}
			return "redirect:/";
	}
	
	/*Add particular event for the user*/
	
	@RequestMapping(value="/editevent/{eventPkId}", method=RequestMethod.GET)
	public String editevent(@PathVariable(value="eventPkId")int eventPkId , Model model) {
		Events event=es.findById(eventPkId);
		model.addAttribute("event",event);
		model.addAttribute("location",event.getLocation());
		String[][] arr=new String[][]{{"home","#"},{"edit event","/editevent"}};
		model.addAttribute("arr",arr);
		return "editevent";
	}
	
	/*Edit page for editing particular event */
	@RequestMapping(value="/processeditevent", method=RequestMethod.POST)
	public String processeditevent(@ModelAttribute(value="event")Events event,HttpSession session) {
		String email=(String) session.getAttribute("email");
		if(email==null) {
			return "redirect:/login";
		}
		//System.out.println(event.getEventPkId());
		//System.exit(0);
		List<User> u=es.findemail(email);
		User user=u.get(0);
		event.setUser(user);
		es.save(event);
		return "redirect:events";
	}
	
	/*Deleting the event */
	@RequestMapping(value="/deleteevent/{eventPkId}", method=RequestMethod.GET)
	public @ResponseBody Events deleteevent(@PathVariable(value="eventPkId")int eventPkId) {
		Events event=es.findById(eventPkId);
		//es.delete(event);
		//return "redirect:/events";
		return event;
	
	}

	/*
	@RequestMapping(value="/search")
	public String search(@RequestParam(value="page",defaultValue="0")int page,HttpSession session,HttpServletRequest request,Model model) {
		
		String searchitem=request.getParameter("searchitem");
		if(gs.checkSession(session, request)) {
			return "redirect: /login";
		}
		if(page!=0) {
			page=page-1;
		}
		List<Events> eventlist=es.search(searchitem,new PageRequest(page, PAGE_SIZE));
		int totalPages=gs.pagesize(PAGE_SIZE);
		
		model.addAttribute("list",eventlist);
		model.addAttribute("page",page);
		System.out.println(page);
		model.addAttribute("totalPages",totalPages);
		String[][] arr=new String[][]{{"home","#"},{"events","/events"}};
		model.addAttribute("arr",arr);
		return "events";
	}
	*/
}
