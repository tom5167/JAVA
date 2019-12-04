/*
 * Copyright (C) 2019 PatientCare - Hospital Management System
 *
 * Licensed under PatientCare CLIENT LICENSE AGREEMENT (the "License");
 * you may not use this file except in compliance with the License.
 *
 * User acknowledges and agrees that this class constitute and incorporate EventCare's confidential information. 
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
import patientCarePOJO.Event;

public class EventDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertEventDetails(Event eventDetails) {
		logger.info("EventDAO.insertEventDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblEvent "
					+ " (patient_id,staff_id,event_type,event_date,"
					+ "	createdBy,createdDate)" 
					+ " VALUES(?,?,?,?,"
					+ " ?,?)");
			pstmt.setInt(1, eventDetails.getPatientId());
			pstmt.setInt(2, eventDetails.getDoctorId());
			pstmt.setString(3, eventDetails.getEventType());
			pstmt.setString(4, eventDetails.getEventDate());
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
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		logger.info("EventDAO.insertEventDetails() ends");
		return flag;
	}
	
	public boolean updateEventDetails(Event eventDetails) {
		logger.info("EventDAO.updateEventDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblEvent "
					+ " SET first_name=?,last_name=?,sex=?,dob=?,"
					+ "	street_number=?,address_full=?,city=?,country=?,"
					+ " postal_code=?,sin_id=?,contact_number=?,alternative_number=?,"
					+ " insurance_id=?,email_id=?,blood_group=?,marital_status=?,"
					+ " modifiedBy=?,modifiedDate=?" 
					+ " WHERE patient_id = ?");
			pstmt.setString(17, commonUtil.getUserId());
			pstmt.setString(18, commonUtil.getCurrentDateTime());
			pstmt.setInt(19, eventDetails.getEventId());
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
		logger.info("EventDAO.updateEventDetails() ends");
		return flag;
	}
	
	public boolean deleteEventDetails(Event eventDetails) {
		logger.info("EventDAO.deleteEventDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblEvent"
					+ " WHERE event_id = ?");
			pstmt.setInt(1, eventDetails.getEventId());
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
		logger.info("EventDAO.deleteEventDetails() ends");
		return flag;
	}
	
	public List<Event> getAlEventDetails(String firstName) {
		logger.info("EventDAO.getAlEventDetails() starts");
		List<Event> eventDetails = new ArrayList<Event>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT patient_id,first_name,last_name,sex,dob," 
					+ " street_number,address_full,city,country,postal_code,sin_id,"
					+ " contact_number,alternative_number,insurance_id,email_id,"
					+ " blood_group,marital_status,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblEvent"
					+ " WHERE first_name LIKE ?";
			logger.info("EventDAO.getAlEventDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			Event eventObj = null;
			while (rs.next()) {
				eventObj = new Event();
				eventObj.setEventId(rs.getInt("event_id"));
				eventObj.setCreatedBy(rs.getString("createdBy"));
				eventObj.setCreatedDate(rs.getString("createdDate"));
				eventObj.setModifiedBy(rs.getString("modifiedBy"));
				eventObj.setModifiedDate(rs.getString("modifiedDate"));
				eventDetails.add(eventObj);
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
		logger.info("EventDAO.getAlEventDetails() ends");
		return eventDetails;
	}

}
