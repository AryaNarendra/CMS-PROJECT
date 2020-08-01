package com.dxc.canteenManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	public int authenticate(String user, String password) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from Customer where CUS_USERNAME=? "
				+ " AND CUS_PASSWORD=?";
		PreparedStatement  pst = con.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int cnt = rs.getInt("cnt");
		return cnt;
	}
	
	public Customer[] showCustomer() throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		PreparedStatement pst=con.prepareStatement("select count(*) cnt from Customer");
		ResultSet rs=pst.executeQuery();
		rs.next(); 
		int cnt=rs.getInt("cnt"); 
		Customer[] arr=new Customer[cnt]; 
		pst=con.prepareStatement("select * from Customer"); 
		rs=pst.executeQuery();
		int i=0;
		Customer c=null;
		while(rs.next()) {
			c=new Customer();
			c.setCusId(rs.getInt("CUS_ID"));
			c.setCusName(rs.getString("CUS_NAME"));
			c.setCusPhno(rs.getString("CUS_PHN_NO"));
			c.setCusUserName(rs.getString("CUS_USERNAME"));
			c.setCusPassword(rs.getString("CUS_PASSWORD"));
			c.setCusEmail(rs.getString("CUS_EMAIL"));
			arr[i]=c;
			i++;
		}
		return arr;

	}
	
	public Customer searchCustomer(int cusId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Select * from CUSTOMER WHERE CUS_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, cusId);
		ResultSet rs = pst.executeQuery();
		Customer c = null;
		if (rs.next()) {
			c=new Customer();
			c.setCusId(rs.getInt("CUS_ID"));
			c.setCusName(rs.getString("CUS_NAME"));
			c.setCusPhno(rs.getString("CUS_PHN_NO"));
			c.setCusUserName(rs.getString("CUS_USERNAME"));
			c.setCusPassword(rs.getString("CUS_PASSWORD"));
			c.setCusEmail(rs.getString("CUS_EMAIL"));
		}
		return c;
	}
}
