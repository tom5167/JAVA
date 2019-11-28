package patientCarePOJO;

import patientCareConstants.CommonConstants;

public class Staff {
	
	private int staffId = CommonConstants.ZERO;
	private String firstName = CommonConstants.EMPTY_STRING;
	private String lastName = CommonConstants.EMPTY_STRING;
	private String staffType = CommonConstants.EMPTY_STRING;
	private String joinDate = CommonConstants.EMPTY_STRING;
	private String availableHours = CommonConstants.EMPTY_STRING;
	private String position = CommonConstants.EMPTY_STRING;
	private String highestQualification = CommonConstants.EMPTY_STRING;
	private String specialization = CommonConstants.EMPTY_STRING;
	private String createdBy = CommonConstants.EMPTY_STRING;
	private String createdDate = CommonConstants.EMPTY_STRING;
	private String modifiedBy = CommonConstants.EMPTY_STRING;
	private String modifiedDate = CommonConstants.EMPTY_STRING;
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getAvailableHours() {
		return availableHours;
	}
	public void setAvailableHours(String availableHours) {
		this.availableHours = availableHours;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
