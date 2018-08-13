package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

@Controller
public class PageController
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value= {"/","/home"})
	public String rootPage()
	{
		return "Home";
	}
	
	@RequestMapping(value="login")
	public String showLoginPage()
	{
		
		return "Login";
	}
	
	@RequestMapping(value="register")
	public String showRegisterPage(Model m)
	{
		UserDetail userDetail=new UserDetail();
		m.addAttribute("userDetail",userDetail);
		return "Register";
	}
	
	@RequestMapping(value="aboutus")
	public String showAboutUsPage()
	{
		return "AboutUs";
		
	}
	@RequestMapping(value="contactus")
	public String showContactUsPage()
	{
		return "ContactUs";
	}
	
	@RequestMapping(value="insertuserDetail")
	public String insertUserDetail(@ModelAttribute("userDetail")UserDetail userDetail,Model m)
	{
		userDAO.registerUserDetail(userDetail);
		return "Login";
	}


}
