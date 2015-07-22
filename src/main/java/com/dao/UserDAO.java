package com.dao;

import com.model.User;

public interface UserDAO {
    
    public User getUser(String login);
 
}