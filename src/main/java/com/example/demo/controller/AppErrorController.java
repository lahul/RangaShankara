package com.example.demo.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController{

	private static final String ERROR_PATH = "/error";
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return ERROR_PATH;
	}
	
	
	@RequestMapping(value=ERROR_PATH)
	public String errorpage() {
		return "err";
	}

}
