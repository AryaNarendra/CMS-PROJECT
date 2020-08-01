package com.dxc.canteenManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class OrdersDAO {

	
	public String placeOrder(int cusId, int venId, String walSource,int menId, String ordDate, int ordQuantity) throws SQLException, ParseException {
		Connection con = ConnectionHelper.getConnection();
		int menPrice = 0, billAmount = 0;
		String cmd = "SELECT MEN_PRICE FROM MENU WHERE MEN_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst = con.prepareStatement(cmd);
		pst.setInt(1, menId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		menPrice = rs.getInt("MEN_PRICE");
		billAmount = menPrice*ordQuantity;
	
		int walAmount=0;
		cmd = "SELECT WAL_AMOUNT FROM WALLET WHERE CUS_ID=? AND WAL_SOURCE=? ";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, cusId);
		pst.setString(2, walSource);
		ResultSet res = pst.executeQuery();
		res.next();
		walAmount = res.getInt("WAL_AMOUNT");
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(formatter.format(date));
		
		String sDate1=ordDate;  
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
	    java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
		
	    
	    if (date.compareTo(date1) < 0) {
			
		
		if (billAmount<walAmount) {
			cmd = "INSERT INTO ORDERS(CUS_ID,VEN_ID,WAL_SOURCE,MEN_ID,ORD_DATE,ORD_QUANTITY,ORD_BILLAMOUNT) VALUES(?,?,?,?,?,?,?)";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, cusId);
			pst.setInt(2, venId);
			pst.setString(3, walSource);
			pst.setInt(4, menId);
			pst.setDate(5, sqlDate);
			pst.setInt(6, ordQuantity);
			pst.setDouble(7,billAmount);
			pst.executeUpdate();
			
			return "Order Placed";
		} else return "Insufficient Funds";
	
		} else return "Order Cannot be placed on past date";
	}
	
	@SuppressWarnings("resource")
	public String approveDeny(int ordId, int venId, String ordStatus, String ordComments) throws SQLException {
		Orders order = searchOrder(ordId);
		Vendor vendor = new VendorDAO().searchvendor(venId);
		Connection con = ConnectionHelper.getConnection();
		
		if (vendor.getVenId()==order.getVenId()) {
			
			String cmd = "SELECT WAL_AMOUNT FROM WALLET WHERE  CUS_ID=? AND WAL_SOURCE=? " ;
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, order.getCusId());
			pst.setString(2, order.getWalSource());
			ResultSet rs = pst.executeQuery();
			rs.next();
			double walAmount = rs.getDouble("WAL_AMOUNT");

			if (ordStatus.toUpperCase().equals("YES") && order.getOrdBillAmount() <= walAmount) {
				OrdStatus oS = OrdStatus.ACCEPTED;
				cmd = "Update Orders SET ORD_STATUS=?, ORD_COMMENTS=? WHERE ORD_ID=?";
				pst = con.prepareStatement(cmd);
				pst.setString(1, oS.toString());
				pst.setString(2, ordComments);
				pst.setInt(3, ordId);
				pst.executeUpdate();
				
				double newAmount = walAmount - order.getOrdBillAmount();
				WalSource ws = WalSource.valueOf(order.getWalSource());
				cmd = "Update WALLET set WAL_AMOUNT=? WHERE WAL_SOURCE=? AND CUS_ID=?";
				pst = con.prepareStatement(cmd);
				pst.setDouble(1,newAmount);
				pst.setString(2, ws.toString());
				pst.setInt(3, order.getCusId());
				pst.executeUpdate();
				
				return "ORDER ACCEPTED...";
			} else {
				OrdStatus oS = OrdStatus.DENIED;
				cmd = "Update Orders SET ORD_STATUS=?, ORD_COMMENTS=? WHERE ORD_ID=?";
				pst = con.prepareStatement(cmd);
				pst.setString(1, oS.toString());
				pst.setString(2, ordComments);
				pst.setInt(3, ordId);
				pst.executeUpdate();
				return "ORDER DENIED...";
			}
		} else {
			return "Unauthorized Vendor...";
		}
	}

	public Orders searchOrder(int ordId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Select * from Orders WHERE ORD_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, ordId);
		ResultSet rs = pst.executeQuery();
		Orders order = null;
		if (rs.next()) {
			order = new Orders();
			order.setOrdId(rs.getInt("ORD_ID"));
			order.setCusId(rs.getInt("CUS_ID"));
			order.setVenId(rs.getInt("VEN_ID"));
			order.setWalSource(rs.getString("WAL_SOURCE"));
			order.setMenId(rs.getInt("MEN_ID"));
			order.setOrdDate(rs.getDate("ORD_DATE"));
			order.setOrdQuantity(rs.getInt("ORD_QUANTITY"));
			order.setOrdBillAmount(rs.getDouble("ORD_BILLAMOUNT"));
			OrdStatus oS = OrdStatus.valueOf(rs.getString("ORD_STATUS"));
			order.setOrdStatus(oS);
			order.setOrdComments(rs.getString("ORD_COMMENTS"));
		}
		return order;
	}
	
	public List<Orders> customerHistory(int cusId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Select * from Orders WHERE CUS_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, cusId);
		ResultSet rs = pst.executeQuery();
		List<Orders> arr = new ArrayList<Orders>();
		Orders order = null;
		while(rs.next()) {
			order = new Orders();
			order.setOrdId(rs.getInt("ORD_ID"));
			order.setCusId(rs.getInt("CUS_ID"));
			order.setVenId(rs.getInt("VEN_ID"));
			order.setWalSource(rs.getString("WAL_SOURCE"));
			order.setMenId(rs.getInt("MEN_ID"));
			order.setOrdDate(rs.getDate("ORD_DATE"));
			order.setOrdQuantity(rs.getInt("ORD_QUANTITY"));
			order.setOrdBillAmount(rs.getDouble("ORD_BILLAMOUNT"));
			OrdStatus oS = OrdStatus.valueOf(rs.getString("ORD_STATUS"));
			order.setOrdStatus(oS);
			order.setOrdComments(rs.getString("ORD_COMMENTS"));
			arr.add(order);
		}
		return arr;
		
	}
	
	public List<Orders> vendorHistory(int venId) throws SQLException {
		Connection con = ConnectionHelper.getConnection();
		String cmd = "Select * from Orders WHERE VEN_ID=?";
		PreparedStatement pst = con.prepareStatement(cmd);
		pst.setInt(1, venId);
		ResultSet rs = pst.executeQuery();
		List<Orders> arr = new ArrayList<Orders>();
		Orders order = null;
		while(rs.next()) {
			order = new Orders();
			order.setOrdId(rs.getInt("ORD_ID"));
			order.setCusId(rs.getInt("CUS_ID"));
			order.setVenId(rs.getInt("VEN_ID"));
			order.setWalSource(rs.getString("WAL_SOURCE"));
			order.setMenId(rs.getInt("MEN_ID"));
			order.setOrdDate(rs.getDate("ORD_DATE"));
			order.setOrdQuantity(rs.getInt("ORD_QUANTITY"));
			order.setOrdBillAmount(rs.getDouble("ORD_BILLAMOUNT"));
			OrdStatus oS = OrdStatus.valueOf(rs.getString("ORD_STATUS"));
			order.setOrdStatus(oS);
			order.setOrdComments(rs.getString("ORD_COMMENTS"));
			arr.add(order);
		}
		return arr;
		
	}
}	