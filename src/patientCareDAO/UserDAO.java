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
package patientCareDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import patientCareLogger.PatientCareLogger;
import patientCarePOJO.User;

public class UserDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean insertUserDetails(User userDetails) {
		logger.info("UserDAO.insertAlUserDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblUser"
					+ " (userId,username,pwd,referId,userType,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate)" 
					+ " VALUES(?,?,?,?,?,?)");
			pstmt.setInt(1, userDetails.getUserId());
			pstmt.setString(2, userDetails.getUsername());
			pstmt.setString(3, userDetails.getPwd());
			pstmt.setString(4, userDetails.getReferId());
			pstmt.setString(4, userDetails.getUserType());
			pstmt.setString(5, userDetails.getCreatedBy());
			pstmt.setString(6, userDetails.getCreatedDate());
			pstmt.setString(7, userDetails.getModifiedBy());
			pstmt.setString(8, userDetails.getModifiedDate());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		logger.info("UserDAO.insertAlUserDetails() ends");
		return flag;
	}
	
	public boolean updateUserDetails(User userDetails) {
		logger.info("UserDAO.updateUserDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblUser"
					+ " (userId,username,pwd,referId,userType,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate)" 
					+ " VALUES(?,?,?,?,?,?)");
			pstmt.setInt(1, userDetails.getUserId());
			pstmt.setString(2, userDetails.getUsername());
			pstmt.setString(3, userDetails.getPwd());
			pstmt.setString(4, userDetails.getReferId());
			pstmt.setString(4, userDetails.getUserType());
			pstmt.setString(5, userDetails.getCreatedBy());
			pstmt.setString(6, userDetails.getCreatedDate());
			pstmt.setString(7, userDetails.getModifiedBy());
			pstmt.setString(8, userDetails.getModifiedDate());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		logger.info("UserDAO.updateUserDetails() ends");
		return flag;
	}
	
	public boolean deleteUserDetails(User userDetails) {
		logger.info("UserDAO.deleteUserDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE INTO tblUser"
					+ " (userId,username,pwd,referId,userType,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate)" 
					+ " VALUES(?,?,?,?,?,?)");
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		logger.info("UserDAO.deleteUserDetails() ends");
		return flag;
	}
	
	public List<User> getAlUserDetails() {
		logger.info("UserDAO.getAlUserDetails() starts");
		List<User> userDetails = new ArrayList<User>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT userId,username,pwd,referId,userType,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblUser";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			User userObj = null;
			while (rs.next()) {
				userObj = new User();
				userObj.setUserId(rs.getInt("userId"));
				userObj.setUsername(rs.getString("username"));
				userObj.setPwd(rs.getString("pwd"));
				userObj.setReferId(rs.getString("referId"));
				userObj.setUserType(rs.getString("userType"));
				userObj.setCreatedBy(rs.getString("createdBy"));
				userObj.setCreatedDate(rs.getString("createdDate"));
				userObj.setModifiedBy(rs.getString("modifiedBy"));
				userObj.setModifiedDate(rs.getString("modifiedDate"));
				userDetails.add(userObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("UserDAO.getAlUserDetails() ends");
		return userDetails;
	}
	
	public User getUserDetails(String username, String pwd) {
		logger.info("UserDAO.getUserDetails() starts");
		User userObj = null;
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT userId,username,pwd,referId,userType,createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblUser"
					+ " WHERE username=? AND pwd =?";
			logger.info("PatientDAO.getAlPatientDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userObj = new User();
				userObj.setUserId(rs.getInt("userId"));
				userObj.setUsername(rs.getString("username"));
				userObj.setPwd(rs.getString("pwd"));
				userObj.setReferId(rs.getString("referId"));
				userObj.setUserType(rs.getString("userType"));
				userObj.setCreatedBy(rs.getString("createdBy"));
				userObj.setCreatedDate(rs.getString("createdDate"));
				userObj.setModifiedBy(rs.getString("modifiedBy"));
				userObj.setModifiedDate(rs.getString("modifiedDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("UserDAO.getUserDetails() ends");
		return userObj;
	}

}
