package com.dxc.canteenManagement;

import java.util.Date;

public class Orders {

	private int ordId;
	private int cusId;
	private int venId;
	private String walSource;
	private int menId;
	private Date ordDate;
	private int ordQuantity;
	private double ordBillAmount;
	private OrdStatus ordStatus;
	private String ordComments;
	
	public Orders() {
	}

	public Orders(int ordId, int cusId, int venId, String walSource, int menId, Date ordDate, int ordQuantity,
			double ordBillAmount, OrdStatus ordStatus, String ordComments) {
		super();
		this.ordId = ordId;
		this.cusId = cusId;
		this.venId = venId;
		this.walSource = walSource;
		this.menId = menId;
		this.ordDate = ordDate;
		this.ordQuantity = ordQuantity;
		this.ordBillAmount = ordBillAmount;
		this.ordStatus = ordStatus;
		this.ordComments = ordComments;
	}

	@Override
	public String toString() {
		return "Orders [ordId=" + ordId + ", cusId=" + cusId + ", venId=" + venId + ", walSource=" + walSource
				+ ", menId=" + menId + ", ordDate=" + ordDate + ", ordQuantity=" + ordQuantity + ", ordBillAmount="
				+ ordBillAmount + ", ordStatus=" + ordStatus + ", ordComments=" + ordComments + "]";
	}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getWalSource() {
		return walSource;
	}

	public void setWalSource(String walSource) {
		this.walSource = walSource;
	}

	public int getMenId() {
		return menId;
	}

	public void setMenId(int menId) {
		this.menId = menId;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public int getOrdQuantity() {
		return ordQuantity;
	}

	public void setOrdQuantity(int ordQuantity) {
		this.ordQuantity = ordQuantity;
	}

	public double getOrdBillAmount() {
		return ordBillAmount;
	}

	public void setOrdBillAmount(double ordBillAmount) {
		this.ordBillAmount = ordBillAmount;
	}

	public OrdStatus getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(OrdStatus ordStatus) {
		this.ordStatus = ordStatus;
	}

	public String getOrdComments() {
		return ordComments;
	}

	public void setOrdComments(String ordComments) {
		this.ordComments = ordComments;
	}
	
	
	
}
