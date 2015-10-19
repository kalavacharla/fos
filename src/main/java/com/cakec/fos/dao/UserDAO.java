package com.cakec.fos.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cakec.fos.domain.UserCargo;
import com.cakec.fos.utils.AbstractDAO;

//@Service
@Repository
public class UserDAO extends AbstractDAO{
	
	private static final Logger logger = Logger.getLogger(UserDAO.class);
	
//	@Transactional
	public void save(UserCargo userCargo){
			logger.info("In DAO save method");
			logger.info(userCargo);
			
			getSession().save(userCargo);
		
	}
	
	public UserCargo getRecord(String username){
		String hql = "from UserCargo where username=:username";
		Query query = getSession().createQuery(hql);
		query.setString("username",username);
		List<UserCargo> userCargo = query.list();
		return userCargo.get(0);
	}

	@Override
	public String toString() {
		return "UserDAO [getSessionFactory()=" + getSessionFactory()
				+ ", getSession()=" + getSession() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
