package com.example.service;

import com.example.business.User;
import com.example.dao.userDAO;
import com.example.exceptions.DAOException;

public class UserService {

	userDAO dao = new userDAO();
	
	public User login(String username, String password){
		
		User u = null;
		try {			
			u = dao.findUserByUsernamePassword(username, password);
		} 
		catch (DAOException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
}