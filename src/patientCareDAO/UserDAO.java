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

import PatientCareUtil.CommonUtil;
import patientCareLogger.PatientCareLogger;
import patientCarePOJO.User;

public class UserDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean insertUserDetails(User userDetails) {
		logger.info("UserDAO.insertAlUserDetails() starts");
		boolean flag = true;
		try {
			conn = JdbcDBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblUser"
					+ " (username,pwd,referId,userType,"
					+ " createdBy,createdDate)" 
					+ " VALUES(?,?,?,?,?,?)");
			pstmt.setString(1, userDetails.getUserName());
			pstmt.setString(2, userDetails.getPwd());
			pstmt.setString(3, userDetails.getReferId());
			pstmt.setString(4, userDetails.getUserType());
			pstmt.setString(5, commonUtil.getUserId());
			pstmt.setString(6, commonUtil.getCurrentDateTime());
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
			conn = JdbcDBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblUser"
					+ " SET username=?,pwd=?,referId=?,userType=?,"
					+ " modifiedBy=?,modifiedDate=?" 
					+ " WHERE userId = ?");
			pstmt.setString(1, userDetails.getUserName());
			pstmt.setString(2, userDetails.getPwd());
			pstmt.setString(3, userDetails.getReferId());
			pstmt.setString(4, userDetails.getUserType());
			pstmt.setString(5, commonUtil.getUserId());
			pstmt.setString(6, commonUtil.getCurrentDateTime());
			pstmt.setInt(7, userDetails.getUserId());
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
			conn = JdbcDBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblUser"
					+ " WHERE userId = ?");
			pstmt.setInt(1, userDetails.getUserId());
			pstmt.execute();
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
	
	public List<User> getAlUserDetails(String firstName,String userType) {
		logger.info("UserDAO.getAlUserDetails() starts");
		List<User> userDetails = new ArrayList<User>();
		try {
			conn = JdbcDBConn.jdbcConnection();
			String sql = "SELECT tblUser.userId,tblUser.username,tblUser.pwd,A.referId,"
					+ " A.first_name,A.last_name,A.userType,"
					+ " tblUser.createdBy,tblUser.createdDate,tblUser.modifiedBy,tblUser.modifiedDate"
					+ " FROM "
					+" (SELECT patient_id as referId,first_name,last_name,'PATIENT' as userType FROM tblPatient" 
					+" UNION ALL"
					+" SELECT staff_id as referId,first_name,last_name,staff_type as userType FROM tblStaff" 
					+" ) AS A"
					+" INNER JOIN tblUser"
					+" ON A.referId = tblUser.referId"
					+" AND A.userType = tblUser.userType" 
					+" WHERE A.userType = ?"
					+" AND A.first_name LIKE ?";
			logger.info("UserDAO.getAlUserDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userType);
			pstmt.setString(2, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			User userObj = null;
			while (rs.next()) {
				userObj = new User();
				userObj.setUserId(rs.getInt("userId"));
				userObj.setUserName(rs.getString("username"));
				userObj.setPwd(rs.getString("pwd"));
				userObj.setReferId(rs.getString("referId"));
				userObj.setUserType(rs.getString("userType"));
				userObj.setCreatedBy(rs.getString("createdBy"));
				userObj.setCreatedDate(rs.getString("createdDate"));
				userObj.setModifiedBy(rs.getString("modifiedBy"));
				userObj.setModifiedDate(rs.getString("modifiedDate"));
				userObj.setFirstName(rs.getString("first_name"));
				userObj.setLastName(rs.getString("last_name"));
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
			conn = JdbcDBConn.jdbcConnection();
			String sql = "SELECT userId,username,pwd,referId,userType,createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblUser"
					+ " WHERE username=? AND pwd =?";
			logger.info("UserDAO.getAlPatientDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userObj = new User();
				userObj.setUserId(rs.getInt("userId"));
				userObj.setUserName(rs.getString("username"));
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

	public List<User> getUserList(String userType) {
		logger.info("UserDAO.getUserList() starts");
		List<User> userDetails = new ArrayList<User>();
		try {
			conn = JdbcDBConn.jdbcConnection();
			String sql = "SELECT referId,first_name,last_name,userType"
					+ " FROM "
					+ " (SELECT patient_id as referId,first_name,last_name,'PATIENT' as userType"
					+ " FROM tblPatient"
					+ " UNION ALL" 
					+ " SELECT staff_id as referId,first_name,last_name,staff_type as userType"
					+ " FROM tblStaff)"
					+ " AS tblTemp"
					+ " WHERE userType=?";
			logger.info("UserDAO.getUserList() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userType);
			rs = pstmt.executeQuery();
			User userObj = null;
			while (rs.next()) {
				userObj = new User();
				userObj.setReferId(rs.getString("referId"));
				userObj.setFirstName(rs.getString("first_name"));
				userObj.setLastName(rs.getString("last_name"));
				userObj.setUserType(rs.getString("userType"));
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
		logger.info("UserDAO.getUserList() ends");
		return userDetails;
	}

}
