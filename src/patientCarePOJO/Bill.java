package patientCarePOJO;

import patientCareConstants.CommonConstants;

public class Bill {
	private int billId = CommonConstants.ZERO;
	private String createdBy = CommonConstants.EMPTY_STRING;
	private String createdDate = CommonConstants.EMPTY_STRING;
	private String modifiedBy = CommonConstants.EMPTY_STRING;
	private String modifiedDate = CommonConstants.EMPTY_STRING;
	private String modeofpay = CommonConstants.EMPTY_STRING;
	private String paymentduedate = CommonConstants.EMPTY_STRING;
	private String billingtime = CommonConstants.EMPTY_STRING;
	private String insurancenumber = CommonConstants.EMPTY_STRING;
	private String payername = CommonConstants.EMPTY_STRING;
	private String billamount = CommonConstants.EMPTY_STRING;
	private String paymentstatus = CommonConstants.EMPTY_STRING;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getmodeofpay() {
		return modeofpay;
	}
	public void setmodeofpay(String modeofpay) {
		this.modeofpay = modeofpay;
	}
	public String getpaymentduedate() {
		return paymentduedate;
	}
	public void setpaymentduedate(String paymentduedate) {
		this.paymentduedate = paymentduedate;
	}
	public String getbillingtime() {
		return billingtime;
	}
	public void setbillingtime(String billingtime) {
		this.billingtime = billingtime;
	}
	public String getinsurancenumber() {
		return insurancenumber;
	}
	public void setinsurancenumber(String insurancenumber) {
		this.insurancenumber = insurancenumber;
	}
	public String getpayername() {
		return payername;
	}
	public void setpayername(String payername) {
		this.payername = payername;
	}
	public String getbillamount() {
		return billamount;
	}
	public void setbillamount(String billamount) {
		this.billamount = billamount;
	}
	public String getpaymentstatus() {
		return paymentstatus;
	}
	public void setpaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
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
