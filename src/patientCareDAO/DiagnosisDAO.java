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
import patientCarePOJO.Diagnosis;

public class DiagnosisDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertDiagnosisDetails(Diagnosis diagnosisDetails) {
		logger.info("DiagnosisDAO.insertDiagnosisDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblDiagnosis "
					+ " (patient_id,medication_name,medication_type,illness,dosage,"
					+ " createdBy,createdDate)" 
					+ " VALUES(?,?,?,?,?,"
					+ " ?,?)");
			pstmt.setInt(1, diagnosisDetails.getPatientId());
			pstmt.setString(2, diagnosisDetails.getMedicationName());
			pstmt.setString(3, diagnosisDetails.getMedicationType());
			pstmt.setString(4, diagnosisDetails.getIllness());
			pstmt.setString(5, diagnosisDetails.getDosage());
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
		logger.info("DiagnosisDAO.insertDiagnosisDetails() ends");
		return flag;
	}
	
	public boolean updateDiagnosisDetails(Diagnosis diagnosisDetails) {
		logger.info("DiagnosisDAO.updateDiagnosisDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblDiagnosis "
					+ " SET patient_id=?,medication_name=?,"
					+ " medication_type=?,illness=?,dosage=?,"
					+ " modifiedBy=?,modifiedDate=?" 
					+ " WHERE medication_id = ?");
			pstmt.setInt(1, diagnosisDetails.getPatientId());
			pstmt.setString(2, diagnosisDetails.getMedicationName());
			pstmt.setString(3, diagnosisDetails.getMedicationType());
			pstmt.setString(4, diagnosisDetails.getIllness());
			pstmt.setString(5, diagnosisDetails.getDosage());
			pstmt.setString(6, commonUtil.getUserId());
			pstmt.setString(7, commonUtil.getCurrentDateTime());
			pstmt.setInt(8, diagnosisDetails.getDiagnosisId());
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
		logger.info("DiagnosisDAO.updateDiagnosisDetails() ends");
		return flag;
	}
	
	public boolean deleteDiagnosisDetails(Diagnosis diagnosisDetails) {
		logger.info("DiagnosisDAO.deleteDiagnosisDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblDiagnosis"
					+ " WHERE medication_id = ?");
			pstmt.setInt(1, diagnosisDetails.getDiagnosisId());
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
		logger.info("DiagnosisDAO.deleteDiagnosisDetails() ends");
		return flag;
	}
	
	public List<Diagnosis> getAlDiagnosisDetails(String firstName) {
		logger.info("DiagnosisDAO.getAlDiagnosisDetails() starts");
		List<Diagnosis> diagnosisDetails = new ArrayList<Diagnosis>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT A.medication_id,A.patient_id,B.first_Name,B.last_Name,"
					+ " A.medication_name,A.medication_type,A.illness,A.dosage," 
					+ " A.createdBy,A.createdDate,A.modifiedBy,A.modifiedDate" 
					+ " FROM tblDiagnosis AS A " 
					+ " JOIN tblPatient AS B" 
					+ " ON A.patient_id = B.patient_id"
					+ " WHERE B.first_name LIKE ?";
			logger.info("DiagnosisDAO.getAlDiagnosisDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			Diagnosis diagnosisObj = null;
			while (rs.next()) {
				diagnosisObj = new Diagnosis();
				diagnosisObj.setDiagnosisId(rs.getInt("medication_id"));
				diagnosisObj.setPatientId(rs.getInt("patient_id"));
				diagnosisObj.setpFirstName(rs.getString("first_Name"));
				diagnosisObj.setpLastName(rs.getString("last_Name"));
				diagnosisObj.setMedicationName(rs.getString("medication_name"));
				diagnosisObj.setMedicationType(rs.getString("medication_type"));
				diagnosisObj.setIllness(rs.getString("illness"));
				diagnosisObj.setDosage(rs.getString("dosage"));
				diagnosisObj.setCreatedBy(rs.getString("createdBy"));
				diagnosisObj.setCreatedDate(rs.getString("createdDate"));
				diagnosisObj.setModifiedBy(rs.getString("modifiedBy"));
				diagnosisObj.setModifiedDate(rs.getString("modifiedDate"));
				diagnosisDetails.add(diagnosisObj);
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
		logger.info("DiagnosisDAO.getAlDiagnosisDetails() ends");
		return diagnosisDetails;
	}

}
