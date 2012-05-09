#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.rs.impl;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Required;

import org.tutorials.errors.dto.ErrorDTO;
import ${package}.dto.PersonDTO;
import ${package}.dto.rs.CreatePersonRS;
import ${package}.dto.rs.SearchPersonRS;
import ${package}.dto.rs.ViewPersonRS;
import ${package}.rs.${parentArtifactId};
import ${package}.services.PersonService;
import ${package}.services.exceptions.PersonBusinessException;

/**
 * @author a.benkirane
 *
 */
@WebService(endpointInterface = "org.tutorials.rs.persons.${parentArtifactId}")
public class ${parentArtifactId}Impl implements ${parentArtifactId} {


	private PersonService personService;
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	public CreatePersonRS createPerson(String uid, String lastName, String givenName,
			String fullName, String email, String client) {
		CreatePersonRS response = new CreatePersonRS();
		PersonDTO personDTO = new PersonDTO();
		personDTO.setUid(uid);
		personDTO.setLastName(lastName);
		personDTO.setGivenName(givenName);
		personDTO.setFullName(fullName);
		personDTO.setEmail(email);
		personDTO.setClient(client);

		PersonDTO personCreated;
		try {
			personCreated = personService.createPerson(personDTO);
			response.setPerson(personCreated);
		} catch (PersonBusinessException e) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setErrorCode(e.ErrorCode());
			errorDTO.setErrorMessage(e.getMessage());
			
			response.getErreurs().add(errorDTO);
		}
		
		return response;
	}


	public SearchPersonRS searchPerson(String name) {
		SearchPersonRS searchPersonRS = new SearchPersonRS();

		List<PersonDTO> personsFound = personService.searchPerson(name);

		searchPersonRS.setPersons(personsFound);

		return searchPersonRS;
	}


	public ViewPersonRS viewPerson(String dn) {
		ViewPersonRS viewPersonRS = new ViewPersonRS();

		PersonDTO personFoundDTO = null;
		try {
			personFoundDTO = personService.viewPerson(dn);
		} catch (PersonBusinessException pbe) {
			ErrorDTO erreur = new ErrorDTO();
			erreur.setErrorCode(pbe.ErrorCode());
			erreur.setErrorMessage(pbe.getMessage());
			viewPersonRS.getErreurs().add(erreur);
		}

		viewPersonRS.setPerson(personFoundDTO);

		return viewPersonRS;
	}


	// Spring injections
	@Required
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}
