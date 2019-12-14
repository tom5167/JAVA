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
package patientCareBusinessLogic;

import java.util.List;

import patientCareDAO.BillDAO;
import patientCarePOJO.Bill;

public class BillLogic {
	BillDAO billDAO = new BillDAO();

	public List<Bill> getAlBillDetails(String firstName) {
		return billDAO.getAlBillDetails(firstName);
	}
	
	public List<Bill> getAlBillDetailsUser() {
		return billDAO.getAlBillDetailsUser();
	}
	
	public boolean saveBillDetails(Bill billDetails) {
		if(billDetails.getBillId() < 1) {
			return billDAO.insertBillDetails(billDetails);
		} else {
			return billDAO.updateBillDetails(billDetails);
		}
	}
	
	public boolean deleteBillDetails(Bill billDetails) {
		return billDAO.deleteBillDetails(billDetails);
	}


}
