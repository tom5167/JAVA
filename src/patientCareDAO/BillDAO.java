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
import patientCarePOJO.Bill;

public class BillDAO {
	
	static Logger logger = PatientCareLogger.getLogger();
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertBillDetails(Bill billdetails) {
		logger.info("BillDAO.insertBillDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tblBilling "
					+ " (mode_of_payment,payment_due_date,billing_timestamp,insurance_number,"
					+ "	payer_name,bill_amount,paymentstatus,createdBy,"
					+ " createdDate)" 
					+ " VALUES(?,?,?,?,"
					+ " ?,?,?,?,"
					+ " ?)");
			pstmt.setString(1, billdetails.getmodeofpay());
			pstmt.setString(2, billdetails.getpaymentduedate());
			pstmt.setString(3, billdetails.getbillingtime());
			pstmt.setString(4, billdetails.getinsurancenumber());
			pstmt.setString(5, billdetails.getpayername());
			pstmt.setString(6, billdetails.getbillamount());
			pstmt.setString(7, billdetails.getpaymentstatus());
			pstmt.setString(8, commonUtil.getUserId());
			pstmt.setString(9, commonUtil.getCurrentDateTime());
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
		logger.info("BillDAO.insertBillDetails() ends");
		return flag;
	}
	
	public boolean updateBillDetails(Bill billdetails) {
		logger.info("BillDAO.updateBillDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tblBilling "
					+ " SET mode_of_payment=?,payment_due_date=?,billing_timestamp=?,insurance_number=?,"
					+ "	payer_name=?,bill_amount=?,paymentstatus=?,modifiedBy=?,modifiedDate=?" 
					+ " WHERE billing_id = ?");
			pstmt.setString(1, billdetails.getmodeofpay());
			pstmt.setString(2, billdetails.getpaymentduedate());
			pstmt.setString(3, billdetails.getbillingtime());
			pstmt.setString(4, billdetails.getinsurancenumber());
			pstmt.setString(5, billdetails.getpayername());
			pstmt.setString(6, billdetails.getbillamount());
			pstmt.setString(7, billdetails.getpaymentstatus());
			pstmt.setString(8, commonUtil.getUserId());
			pstmt.setString(9, commonUtil.getCurrentDateTime());
			pstmt.setInt(10, billdetails.getBillId());
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
		logger.info("BillDAO.updateBillDetails() ends");
		return flag;
	}
	
	public boolean deleteBillDetails(Bill billdetails) {
		logger.info("BillDAO.deleteBillDetails() starts");
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tblBilling"
					+ " WHERE billing_id = ?");
			pstmt.setInt(1, billdetails.getBillId());
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
		logger.info("BillDAO.deleteBillDetails() ends");
		return flag;
	}
	
	public List<Bill> getAlBillDetails(String billing_id) {
		logger.info("BillDAO.getAlBillDetails() starts");
		List<Bill> billDetails = new ArrayList<Bill>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT billing_id,mode_of_payment,payment_due_date,billing_timestamp,insurance_number," 
					+ " payer_name,bill_amount,createdBy,createdDate,modifiedBy,modifiedDate"
					+ " FROM tblBilling"
					+ " WHERE billing_id LIKE ?";
			logger.info("BillDAO.getAlBillDetails() - "+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + billing_id + "%");
			rs = pstmt.executeQuery();
			Bill billObj = null;
			while (rs.next()) {
				billObj = new Bill();
				billObj.setBillId(rs.getInt("billing_id"));
				billObj.setmodeofpay(rs.getString("mode_of_payment"));
				billObj.setpaymentduedate(rs.getString("payment_due_date"));
				billObj.setbillingtime(rs.getString("billing_timestamp"));
				billObj.setinsurancenumber(rs.getString("insurance_number"));
				billObj.setinsurancenumber(rs.getString("insurance_number"));
				billObj.setpayername(rs.getString("payer_name"));
				billObj.setbillamount(rs.getString("bill_amount"));
				billObj.setCreatedBy(rs.getString("createdBy"));
				billObj.setCreatedDate(rs.getString("createdDate"));
				billObj.setModifiedBy(rs.getString("modifiedBy"));
				billObj.setModifiedDate(rs.getString("modifiedDate"));
				billDetails.add(billObj);
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
		logger.info("BillDAO.getAlBillDetails() ends");
		return billDetails;
	}

}
