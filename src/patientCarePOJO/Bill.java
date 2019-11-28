package patientCarePOJO;

import patientCareConstants.CommonConstants;

public class Bill {
	private int billId = CommonConstants.ZERO;
	private String createdBy = CommonConstants.EMPTY_STRING;
	private String createdDate = CommonConstants.EMPTY_STRING;
	private String modifiedBy = CommonConstants.EMPTY_STRING;
	private String modifiedDate = CommonConstants.EMPTY_STRING;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
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
