package com.imro.dao;

import java.util.Map;

import com.imro.model.User;

public interface UserDao  {
	Map<String, Object> getUser(User user ) throws Exception;

}
