package com.fullstack.service;

import com.fullstack.model.User;

public interface UserService {
    void signUp(User user);
    boolean signIn(String userEmailId, String userPassword);
}
