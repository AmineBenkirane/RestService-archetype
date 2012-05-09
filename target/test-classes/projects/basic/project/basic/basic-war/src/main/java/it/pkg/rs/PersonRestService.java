/**
 * 
 */
package it.pkg.rs;

import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import it.pkg.dto.rs.CreatePersonRS;
import it.pkg.dto.rs.SearchPersonRS;
import it.pkg.dto.rs.ViewPersonRS;

/**
 * @author a.benkirane
 *
 */

@Service("basic")
@Path("/personRestService")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface basic {

	@Path("/createPerson/")
	@WebMethod
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public CreatePersonRS createPerson(@FormParam("uid") String uid, 
			@FormParam("lastName") String lastName,
			@FormParam("givenName") String givenName,
			@FormParam("fullName") String fullName,
			@FormParam("email") String email,
			@FormParam("client") String client);

	@Path("/searchPersonByName/{name}")
	@WebMethod
	@GET
	public SearchPersonRS searchPerson(@PathParam ("name") String name);

	@Path("/searchOnePerson/{dn}")
	@WebMethod
	@GET
	public ViewPersonRS viewPerson(@PathParam ("dn") String dn);
}
