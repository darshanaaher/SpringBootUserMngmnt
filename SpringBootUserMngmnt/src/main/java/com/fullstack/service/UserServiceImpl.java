package com.fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.UserDaoImpl;
import com.fullstack.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	 private UserDaoImpl userDaoImpl;

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		userDaoImpl.signUp(user);
	}

	@Override
	public boolean signIn(String userEmailId, String userPassword) {
		// TODO Auto-generated method stub

		return userDaoImpl.signIn(userEmailId, userPassword);
	}

}
