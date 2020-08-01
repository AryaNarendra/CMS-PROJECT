package com.dxc.canteenManagement;

public class Wallet {

	private int cusId;
	private int walId;
	private double walAmount;
	private WalSource walSource;
	public Wallet() {
	}
	
	public Wallet(int cusId, int walId, double walAmount, WalSource walSource) {
		super();
		this.cusId = cusId;
		this.walId = walId;
		this.walAmount = walAmount;
		this.walSource = walSource;
	}
	
	@Override
	public String toString() {
		return "Wallet [cusId=" + cusId + ", walId=" + walId + ", walAmount=" + walAmount + ", walSource=" + walSource
				+ "]";
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public int getWalId() {
		return walId;
	}
	public void setWalId(int walId) {
		this.walId = walId;
	}
	public double getWalAmount() {
		return walAmount;
	}
	public void setWalAmount(double walAmount) {
		this.walAmount = walAmount;
	}
	public WalSource getWalSource() {
		return walSource;
	}
	public void setWalSource(WalSource walSource) {
		this.walSource = walSource;
	}
	
	
}
