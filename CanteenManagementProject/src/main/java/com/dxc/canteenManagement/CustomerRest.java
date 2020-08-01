package com.dxc.canteenManagement;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerRest {

	@POST
	@Path("/validate/{user}/{passcode}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int validate(@PathParam("user") String user, @PathParam("passcode") String passcode) throws SQLException {
		CustomerDAO dao = new CustomerDAO();
		return dao.authenticate(user, passcode);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer[] showCustomers() throws SQLException {
		Customer[] res = new CustomerDAO().showCustomer();
		return res;
	}
	
	@GET
	@Path("/searchcustomer/{cusId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer searchvendor(@PathParam("cusId") int cusId) throws SQLException {
		Customer res = new CustomerDAO().searchCustomer(cusId);
		return res;
	}
}
