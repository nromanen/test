package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoleDAO;
import com.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
     
    @Autowired
    private RoleDAO roleDAO;
 
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }
 
}

