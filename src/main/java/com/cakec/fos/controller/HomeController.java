package com.cakec.fos.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakec.fos.dao.UserDAO;
import com.cakec.fos.domain.UserCargo;

@Controller
public class HomeController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView loginView(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/hit")
	public void view(HttpServletResponse response) throws IOException{
		System.out.println("sdjkfhsdjkshdfdjkghdfuwerhwer");
		UserCargo userCargo = new UserCargo();
		userCargo.setUsername("Test");
		userCargo.setPasswd("Test");
		userCargo.setFirstname("Test");
		userCargo.setLastname("test");
		userCargo.setDob(new Date());
		userCargo.setIsActive("T");
		userCargo.setCreatedby("Test");
		userCargo.setCreatedOn(new Date());
//		UserDAO userDAO = new UserDAO();
		userDAO.save(userCargo);
	}
	
	
	@RequestMapping(value="/signup")
	public void signup(HttpServletRequest request) throws IOException{
		System.out.println("In signup page");
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		
	}
	
	@RequestMapping(value="/landing")
	public ModelAndView landing(HttpServletRequest request) throws IOException{
		System.out.println("In landing page");
		return new ModelAndView("landing");
		
	}
	
}
