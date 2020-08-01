package com.dxc.canteenManagement;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/wallet")
public class WalletRest {


		@GET
		@Path("/walletid/{walId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Wallet showByWalId(@PathParam("walId") int walId) throws SQLException {
			Wallet res = new WalletDAO().showByWalId(walId);
			return res;
		}
		
		@GET
		@Path("/cusid/{cusId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Wallet[] showByCusId(@PathParam("cusId") int cusId) throws SQLException {
			Wallet[] res = new WalletDAO().showByCusId(cusId);
			return res;
		}
}
