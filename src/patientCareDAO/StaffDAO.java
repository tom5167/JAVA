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
import patientCarePOJO.Staff;

public class StaffDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertStaffDetails(Staff staffDetails) {
		logger.info("StaffDAO.insertStaffDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblStaff "
					+ " (first_name,last_name,staff_type,join_date,"
					+ " available_hours,position,qualification,specialization,"
					+ " createdBy,createdDate)" 
					+ " VALUES(?,?,?,?,"
					+ " ?,?,?,?,"
					+ " ?,?)");
			pstmt.setString(1, staffDetails.getFirstName());
			pstmt.setString(2, staffDetails.getLastName());
			pstmt.setString(3, staffDetails.getStaffType());
			pstmt.setString(4, staffDetails.getJoinDate());
			pstmt.setString(5, staffDetails.getAvailableHours());
			pstmt.setString(6, staffDetails.getPosition());
			pstmt.setString(7, staffDetails.getHighestQualification());
			pstmt.setString(8, staffDetails.getSpecialization());
			pstmt.setString(9, commonUtil.getUserId());
			pstmt.setString(10, commonUtil.getCurrentDateTime());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag;
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		logger.info("StaffDAO.insertStaffDetails() ends");
		return flag;
	}
	
	public boolean updateStaffDetails(Staff staffDetails) {
		logger.info("StaffDAO.updateStaffDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblStaff "
					+ " SET first_name=?,last_name=?,staff_type=?,join_date=?," 
					+ " available_hours=?,position=?,qualification=?,specialization=?,"
					+ " modifiedBy=?,modifiedDate=?" 
					+ " WHERE staff_id = ?");
			pstmt.setString(1, staffDetails.getFirstName());
			pstmt.setString(2, staffDetails.getLastName());
			pstmt.setString(3, staffDetails.getStaffType());
			pstmt.setString(4, staffDetails.getJoinDate());
			pstmt.setString(5, staffDetails.getAvailableHours());
			pstmt.setString(6, staffDetails.getPosition());
			pstmt.setString(7, staffDetails.getHighestQualification());
			pstmt.setString(8, staffDetails.getSpecialization());
			pstmt.setString(17, commonUtil.getUserId());
			pstmt.setString(18, commonUtil.getCurrentDateTime());
			pstmt.setInt(19, staffDetails.getStaffId());
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
		logger.info("StaffDAO.updateStaffDetails() ends");
		return flag;
	}
	
	public boolean deleteStaffDetails(Staff staffDetails) {
		logger.info("StaffDAO.deleteStaffDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblStaff"
					+ " WHERE staff_id = ?");
			pstmt.setInt(1, staffDetails.getStaffId());
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
		logger.info("StaffDAO.deleteStaffDetails() ends");
		return flag;
	}
	
	public List<Staff> getAlStaffDetails(String firstName) {
		logger.info("StaffDAO.getAlStaffDetails() starts");
		List<Staff> staffDetails = new ArrayList<Staff>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT staff_id,first_name,last_name,staff_type,"
					+ " join_date,available_hours,position,qualification,specialization,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblStaff"
					+ " WHERE first_name LIKE ?";
			logger.info("StaffDAO.getAlStaffDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			Staff staffObj = null;
			while (rs.next()) {
				staffObj = new Staff();
				staffObj.setStaffId(rs.getInt("staff_id"));
				staffObj.setFirstName(rs.getString("first_name"));
				staffObj.setLastName(rs.getString("last_name"));
				staffObj.setStaffType(rs.getString("staff_type"));
				staffObj.setJoinDate(rs.getString("join_date"));
				staffObj.setAvailableHours(rs.getString("available_hours"));
				staffObj.setPosition(rs.getString("position"));
				staffObj.setHighestQualification(rs.getString("qualification"));
				staffObj.setSpecialization(rs.getString("specialization"));
				staffObj.setCreatedBy(rs.getString("createdBy"));
				staffObj.setCreatedDate(rs.getString("createdDate"));
				staffObj.setModifiedBy(rs.getString("modifiedBy"));
				staffObj.setModifiedDate(rs.getString("modifiedDate"));
				staffDetails.add(staffObj);
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
		logger.info("StaffDAO.getAlStaffDetails() ends");
		return staffDetails;
	}

}
