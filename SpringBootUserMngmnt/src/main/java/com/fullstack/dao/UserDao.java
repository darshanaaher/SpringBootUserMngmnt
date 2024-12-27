package com.fullstack.dao;

import com.fullstack.model.User;

public interface UserDao {
	
	public void signUp(User user );
	
	public boolean signIn(String userEmailId, String userPassword);
	
}
