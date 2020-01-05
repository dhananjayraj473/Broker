package com.imro.service;

import java.util.Map;

import com.imro.model.User;

public interface UserService {
	Map<String, Object> getUser(User user ) throws Exception;

}
