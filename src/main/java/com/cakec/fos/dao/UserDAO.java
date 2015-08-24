package com.cakec.fos.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakec.fos.domain.UserCargo;
import com.cakec.fos.utils.AbstractDAO;

@Service
@Repository
public class UserDAO extends AbstractDAO{
	
	@Transactional
	public void save(UserCargo userCargo){
		getSession().save(userCargo);
	}
	
}
