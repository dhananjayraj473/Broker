package com.imro.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imro.model.User;
import com.imro.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String loginPage(Locale locale, Model model){
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "login";
		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView  user(@RequestParam("userName") String username) {
		System.out.println("User Page Requested");
		
		ModelAndView modelAndView=new ModelAndView();
		try{
		Map<String, Object> map=new HashMap<String, Object>();
		User user=new User();
		user.setUsername(username);
		map=userservice.getUser(user);
		modelAndView.addObject("userName", user.getUsername());
		if(map.containsValue(user.getUsername())){
			modelAndView.setViewName("user");
		}
		else{
			modelAndView.setViewName("login");
		}
		}
		catch(Exception e){
			modelAndView.setViewName("login");
			e.printStackTrace();
		}
		return modelAndView;
	}

	

}
