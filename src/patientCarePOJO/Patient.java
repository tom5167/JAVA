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
package patientCarePOJO;

import patientCareConstants.CommonConstants;

public class Patient {
	
	private int patientId = CommonConstants.ZERO;
	private String firstName = CommonConstants.EMPTY_STRING;
	private String lastName = CommonConstants.EMPTY_STRING;
	private String sex = CommonConstants.EMPTY_STRING;
	private String dob = CommonConstants.EMPTY_STRING;
	private String streetNumber = CommonConstants.EMPTY_STRING;
	private String addressFull = CommonConstants.EMPTY_STRING;
	private String city = CommonConstants.EMPTY_STRING;
	private String country = CommonConstants.EMPTY_STRING;
	private String postalCode = CommonConstants.EMPTY_STRING;
	private String sinId = CommonConstants.EMPTY_STRING;
	private String contactNumber = CommonConstants.EMPTY_STRING;
	private String alternativeNumber = CommonConstants.EMPTY_STRING;
	private String insuranceId = CommonConstants.EMPTY_STRING;
	private String emailId = CommonConstants.EMPTY_STRING;
	private String bloodGroup = CommonConstants.EMPTY_STRING;
	private String maritalStatus = CommonConstants.EMPTY_STRING;
	private String createdBy = CommonConstants.EMPTY_STRING;
	private String createdDate = CommonConstants.EMPTY_STRING;
	private String modifiedBy = CommonConstants.EMPTY_STRING;
	private String modifiedDate = CommonConstants.EMPTY_STRING;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getAddressFull() {
		return addressFull;
	}
	public void setAddressFull(String addressFull) {
		this.addressFull = addressFull;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getSinId() {
		return sinId;
	}
	public void setSinId(String sinId) {
		this.sinId = sinId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAlternativeNumber() {
		return alternativeNumber;
	}
	public void setAlternativeNumber(String alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
		
}
