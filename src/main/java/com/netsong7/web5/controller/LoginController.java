package com.netsong7.web5.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netsong7.web5.domain.Member;

@Controller
public class LoginController {
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String moveLogin(){
		return "login/login";
	}
	
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String actionLogin(@ModelAttribute Member mem){
		
		return "login/login_success";
	}
}





