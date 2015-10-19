package com.cakec.fos.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cakec.fos.dao.UserDAO;
import com.cakec.fos.domain.TestCargo;
import com.cakec.fos.service.SignupService;

@RestController
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private SignupService signupService;
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@RequestMapping(value="/landing")
	public ModelAndView landing(HttpServletRequest request) throws IOException{
		logger.debug("Landing page");
		return new ModelAndView("landing");
		
	}
	
	@RequestMapping(value="/signup")
	public void signup(HttpServletRequest request) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException{
		logger.debug("In signup method");
		signupService.signup(request);
	}
	
	
	@RequestMapping(value="/test")
	public TestCargo testRest(@RequestParam(value="name") String nam){
		return new TestCargo(nam);
	}
	
}
