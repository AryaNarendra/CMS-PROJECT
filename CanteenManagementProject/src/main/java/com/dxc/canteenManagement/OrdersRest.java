package com.dxc.canteenManagement;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/order")
public class OrdersRest {

	
	@POST
	@Path("/set/{cusId}/{venId}/{walSource}/{menId}/{ordDate}/{ordQuantity}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String placeOrder(@PathParam("cusId") int cusId, @PathParam("venId") int venId, @PathParam("walSource") String walSource,@PathParam("menId") int menId, @PathParam("ordDate") String ordDate, @PathParam("ordQuantity") int ordQuantity ) throws SQLException, ParseException {
		String result = new OrdersDAO().placeOrder(cusId, venId, walSource, menId, ordDate, ordQuantity);
		return result;
	}
	
	@POST
	@Path("/confirm/{ordId}/{venId}/{ordStatus}/{ordComments}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String placeOrder(@PathParam("ordId") int ordId, @PathParam("venId") int venId, @PathParam("ordStatus") String ordStatus, @PathParam("ordComments") String ordComments ) throws SQLException, ParseException {
		String result = new OrdersDAO().approveDeny(ordId, venId, ordStatus, ordComments);
		return result;
	}
	@GET
	@Path("/customerhistory/{cusId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Orders> custHistory(@PathParam("cusId") int cusId) throws SQLException, ParseException {
		List<Orders> result = new OrdersDAO().customerHistory(cusId);
		return result;
	}
	@GET
	@Path("/vendorhistory/{venId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Orders> venHistory(@PathParam("venId") int venId) throws SQLException, ParseException {
		List<Orders> result = new OrdersDAO().vendorHistory(venId);
		return result;
	}
	
}
