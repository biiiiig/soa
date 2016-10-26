package com.fhzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhzz.mapper.UserMapper;
import com.fhzz.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	public User checkLogin(String userName){
		return userMapper.getUserByName(userName);
	}
}
