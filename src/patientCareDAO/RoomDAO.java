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
import patientCarePOJO.Room;

public class RoomDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertRoomDetails(Room roomDetails) {
		logger.info("RoomDAO.insertRoomDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblRoom "
					+ " (first_name,last_name,sex,dob,"
					+ "	street_number,address_full,city,country,"
					+ " postal_code,sin_id,contact_number,alternative_number,"
					+ " insurance_id,email_id,blood_group,marital_status,"
					+ " createdBy,createdDate)" 
					+ " VALUES(?,?,?,?,"
					+ " ?,?,?,?,"
					+ " ?,?,?,?,"
					+ " ?,?,?,?,"
					+ " ?,?)");
			pstmt.setString(17, commonUtil.getUserId());
			pstmt.setString(18, commonUtil.getCurrentDateTime());
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
		logger.info("RoomDAO.insertRoomDetails() ends");
		return flag;
	}
	
	public boolean updateRoomDetails(Room roomDetails) {
		logger.info("RoomDAO.updateRoomDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblRoom "
					+ " SET first_name=?,last_name=?,sex=?,dob=?,"
					+ "	street_number=?,address_full=?,city=?,country=?,"
					+ " postal_code=?,sin_id=?,contact_number=?,alternative_number=?,"
					+ " insurance_id=?,email_id=?,blood_group=?,marital_status=?,"
					+ " modifiedBy=?,modifiedDate=?" 
					+ " WHERE patient_id = ?");
			pstmt.setString(17, commonUtil.getUserId());
			pstmt.setString(18, commonUtil.getCurrentDateTime());
			pstmt.setInt(19, roomDetails.getRoomId());
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
		logger.info("RoomDAO.updateRoomDetails() ends");
		return flag;
	}
	
	public boolean deleteRoomDetails(Room roomDetails) {
		logger.info("RoomDAO.deleteRoomDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblRoom"
					+ " WHERE room_id = ?");
			pstmt.setInt(1, roomDetails.getRoomId());
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
		logger.info("RoomDAO.deleteRoomDetails() ends");
		return flag;
	}
	
	public List<Room> getAlRoomDetails(String firstName) {
		logger.info("RoomDAO.getAlRoomDetails() starts");
		List<Room> roomDetails = new ArrayList<Room>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT patient_id,first_name,last_name,sex,dob," 
					+ " street_number,address_full,city,country,postal_code,sin_id,"
					+ " contact_number,alternative_number,insurance_id,email_id,"
					+ " blood_group,marital_status,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblRoom"
					+ " WHERE first_name LIKE ?";
			logger.info("RoomDAO.getAlRoomDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			Room roomObj = null;
			while (rs.next()) {
				roomObj = new Room();
				roomObj.setRoomId(rs.getInt("room_id"));
				roomObj.setCreatedBy(rs.getString("createdBy"));
				roomObj.setCreatedDate(rs.getString("createdDate"));
				roomObj.setModifiedBy(rs.getString("modifiedBy"));
				roomObj.setModifiedDate(rs.getString("modifiedDate"));
				roomDetails.add(roomObj);
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
		logger.info("RoomDAO.getAlRoomDetails() ends");
		return roomDetails;
	}

}
