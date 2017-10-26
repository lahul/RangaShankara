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
	public String events(@RequestParam(value="page",defaultValue="0")Integer page,Model model,HttpSession session,HttpServletRequest request) {
		session=request.getSession(false);
		if (session.getAttribute("email") == null) {
			return "redirect:/login";
		}

		int size=8;
		//size is number of events in a page
		//sizeofeventlist total number of events
		/*int start,sizeofeventlist,end, limit = 10;
		if(page==1) {
			start=1;
		}
		else {
			start=8*(page-1);
		}
		
		end=start+7;
		*/
		if(page!=0) {
			page=page-1;
		}
		String email=(String) session.getAttribute("email");
		List<User> list=es.findemail(email);
		User user=list.get(0);
		List<Events> eventlist=es.findbyuser(user,new PageRequest(page, size));
		//retrieving 8 event records display in a page

		double sizeofeventlist= es.eventCount();
		
		int totalPages  =(int) Math.ceil(sizeofeventlist / size);
		
		model.addAttribute("list",eventlist);
		model.addAttribute("page",page);
		model.addAttribute("totalPages",totalPages);
		return "events";
	}
	
	/*Displays the event detail of a particular event includes description of event,organizer etc.
	 * 
	 * 
	 */
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
	
	/*Add particular event for the user*/
	
	@RequestMapping(value="/editevent", method=RequestMethod.GET)
	public String editevent(@RequestParam(value="eventName")String eventName , Model model) {
		List<Events> eventlist=es.findbyeventname(eventName);
		Events event=eventlist.get(0);
		model.addAttribute("event",event);
		return "editevent";
	}
	
	/*Edit page for editing particular event */
	@RequestMapping(value="/processeditevent", method=RequestMethod.POST)
	public String processeditevent(@ModelAttribute(value="event")Events event) {
		es.save(event);
		return "redirect:events";
	}
	
	/*Deleting the event */
	@RequestMapping(value="/deleteevent", method=RequestMethod.GET)
	public String deleteevent(@RequestParam(value="eventName")String eventName) {
		List<Events> eventlist=es.findbyeventname(eventName);
		Events event=eventlist.get(0);
		es.delete(event);
		return "redirect:events";
	
	}
}
