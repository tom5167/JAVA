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

import patientCareDAO.DiagnosisDAO;
import patientCarePOJO.Diagnosis;

public class DiagnosisLogic {
	DiagnosisDAO diagnosisDAO = new DiagnosisDAO();

	public List<Diagnosis> getAlDiagnosisDetails(String firstName) {
		return diagnosisDAO.getAlDiagnosisDetails(firstName);
	}
	
	public boolean saveDiagnosisDetails(Diagnosis diagnosisDetails) {
		if(diagnosisDetails.getDiagnosisId() < 1) {
			return diagnosisDAO.insertDiagnosisDetails(diagnosisDetails);
		} else {
			return diagnosisDAO.updateDiagnosisDetails(diagnosisDetails);
		}
	}
	
	public boolean deleteDiagnosisDetails(Diagnosis diagnosisDetails) {
		return diagnosisDAO.deleteDiagnosisDetails(diagnosisDetails);
	}

}
