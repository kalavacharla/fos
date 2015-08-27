package com.cakec.fos.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakec.fos.dao.UserDAO;
import com.cakec.fos.domain.UserCargo;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
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
		logger.debug("sdjkfhsdjkshdfdjkghdfuwerhwer");
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
		logger.debug("In signup page");
		logger.debug(request.getParameter("email"));
		logger.debug(request.getParameter("username"));
		logger.debug(request.getParameter("password"));
		
	}
	
	@RequestMapping(value="/landing")
	public ModelAndView landing(HttpServletRequest request) throws IOException{
		logger.debug("Landing page");
		return new ModelAndView("landing");
		
	}
	
}
