package com.cakec.fos.test.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cakec.fos.service.SignupService;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(locations="classpath:test-servlet-context.xml")
public class SignupServiceTest {
	
	@Autowired
	SignupService signupService;
	
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
}
