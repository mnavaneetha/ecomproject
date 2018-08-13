package com.niit.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

@Controller
public class UserController {
	

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping("/login_success")
	public String showloginSuccess( @RequestParam(value="username" )String name,@RequestParam(value="password" )String password,Model m,HttpSession session)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			if (role.getAuthority().equals("ROLE_USER"))
			{
				loggedIn=true;
				page="ProductDisplay";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		
		return page;
	}
	
	@RequestMapping(value="success",method = RequestMethod.POST)
	public String registerUser(@RequestParam("customername")String name,@RequestParam("email")String email,@RequestParam("username")String username,
			@RequestParam("password")String password,@RequestParam("mobile")String mobile)
	{
		UserDetail userdetail=new UserDetail();
		userdetail.setAddress("chennai");
		userdetail.setCustomerName("navaneetha");
		userdetail.setEmail("navaneetha@gmail.com");
		userdetail.setMobile("124567890");
		userdetail.setPassword("123");
		userdetail.setRole("ROLE_USER");
		userdetail.setUsername("navaneetha123");
		userdetail.setEnabled(true);
		
		return "Login";
    }
	
	@RequestMapping(value="logout")
	public String logout()
	{
		return "Home";
	}

}
