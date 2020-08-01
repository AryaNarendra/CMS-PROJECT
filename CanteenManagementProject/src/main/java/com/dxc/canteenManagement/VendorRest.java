package com.dxc.canteenManagement;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vendor")
public class VendorRest {

	@POST
	@Path("/validate/{user}/{passcode}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int validate(@PathParam("user") String user, @PathParam("passcode") String passcode) throws SQLException {
		VendorDAO dao = new VendorDAO();
		return dao.authenticate(user, passcode);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Vendor[] showvendor() throws SQLException {
		Vendor[] res = new VendorDAO().showvendor();
		return res;
	}
	
	@GET
	@Path("/searchvendor/{venId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vendor searchvendor(@PathParam("venId") int venId) throws SQLException {
		Vendor res = new VendorDAO().searchvendor(venId);
		return res;
	}
}
