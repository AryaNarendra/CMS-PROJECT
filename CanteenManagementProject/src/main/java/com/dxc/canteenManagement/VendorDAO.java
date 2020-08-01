package com.dxc.canteenManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorDAO {

	public int authenticate(String user, String password) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from Vendor where VEN_USERNAME=? "
				+ " AND VEN_PASSWORD=?";
		PreparedStatement  pst = con.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int cnt = rs.getInt("cnt");
		return cnt;
	}
	
	public Vendor[] showvendor() throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		PreparedStatement pst=con.prepareStatement("select count(*) cnt from vendor");
		ResultSet rs=pst.executeQuery();
		rs.next(); 
		int cnt=rs.getInt("cnt"); 
		Vendor[] arr=new Vendor[cnt]; 
		pst=con.prepareStatement("select * from vendor"); 
		rs=pst.executeQuery();
		int i=0;
		Vendor v=null;
		while(rs.next()) {
			v=new Vendor();
			v.setVenId(rs.getInt("VEN_ID"));
			v.setVenName(rs.getString("VEN_NAME"));
			v.setVenPhnNo(rs.getString("VEN_PHN_NO"));
			v.setVenUsername(rs.getString("VEN_USERNAME"));
			v.setVenPassword(rs.getString("VEN_PASSWORD"));
			v.setVenEmail(rs.getString("VEN_EMAIL"));
			arr[i]=v;
			i++;
		}
		return arr;

	}
	
	public Vendor searchvendor(int venId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Select * from vendor WHERE VEN_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, venId);
		ResultSet rs = pst.executeQuery();
		Vendor v = null;
		if (rs.next()) {
			v=new Vendor();
			v.setVenId(rs.getInt("VEN_ID"));
			v.setVenName(rs.getString("VEN_NAME"));
			v.setVenPhnNo(rs.getString("VEN_PHN_NO"));
			v.setVenUsername(rs.getString("VEN_USERNAME"));
			v.setVenPassword(rs.getString("VEN_PASSWORD"));
			v.setVenEmail(rs.getString("VEN_EMAIL"));
		}
		return v;
	}
}
