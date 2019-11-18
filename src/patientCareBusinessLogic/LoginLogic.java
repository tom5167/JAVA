/*
 * Copyright (C) 2019 PatientCare - Hospital Management System
 *
 * Licensed under PatientCare CLIENT LICENSE AGREEMENT (the "License");
 * you may not use this file except in compliance with the License.
 *
 * User acknowledges and agrees that this class constitute and incorporate PatientCare's confidential information. 
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

import org.apache.log4j.Logger;

import patientCareDAO.UserDAO;
import patientCareLogger.PatientCareLogger;
import patientCarePOJO.User;

public class LoginLogic {
	static Logger logger = PatientCareLogger.getLogger();
	
	UserDAO userDAO =  new UserDAO();
	
	public boolean checkUser(String username,String password) {
		logger.info("LoginLogic.checkUser() starts"); 
		boolean flag = false;
		User userObj = userDAO.getUserDetails(username,password);
		if(userObj == null) {
			flag = false;
		} else {
			flag = true;
		}
		logger.info("LoginLogic.checkUser() ends"); 
		return flag;
	}
	
	public User getUserDetails(String username,String password) {
		logger.info("LoginLogic.getUserDetails() starts"); 
		User userObj = userDAO.getUserDetails(username,password);
		logger.info("LoginLogic.getUserDetails() ends"); 
		return userObj;
	}
}
