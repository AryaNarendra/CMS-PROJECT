package com.dxc.canteenManagement;

public class Menu {

	private int menId;
	private String menItem;
	private int menPrice;
	private int menCalories;
	private String menSpeciality;
	
	public int getMenId() {
		return menId;
	}
	public void setMenId(int menId) {
		this.menId = menId;
	}
	public String getMenItem() {
		return menItem;
	}
	public void setMenItem(String menItem) {
		this.menItem = menItem;
	}
	public int getMenPrice() {
		return menPrice;
	}
	public void setMenPrice(int menPrice) {
		this.menPrice = menPrice;
	}
	public int getMenCalories() {
		return menCalories;
	}
	public void setMenCalories(int menCalories) {
		this.menCalories = menCalories;
	}
	public String getMenSpeciality() {
		return menSpeciality;
	}
	public void setMenSpeciality(String menSpeciality) {
		this.menSpeciality = menSpeciality;
	}
	
	public Menu(int menId, String menItem, int menPrice, int menCalories, String menSpeciality) {
		this.menId = menId;
		this.menItem = menItem;
		this.menPrice = menPrice;
		this.menCalories = menCalories;
		this.menSpeciality = menSpeciality;
	}

	public Menu() {
	}
	@Override
	public String toString() {
		return "Menu [menId=" + menId + ", menItem=" + menItem + ", menPrice=" + menPrice + ", menCalories="
				+ menCalories + ", menSpeciality=" + menSpeciality + "]";
	}
	
}
