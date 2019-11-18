/*
 * Copyright (C) 2019 UserCare - Hospital Management System
 *
 * Licensed under UserCare CLIENT LICENSE AGREEMENT (the "License");
 * you may not use this file except in compliance with the License.
 *
 * User acknowledges and agrees that this class constitute and incorporate UserCare's confidential information. 
 * User shall take all reasonable precautions necessary to safeguard the confidentiality of all confidential information.  
 * 
 * User shall not:
 * (a) allow the removal or defacement of any confidentiality or proprietary notice placed on any confidential information
 * (a) permit any other person or third party to use or access the class; 
 * (b) sublicense, redistribute, sell, lease, or otherwise make the class available to any other person or third party;
 * (c) redistribute through personal email accounts, USB drives, internal or third party FTP sites, or internal share drives;  
 * (c) reproduce, copy, translate, modify, adapt, decompile, disassemble or reverse engineer any portion of the class or 
 *     otherwise attempt to secure the source code of all or any part of the Software; 
 */
package patientCareBusinessLogic;

import java.util.List;

import patientCareDAO.UserDAO;
import patientCarePOJO.User;

public class UserLogic {
	
	UserDAO userDAO = new UserDAO();

	public List<User> getAlUserDetails(String firstName,String userType) {
		return userDAO.getAlUserDetails(firstName,userType);
	}
	
	public boolean saveUserDetails(User userDetails) {
		if(userDetails.getUserId() < 1) {
			return userDAO.insertUserDetails(userDetails);
		} else {
			return userDAO.updateUserDetails(userDetails);
		}
	}
	
	public boolean deleteUserDetails(User userDetails) {
		return userDAO.deleteUserDetails(userDetails);
	}

	public List<User> getUserList(String userType) {
		return userDAO.getUserList(userType);
	}

}
