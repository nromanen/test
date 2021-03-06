package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
     
    @Autowired
    private UserDAO userDAO;
 
    public User getUser(String login) {
        return userDAO.getUser(login);
    }
 
}