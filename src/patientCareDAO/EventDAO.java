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
import patientCarePOJO.Room;

public class EventDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<Room> getRoomDetails() {
		logger.info("getRoomDetails() starts");
		List<Room> roomDetails = new ArrayList<Room>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT room_number,total_beds,occupied_beds,room_type,building_number"
					+ " FROM tblRoom";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Room roomObj = null;
			if (rs.next()) {
				roomObj = new Room();
				roomObj.setRoomNumber(rs.getInt("room_number"));
				roomObj.setTotalBeds(rs.getInt("total_beds"));
				roomObj.setOccupiedBeds(rs.getInt("occupied_beds"));
				roomObj.setRoomType(rs.getString("room_type"));
				roomObj.setBuildingNumber(rs.getString("building_number"));
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
		logger.info("getRoomDetails() ends");
		return roomDetails;
	}
	
	public boolean insertRoomDetails(List<Room> roomDetails) {
		logger.info("insertRoomDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			for (int i = 0; i < roomDetails.size(); i++) {
				pstmt = conn.prepareStatement("INSERT INTO tblRoom"
						+ " (room_number,total_beds,occupied_beds,room_type,building_number)" 
						+ " VALUES(?,?,?,?,?)");
				pstmt.setInt(1, roomDetails.get(i).getRoomNumber());
				pstmt.setInt(2, roomDetails.get(i).getTotalBeds());
				pstmt.setInt(3, roomDetails.get(i).getOccupiedBeds());
				pstmt.setString(4, roomDetails.get(i).getRoomType());
				pstmt.setString(5, roomDetails.get(i).getBuildingNumber());
				pstmt.execute();
			}
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
		logger.info("insertRoomDetails() ends");
		return flag;
	}

}
