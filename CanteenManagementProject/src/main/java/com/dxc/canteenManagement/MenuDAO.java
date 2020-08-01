package com.dxc.canteenManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MenuDAO {
	public Menu[] showMenu() throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		PreparedStatement pst=con.prepareStatement("select count(*) cnt from Menu");
		ResultSet rs=pst.executeQuery();
		rs.next(); 
		int cnt=rs.getInt("cnt"); 
		Menu[] arr=new Menu[cnt]; 
		pst=con.prepareStatement("select * from Menu"); 
		rs=pst.executeQuery();
		int i=0;
		Menu e=null;
		while(rs.next()) {
			e=new Menu();
			e.setMenId(rs.getInt("MEN_ID"));
			e.setMenItem(rs.getString("MEN_ITEM"));
			e.setMenPrice(rs.getInt("MEN_PRICE"));
			e.setMenCalories(rs.getInt("MEN_CALORIES"));
			e.setMenSpeciality(rs.getString("MEN_SPECIALITY"));
			arr[i]=e;
			i++;
		}
		return arr;

	}
	
	public Menu searchmenu(int menId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Select * from MENU WHERE MEN_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, menId);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
		if (rs.next()) {
			menu = new Menu();
			menu.setMenId(rs.getInt("MEN_ID"));
			menu.setMenItem(rs.getString("MEN_ITEM"));
			menu.setMenPrice(rs.getInt("MEN_PRICE"));
			menu.setMenCalories(rs.getInt("MEN_CALORIES"));
			menu.setMenSpeciality(rs.getString("MEN_SPECIALITY"));	
		}
		return menu;
	}
}
