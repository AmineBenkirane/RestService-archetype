/**
 * 
 */
package it.pkg.services;

import java.util.List;

import it.pkg.services.exceptions.PersonBusinessException;

import it.pkg.dto.PersonDTO;


/**
 * @author a.benkirane
 *
 */
public interface PersonService {

	public PersonDTO createPerson(PersonDTO person)  throws PersonBusinessException;

	public List<PersonDTO> searchPerson(String name);
	
	public PersonDTO viewPerson(String dn) throws PersonBusinessException;
}
