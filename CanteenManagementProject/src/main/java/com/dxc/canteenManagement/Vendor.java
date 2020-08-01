package com.dxc.canteenManagement;

public class Vendor {

	private int venId;
	private String venName;
	private String venPhnNo;
	private String venUsername;
	private String venPassword;
	private String venEmail;
	
	public Vendor() {
	}

	public Vendor(int venId, String venName, String venPhnNo, String venUsername, String venPassword, String venEmail) {
		super();
		this.venId = venId;
		this.venName = venName;
		this.venPhnNo = venPhnNo;
		this.venUsername = venUsername;
		this.venPassword = venPassword;
		this.venEmail = venEmail;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venPhnNo=" + venPhnNo + ", venUsername="
				+ venUsername + ", venPassword=" + venPassword + ", venEmail=" + venEmail + "]";
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenPhnNo() {
		return venPhnNo;
	}

	public void setVenPhnNo(String venPhnNo) {
		this.venPhnNo = venPhnNo;
	}

	public String getVenUsername() {
		return venUsername;
	}

	public void setVenUsername(String venUsername) {
		this.venUsername = venUsername;
	}

	public String getVenPassword() {
		return venPassword;
	}

	public void setVenPassword(String venPassword) {
		this.venPassword = venPassword;
	}

	public String getVenEmail() {
		return venEmail;
	}

	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}
	
	
}
