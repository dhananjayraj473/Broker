package com.imro.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imro.dao.UserDao;
import com.imro.model.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao; 
	public Map<String, Object> getUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

}
