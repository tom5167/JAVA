package patientCarePOJO;

import patientCareConstants.CommonConstants;

public class Event {
	private int eventId = CommonConstants.ZERO;
	private int patientId = CommonConstants.ZERO;
	private String pFirstName = CommonConstants.EMPTY_STRING;
	private String pLastName = CommonConstants.EMPTY_STRING;
	private int doctorId = CommonConstants.ZERO;
	private String dFirstName = CommonConstants.EMPTY_STRING;
	private String dLastName = CommonConstants.EMPTY_STRING;
	private String eventType = CommonConstants.EMPTY_STRING;
	private String eventDate = CommonConstants.EMPTY_STRING;
	private String eventTime = CommonConstants.EMPTY_STRING;
	private String createdBy = CommonConstants.EMPTY_STRING;
	private String createdDate = CommonConstants.EMPTY_STRING;
	private String modifiedBy = CommonConstants.EMPTY_STRING;
	private String modifiedDate = CommonConstants.EMPTY_STRING;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getpFirstName() {
		return pFirstName;
	}
	public void setpFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}
	public String getpLastName() {
		return pLastName;
	}
	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getdFirstName() {
		return dFirstName;
	}
	public void setdFirstName(String dFirstName) {
		this.dFirstName = dFirstName;
	}
	public String getdLastName() {
		return dLastName;
	}
	public void setdLastName(String dLastName) {
		this.dLastName = dLastName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
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
