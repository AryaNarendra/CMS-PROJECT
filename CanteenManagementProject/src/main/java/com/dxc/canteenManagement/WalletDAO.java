package com.dxc.canteenManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class WalletDAO {

	public Wallet showByWalId(int walId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from Wallet where WAL_ID=?");
		pst.setInt(1, walId);
		ResultSet rs=pst.executeQuery();
		Wallet w = null;
		if(rs.next()) {
			w=new Wallet();
			w.setCusId(rs.getInt("CUS_ID"));
			w.setWalId(rs.getInt("WAL_ID"));
			w.setWalAmount(rs.getDouble("WAL_AMOUNT"));
			WalSource ws = WalSource.valueOf(rs.getString("WAL_SOURCE"));
			w.setWalSource(ws);
		}
		return w;
	}
	
	public Wallet[] showByCusId(int cusId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		PreparedStatement pst=con.prepareStatement("select count(*) cnt from Wallet where CUS_ID=?");
		pst.setInt(1, cusId);
		ResultSet rs=pst.executeQuery();
		rs.next(); 
		int cnt=rs.getInt("cnt"); 
		Wallet[] arr=new Wallet[cnt]; 
		pst=con.prepareStatement("select * from Wallet where CUS_ID=?"); 
		pst.setInt(1, cusId);
		rs=pst.executeQuery();
		int i=0;
		Wallet w=null;
		while(rs.next()) {
			w=new Wallet();
			w.setCusId(rs.getInt("CUS_ID"));
			w.setWalId(rs.getInt("WAL_ID"));
			w.setWalAmount(rs.getDouble("WAL_AMOUNT"));
			WalSource ws = WalSource.valueOf(rs.getString("WAL_SOURCE"));
			w.setWalSource(ws);
			arr[i]=w;
			i++;
		}
		return arr;
	}
}
