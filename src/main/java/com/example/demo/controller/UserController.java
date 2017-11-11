package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.EventService;

@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EventService es;

	@Autowired
	EmailService em;

	@Autowired
	BCryptPasswordEncoder bcrypt;

	/* Mapping to the home page */
	
	@RequestMapping("/")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("email") == null) {
			model.addAttribute("status", "no");
		return "home";
		}else{
		model.addAttribute("status", "yes");
		return "home";
		}
	}
	
	
	@RequestMapping("/signout")
	public String logout(HttpServletRequest request, HttpSession session) {
		session = request.getSession(false);
		if (session.getAttribute("userid") == null) {
			return "redirect:/login";
		}
		session.invalidate();
		return "redirect:/";
	}

	/* Register page is displayed upon succesful registration user redirected to home
	 * on unsuccessful attempt same page is displayed
	 */
	@RequestMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping("/processregister")
	public @ResponseBody User processRegister(@RequestParam Map<String,String> requestParams ,HttpServletRequest request) {
		String cpassword = requestParams.get("cpassword");
		String password=requestParams.get("password");
		User user=new User();
		user.setFirst_name(requestParams.get("first_name"));
		user.setLast_name(requestParams.get("last_name"));
		user.setEmail(requestParams.get("email"));
		user.setPhoneNo(requestParams.get("phoneNo"));
		//System.out.println(cpassword);
		//System.out.println(user.getPassword());
		if (cpassword.equals(password)) {
			user.setPassword(bcrypt.encode(password));
		} else {
			return user;
		}
		es.save(user);
		return user;
	}

	/*Mapping for the login page */
	
	@RequestMapping("/login")
	public String signin(HttpSession session, HttpServletRequest request,Model model) {
		session = request.getSession(false);
		if (session.getAttribute("email") != null) {
			return "redirect:/";
		}
		return "login";
	}

	@RequestMapping("/processsignin")
	public @ResponseBody User processSignin(@RequestParam Map<String,String> requestParams,HttpServletRequest request, HttpSession session) {
		String email = requestParams.get("email");
		String password = requestParams.get("password");
		List<User> list = es.findemail(email);
		User user=es.findFirstUser(email);
		if (list.isEmpty());
			//return "redirect:/signin";
		else {
			if (bcrypt.matches(password, list.get(0).getPassword())) {
				session = request.getSession();
				session.setAttribute("email", email);
				
				session.setAttribute("userid", user.getUserPkId());
				return user;
			}/* else
				return user;*/
		}
		return user;
	}

	/*Displays reset password page that asks for reset email */
	
	@RequestMapping("/resetpassword")
	public String resetpassword(HttpServletRequest request, HttpSession session,Model model) {
		return "resetpassword";
	}

	/*Displays a page to enter new password for password change */
	
	@RequestMapping("/reset")
	public String reset(HttpServletRequest request) {
		String email = request.getParameter("email");
		List<User> list = es.findemail(email);
		if (list.isEmpty()) {
			return "redirect:/resetpassword";
		}
		String token = list.get(0).getToken();
		em.sendMail(email, token);
		return "redirect:/";
	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.GET)
	public String reset2(@RequestParam(value = "token") String token, Model model, HttpServletRequest request) {
		List<User> list = es.findtoken(token);
		System.out.println(token);
		if (list.isEmpty()) {
			return "redirect:/";
		} else {
			model.addAttribute("token", token);
			return "updatepassword";
		}
	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public String reset3(Model model, HttpServletRequest request) {

		String pass = request.getParameter("password");
		String cpass = request.getParameter("cpassword");
		String token = request.getParameter("token");

		if (pass.equals(cpass)) {
			List<User> list = es.findtoken(token);
			User user = list.get(0);
			bcrypt.encode(pass);
			user.setPassword(pass);
			es.save(user);
			return "redirect:/";
		} else
			return "updatepassword";
	}

	/*
	 * @Autowired private Facebook facebook;
	 * 
	 * @RequestMapping(value="/facebooksignin") public String helloFacebook(Model
	 * model) {
	 * 
	 * return "redirect:/connect/facebook";
	 * 
	 * 
	 * model.addAttribute(facebook.userOperations().getUserProfile()); PagedList
	 * homeFeed = facebook.feedOperations().getHomeFeed();
	 * model.addAttribute("feed", homeFeed);
	 * 
	 * return "home"; }
	 */

}