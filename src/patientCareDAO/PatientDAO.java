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
import patientCarePOJO.Patient;

public class PatientDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertPatientDetails(Patient patientDetails) {
		logger.info("PatientDAO.insertPatientDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblPatient "
					+ " (first_name,last_name,sex,dob,"
					+ "	street_number,address_full,city,country,postal_code,sin_id," 
					+ "	contact_number,alternative_number,insurance_id,email_id,"
					+ " blood_group,marital_status)" 
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, patientDetails.getFirstName());
			pstmt.setString(2, patientDetails.getLastName());
			pstmt.setString(3, patientDetails.getSex());
			pstmt.setString(4, patientDetails.getDob());
			pstmt.setString(5, patientDetails.getLastName());
			pstmt.setString(6, patientDetails.getStreetNumber());
			pstmt.setString(7, patientDetails.getAddressFull());
			pstmt.setString(8, patientDetails.getCity());
			pstmt.setString(9, patientDetails.getCountry());
			pstmt.setString(10, patientDetails.getPostalCode());
			pstmt.setString(11, patientDetails.getSinId());
			pstmt.setString(12, patientDetails.getContactNumber());
			pstmt.setString(13, patientDetails.getAlternativeNumber());
			pstmt.setString(14, patientDetails.getInsuranceId());
			pstmt.setString(15, patientDetails.getEmailId());
			pstmt.setString(16, patientDetails.getBloodGroup());
			pstmt.setString(17, commonUtil.getUserId());
			pstmt.setString(18, commonUtil.getCurrentDateTime());
			pstmt.setString(19, "");
			pstmt.setString(20, "");
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
		logger.info("PatientDAO.insertPatientDetails() ends");
		return flag;
	}
	
	public boolean updatePatientDetails(Patient patientDetails) {
		logger.info("PatientDAO.updatePatientDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblPatient "
					+ " SET first_name=?,last_name=?,sex=?,dob=?,"
					+ "	street_number=?,address_full=?,city=?,country=?,postal_code=?,sin_id=?," 
					+ "	contact_number=?,alternative_number=?,insurance_id=?,email_id=?,"
					+ " blood_group=?,marital_status=?,"
					+ " createdBy=?,createdDate=?,modifiedBy=?,modifiedDate=?" 
					+ " WHERE patient_id = ?");
			pstmt.setString(1, patientDetails.getFirstName());
			pstmt.setString(2, patientDetails.getLastName());
			pstmt.setString(3, patientDetails.getSex());
			pstmt.setString(4, patientDetails.getDob());
			pstmt.setString(5, patientDetails.getLastName());
			pstmt.setString(6, patientDetails.getStreetNumber());
			pstmt.setString(7, patientDetails.getAddressFull());
			pstmt.setString(8, patientDetails.getCity());
			pstmt.setString(9, patientDetails.getCountry());
			pstmt.setString(10, patientDetails.getPostalCode());
			pstmt.setString(11, patientDetails.getSinId());
			pstmt.setString(12, patientDetails.getContactNumber());
			pstmt.setString(13, patientDetails.getAlternativeNumber());
			pstmt.setString(14, patientDetails.getInsuranceId());
			pstmt.setString(15, patientDetails.getEmailId());
			pstmt.setString(16, patientDetails.getBloodGroup());
			pstmt.setString(17, patientDetails.getCreatedBy());
			pstmt.setString(18, patientDetails.getCreatedDate());
			pstmt.setString(19, commonUtil.getUserId());
			pstmt.setString(20, commonUtil.getCurrentDateTime());
			pstmt.setInt(21, patientDetails.getPatientId());
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
		logger.info("PatientDAO.updatePatientDetails() ends");
		return flag;
	}
	
	public boolean deletePatientDetails(Patient patientDetails) {
		logger.info("PatientDAO.deletePatientDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblPatient"
					+ " WHERE patient_id = ?");
			pstmt.setInt(1, patientDetails.getPatientId());
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
		logger.info("PatientDAO.deletePatientDetails() ends");
		return flag;
	}
	
	public List<Patient> getAlPatientDetails(String firstName) {
		logger.info("PatientDAO.getAlPatientDetails() starts");
		List<Patient> patientDetails = new ArrayList<Patient>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT patient_id,first_name,last_name,sex,dob," 
					+ " street_number,address_full,city,country,postal_code,sin_id,"
					+ " contact_number,alternative_number,insurance_id,email_id,"
					+ " blood_group,marital_status,"
					+ " createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblPatient"
					+ " WHERE first_name LIKE ?";
			logger.info("PatientDAO.getAlPatientDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			Patient patientObj = null;
			while (rs.next()) {
				patientObj = new Patient();
				patientObj.setPatientId(rs.getInt("patient_id"));
				patientObj.setFirstName(rs.getString("first_name"));
				patientObj.setLastName(rs.getString("last_name"));
				patientObj.setSex(rs.getString("sex"));
				patientObj.setDob(rs.getString("dob"));
				patientObj.setStreetNumber(rs.getString("street_number"));
				patientObj.setAddressFull(rs.getString("address_full"));
				patientObj.setCity(rs.getString("city"));
				patientObj.setCountry(rs.getString("country"));
				patientObj.setPostalCode(rs.getString("postal_code"));
				patientObj.setSinId(rs.getString("sin_id"));
				patientObj.setContactNumber(rs.getString("contact_number"));
				patientObj.setAlternativeNumber(rs.getString("alternative_number"));
				patientObj.setInsuranceId(rs.getString("insurance_id"));
				patientObj.setEmailId(rs.getString("email_id"));
				patientObj.setBloodGroup(rs.getString("blood_group"));
				patientObj.setMaritalStatus(rs.getString("marital_status"));
				patientObj.setCreatedBy(rs.getString("createdBy"));
				patientObj.setCreatedDate(rs.getString("createdDate"));
				patientObj.setModifiedBy(rs.getString("modifiedBy"));
				patientObj.setModifiedDate(rs.getString("modifiedDate"));
				patientDetails.add(patientObj);
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
		logger.info("PatientDAO.getAlPatientDetails() ends");
		return patientDetails;
	}

}
