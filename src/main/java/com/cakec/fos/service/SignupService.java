package com.cakec.fos.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakec.fos.dao.UserDAO;
import com.cakec.fos.domain.UserCargo;
import com.cakec.fos.utils.DateFormatter;

@Service("signupService")
public class SignupService {
	
	private static final Logger logger = Logger.getLogger(SignupService.class);
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Autowired
	DateFormatter dateFormatter;
	
	@Transactional
	public void signup(HttpServletRequest request) throws ParseException, NoSuchAlgorithmException, InvalidKeySpecException {
		logger.info("Parsing request for signup values");
		UserCargo userCargo= new UserCargo();
		userCargo.setUsername(request.getParameter("username"));
		PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
		logger.info("Generating salt");
		byte[] salt= passwordEncryptionService.generateSalt();
		logger.info("Generating hash for the password");
		byte[] password = passwordEncryptionService.getEncryptedPassword(request.getParameter("password"), salt);
		userCargo.setSalt(salt);
		userCargo.setPasswd(password);
		userCargo.setEmail(request.getParameter("email"));
		userCargo.setDob(dateFormatter.convertStringtoDate(request.getParameter("dob")));
		userCargo.setIsActive("Y");
		userCargo.setCreatedBy(request.getParameter("username"));
		userCargo.setCreatedOn(new Date());
		this.getUserDAO().save(userCargo);
				
	}

	@Transactional
	public void login(HttpServletRequest request) throws ParseException, NoSuchAlgorithmException, InvalidKeySpecException {
		logger.info("Parsing request for signup values");
		PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
		
		UserCargo userCargo = this.getUserDAO().getRecord(request.getParameter("username"));
		logger.info("Generating hash for the password");
		byte[] password = passwordEncryptionService.getEncryptedPassword(request.getParameter("password"), userCargo.getSalt());
		boolean login = passwordEncryptionService.authenticate(request.getParameter("password"), password, userCargo.getSalt());
		logger.info(login);
	}
	

}
