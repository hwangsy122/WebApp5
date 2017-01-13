package com.netsong7.web5.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netsong7.web5.domain.Member;
import com.netsong7.web5.persistence.LoginDaoImpl;
import com.netsong7.web5.persistence.MemberDao;

@Controller
public class LoginController {
	@Autowired
	private LoginDaoImpl loginDaoImpl;
	
	@RequestMapping(value="/login/login", method=RequestMethod.GET)
	public String moveLogin(){
		return "login/login";
	}
	
	@RequestMapping(value="/login/login", method=RequestMethod.POST)
	public String actionLogin(@ModelAttribute Member mem, HttpServletRequest req){
		Member member = loginDaoImpl.getIdPw(mem, req);
		
		if(member != null)
			return "login/login_success";
		else
			return "login/login";
	}
}





