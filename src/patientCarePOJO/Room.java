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

public class Room {
	private int roomNumber = CommonConstants.ZERO;
	private int totalBeds = CommonConstants.ZERO;
	private int occupiedBeds = CommonConstants.ZERO;
	private String roomType = CommonConstants.EMPTY_STRING;
	private String buildingNumber = CommonConstants.EMPTY_STRING;
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}

	public int getOccupiedBeds() {
		return occupiedBeds;
	}

	public void setOccupiedBeds(int occupiedBeds) {
		this.occupiedBeds = occupiedBeds;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	
}
