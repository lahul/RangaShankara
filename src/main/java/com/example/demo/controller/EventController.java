package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Events;
import com.example.demo.entity.User;
import com.example.demo.service.EventService;
import com.example.demo.service.GenericService;

import antlr.debug.Event;

import com.example.demo.config.ConstantConfiguration;

@Controller
public class EventController {

	
	
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
			eventlist=es.search(user,searchitem,new PageRequest(page,ConstantConfiguration.PAGE_SIZE));
			totalPages=gs.pagesizeforSearch(user,searchitem,ConstantConfiguration.PAGE_SIZE);
			model.addAttribute("searchflag",searchflag);
		}
		else {
		searchflag=0;
		if(page!=0) {
			page=page-1;
		}
		eventlist=es.findbyuser(user,new PageRequest(page, ConstantConfiguration.PAGE_SIZE));
		//retrieving 8 event records display in a page

		totalPages=gs.pagesize(ConstantConfiguration.PAGE_SIZE);
		}
		model.addAttribute("list",eventlist);
		model.addAttribute("page",page);
		model.addAttribute("totalPages",totalPages);
		String[][] arr=new String[][]{{"home","/"},{"events","/events"}};
		model.addAttribute("arr",arr);
		return "events";
	}
	/*
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public String events(@RequestParam(value="page",defaultValue="0")int page,@RequestParam(value="searchitem",defaultValue="")String searchitem,Model model,HttpSession session,HttpServletRequest request) {
		List list=es.Join();
		System.out.println(list.toString());
		System.exit(0);
		return "events";
	}
	*/	
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
		if (session.getAttribute("userid") == null) {
			return "redirect:/login";
		}
		Events event=new Events();
		model.addAttribute("event",event);
		String[][] arr=new String[][]{{"home","/"},{"events","/events"},{"add event","/addevent"}};
		model.addAttribute("arr",arr);
		return "addevent";
	}
	
	@RequestMapping("processaddevent")
	public String processaddevent(@ModelAttribute(value="event")@Valid Events event, @RequestParam(value="submit")String submit,BindingResult bindingResult,Model model,HttpSession session,HttpServletRequest request) throws IOException, ServletException {
			String email=(String) session.getAttribute("email");
			StringBuilder builder = new StringBuilder();
		    List<FieldError> errors = bindingResult.getFieldErrors();
		    for (FieldError error : errors ) {
		       builder.append(error.getField() + " : " + error.getDefaultMessage());
		       model.addAttribute("message",builder.toString());
		       System.out.println(builder.toString());
		       return "redirect:/error";
		    } 
		    
			Part file=request.getPart("file");
			if(file == null) {
				return "redirect:/error";
			}
			String location=request.getParameter("formatted_address");
			if(location!=null) {
			event.setLocation(location);
			event.setLatitude(request.getParameter("lat"));
			event.setLongitude(request.getParameter("lng"));
			}
			String filename=Paths.get(file.getSubmittedFileName()).getFileName().toString();
			System.out.println(filename);
			if(filename!=null) {
			es.copyfile(file,filename);
			event.setImage(filename);
			}
			logger.info("{}",bindingResult.toString());
			User u=new User();
			List list=es.findemail(email);
			event.setUser((User) list.get(0));
			es.save(event);
			return "redirect:/events";
			
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
	public @ResponseBody Events processeditevent(@RequestParam Map<String,String> requestParams,HttpSession session) throws ParseException{
		int userid=(int) session.getAttribute("userid");
		/*if(userid==null) {
			return "redirect:/login";
		}*/
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm");
		int eventPkId=Integer.parseInt(requestParams.get("eventPkId"));
		Events event=es.findById(eventPkId);
		event.setEventName(requestParams.get("eventName"));
		event.setEventDescription(requestParams.get("eventDescription"));
		//event.setEventDescription("blah");
		event.setEventTime(format.parse(requestParams.get("eventTime")));
		event.setOrganizer(requestParams.get("organizer"));
		event.setPhoneNo(Integer.parseInt(requestParams.get("phoneNo")));
		event.setPrice(Integer.parseInt(requestParams.get("price")));
		event.setLatitude(requestParams.get("lat"));
		event.setLongitude(requestParams.get("lon"));
		event.setLocation(requestParams.get("formatted_address"));
		//int id=Integer.parseInt(userid);
		User user=es.findByUserId(userid);
		/*List<User> u=es.findemail(email);
		User user=u.get(0);*/
		event.setUser(user);
		es.save(event);
		
		
	
		return event;
		
	}
	
	/*Deleting the event */
	@RequestMapping(value="/deleteevent/{eventPkId}", method=RequestMethod.GET)
	public @ResponseBody Events deleteevent(@PathVariable(value="eventPkId")int eventPkId) {
		Events event=es.findById(eventPkId);
		es.delete(event);
		File file=new File(ConstantConfiguration.PAGE_SIZE+event.getImage());
		file.delete();
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
