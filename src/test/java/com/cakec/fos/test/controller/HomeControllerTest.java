package com.cakec.fos.test.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.cakec.fos.controller.HomeController;
import com.cakec.fos.domain.UserCargo;
import com.cakec.fos.service.SignupService;
import com.cakec.fos.test.utils.UtilsTest;

public class HomeControllerTest extends UtilsTest{

	@Autowired
	HomeController homeController;
	
	@Autowired
	SignupService signupService;
	
		
	@Test
	public void LandingTest() throws IOException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/landing");
		request.setMethod("GET");
		
		ModelAndView mav = homeController.landing(request);
		Assert.assertEquals(mav.getViewName(), "landing");
		
	}
	
	@Test
	public void SignUpTest() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/signup");
		request.setMethod("POST");
		request.setParameter("email", "abc@gmail.com");
		request.setParameter("username", "testUsername");
		request.setParameter("password", "testPassword");
		request.setParameter("dob","08261984");
		
		signupService.signup(request);
		
		
	}
	
	/**
	 * Sign up test with valid values.
	 */
	@Test
	public void signUpValidTest(){
		
	}
	
	@Test
	public void signUpInvalidEmail(){
		
	}
	
	@Test
	public void signUpDuplicateUser(){
		
	}
	
	@Test
	public void LoginTest() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/login");
		request.setMethod("POST");
		request.setParameter("username", "testUsername");
		request.setParameter("password", "testPassword");
		
		signupService.login(request);
		
		
	}
	
	
	public MockHttpServletRequest setSignupRequestParams(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameter("email", "abc@gmail.com");
		request.setParameter("username", "testUsername");
		request.setParameter("password", "testPassword");
		return request;
	}
}
