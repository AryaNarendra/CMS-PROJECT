package com.dxc.canteenManagement;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/menu")
public class MenuRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Menu[] showMenu() throws SQLException {
		Menu[] result = new MenuDAO().showMenu();
		return result;
	}
	
	@GET
	@Path("/search/{menId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Menu search(@PathParam("menId") int menId) throws SQLException {
		Menu res = new MenuDAO().searchmenu(menId);
		return res;
	}
}
