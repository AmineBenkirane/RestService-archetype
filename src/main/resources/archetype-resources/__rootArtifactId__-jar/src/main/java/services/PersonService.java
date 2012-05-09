#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.services;

import java.util.List;

import ${package}.services.exceptions.PersonBusinessException;

import ${package}.dto.PersonDTO;


/**
 * @author a.benkirane
 *
 */
public interface PersonService {

	public PersonDTO createPerson(PersonDTO person)  throws PersonBusinessException;

	public List<PersonDTO> searchPerson(String name);
	
	public PersonDTO viewPerson(String dn) throws PersonBusinessException;
}
