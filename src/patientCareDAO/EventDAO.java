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
					+ " (patient_id,staff_id,event_type,event_date,event_time,"
					+ " createdBy,createdDate)" 
					+ " VALUES(?,?,?,?,?,"
					+ " ?,?)");
			pstmt.setInt(1, eventDetails.getPatientId());
			pstmt.setInt(2, eventDetails.getDoctorId());
			pstmt.setString(3, eventDetails.getEventType());
			pstmt.setString(4, eventDetails.getEventDate());
			pstmt.setString(5, eventDetails.getEventTime());
			pstmt.setString(6, commonUtil.getUserId());
			pstmt.setString(7, commonUtil.getCurrentDateTime());
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
					+ " SET patient_id=?,staff_id=?,event_type=?,event_date=?,event_time=?,"
					+ " modifiedBy=?,modifiedDate=?" 
					+ " WHERE event_id = ?");
			pstmt.setInt(1, eventDetails.getPatientId());
			pstmt.setInt(2, eventDetails.getDoctorId());
			pstmt.setString(3, eventDetails.getEventType());
			pstmt.setString(4, eventDetails.getEventDate());
			pstmt.setString(5, eventDetails.getEventTime());
			pstmt.setString(6, commonUtil.getUserId());
			pstmt.setString(7, commonUtil.getCurrentDateTime());
			pstmt.setInt(8, eventDetails.getEventId());
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
	
	public List<Event> getAlEventDetails(String eventType,String eventDate) {
		logger.info("EventDAO.getAlEventDetails() starts");
		List<Event> eventDetails = new ArrayList<Event>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT event_id,patient_id,pfirst_name,plast_name,"
					+ " staff_id,sfirst_name,slast_name,"
					+ " event_type,event_date,event_time,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate" 
					+ " FROM (" 
					+ " SELECT A.event_id,A.patient_id,C.first_name AS pfirst_name,C.last_name AS plast_name,"
					+ " A.staff_id,B.first_name AS sfirst_name,B.last_name AS slast_name,"
					+ " A.event_type,A.event_date,A.event_time,"
					+ " A.createdBy,A.createdDate,A.modifiedBy,A.modifiedDate"
					+ " FROM tblEvent AS A " 
					+ " INNER JOIN tblStaff AS B" 
					+ " ON A.staff_id = B.staff_id" 
					+ " INNER JOIN tblPatient AS C" 
					+ " ON C.patient_id = C.patient_id" 
					+ ") AS tbl"
					+ " WHERE event_type=? AND event_date=?";
			logger.info("EventDAO.getAlEventDetails() - "+sql +"-"+eventType +"-"+eventDate);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eventType);
			pstmt.setString(2, eventDate);
			rs = pstmt.executeQuery();
			Event eventObj = null;
			while (rs.next()) {
				eventObj = new Event();
				eventObj.setEventId(rs.getInt("event_id"));
				eventObj.setPatientId(rs.getInt("patient_id"));
				eventObj.setpFirstName(rs.getString("pfirst_name"));
				eventObj.setpLastName(rs.getString("plast_name"));
				eventObj.setDoctorId(rs.getInt("staff_id"));
				eventObj.setdFirstName(rs.getString("sfirst_name"));
				eventObj.setdLastName(rs.getString("slast_name"));
				eventObj.setEventType(rs.getString("event_type"));
				eventObj.setEventDate(rs.getString("event_date"));
				eventObj.setEventTime(rs.getString("event_time"));
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

	public List<Event> getAlEventDetailsUser(String eventType, String eventDate) {
		logger.info("EventDAO.getAlEventDetailsUser() starts");
		List<Event> eventDetails = new ArrayList<Event>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT event_id,patient_id,pfirst_name,plast_name,"
					+ " staff_id,sfirst_name,slast_name,"
					+ " event_type,event_date,event_time,"
					+ " tbl.createdBy,tbl.createdDate,tbl.modifiedBy,tbl.modifiedDate" 
					+ " FROM (" 
					+ " SELECT A.event_id,A.patient_id,C.first_name AS pfirst_name,C.last_name AS plast_name,"
					+ " A.staff_id,B.first_name AS sfirst_name,B.last_name AS slast_name,"
					+ " A.event_type,A.event_date,A.event_time,"
					+ " A.createdBy,A.createdDate,A.modifiedBy,A.modifiedDate"
					+ " FROM tblEvent AS A " 
					+ " INNER JOIN tblStaff AS B" 
					+ " ON A.staff_id = B.staff_id" 
					+ " INNER JOIN tblPatient AS C" 
					+ " ON C.patient_id = C.patient_id" 
					+ " ) AS tbl"
					+ " JOIN tblUser AS U"
					+ " ON U.referid = tbl.patient_id"
					+ " WHERE event_type=? AND event_date=? AND U.userid = ?";
			logger.info("EventDAO.getAlEventDetailsUser() - "+sql +"-"+eventType +"-"+eventDate);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eventType);
			pstmt.setString(2, eventDate);
			pstmt.setInt(3,Integer.parseInt(commonUtil.getUserId()));
			rs = pstmt.executeQuery();
			Event eventObj = null;
			while (rs.next()) {
				eventObj = new Event();
				eventObj.setEventId(rs.getInt("event_id"));
				eventObj.setPatientId(rs.getInt("patient_id"));
				eventObj.setpFirstName(rs.getString("pfirst_name"));
				eventObj.setpLastName(rs.getString("plast_name"));
				eventObj.setDoctorId(rs.getInt("staff_id"));
				eventObj.setdFirstName(rs.getString("sfirst_name"));
				eventObj.setdLastName(rs.getString("slast_name"));
				eventObj.setEventType(rs.getString("event_type"));
				eventObj.setEventDate(rs.getString("event_date"));
				eventObj.setEventTime(rs.getString("event_time"));
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
		logger.info("EventDAO.getAlEventDetailsUser() ends");
		return eventDetails;
	}

}
