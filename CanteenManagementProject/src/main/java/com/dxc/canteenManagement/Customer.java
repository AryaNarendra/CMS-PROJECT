package com.dxc.canteenManagement;

public class Customer {
	private int cusId;
	private String cusName;
	private String cusPhno;
	private String cusUserName;
	private String cusPassword;
	private String cusEmail;

	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusPhno() {
		return cusPhno;
	}
	public void setCusPhno(String cusPhno) {
		this.cusPhno = cusPhno;
	}
	public String getCusUserName() {
		return cusUserName;
	}
	public void setCusUserName(String cusUserName) {
		this.cusUserName = cusUserName;
	}
	public String getCusPassword() {
		return cusPassword;
	}
	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	
	public Customer(int cusId, String cusName, String cusPhno, String cusUserName, String cusPassword,
			String cusEmail) {
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPhno = cusPhno;
		this.cusUserName = cusUserName;
		this.cusPassword = cusPassword;
		this.cusEmail = cusEmail;
	}
	
	public Customer() {
	}
	
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusPhno=" + cusPhno + ", cusUserName="
				+ cusUserName + ", cusPassword=" + cusPassword + ", cusEmail=" + cusEmail + "]";
	}
}
