package com.imro.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.imro.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> getUser(User user) throws Exception {
		
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		try{
		map=jdbcTemplate.queryForMap("select * from userinfo where username=?",user.getUsername());
		for(String key:map.keySet())
		{
			System.out.println("Key "+key+"values "+map.get(key));
			
		}
		
		}
		catch(Exception e){
			throw e;
		}
		return map;
	}

}
