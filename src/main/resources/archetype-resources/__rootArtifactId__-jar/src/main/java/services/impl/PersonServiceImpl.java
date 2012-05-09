#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import ${package}.dao.PersonDao;
import ${package}.dao.exceptions.TechnicalException;
import ${package}.dao.model.Person;
import ${package}.dto.PersonDTO;
import ${package}.services.PersonService;
import ${package}.services.exceptions.PersonBusinessException;
import ${package}.services.transformers.PersonDTOTransformer;

/**
 * @author a.benkirane
 *
 */
public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;
	private PersonDTOTransformer personDTOTransformer;


	public PersonDTO createPerson(PersonDTO personDTO) throws PersonBusinessException {
		Person personToCreate = (Person)personDTOTransformer.transform(personDTO);
		
		personDao.create(personToCreate);
		
		return viewPerson(personDao.buildDn(personToCreate.getUid(), personToCreate.getClient()).toString());
	}
	
	public List<PersonDTO> searchPerson(String name) {
		List<Person> personsFound = personDao.findByName(name);
		List<PersonDTO> personsDTOFound = new ArrayList<PersonDTO>();
		
		for(Iterator<Person> itPersons = personsFound.iterator(); itPersons.hasNext(); ) {
			Person currentPerson = (Person)itPersons.next();
			PersonDTO personDTO = (PersonDTO)personDTOTransformer.transform(currentPerson);
			
			personsDTOFound.add(personDTO);
		}
		
		return personsDTOFound;
	}

	public PersonDTO viewPerson(String dn) throws PersonBusinessException {
		PersonDTO personDTOFound = null;
		
		try {
			Person personFound = personDao.findByPrimaryKey(dn);
			personDTOFound = (PersonDTO)personDTOTransformer.transform(personFound);
		} catch (TechnicalException e) {
			throw new PersonBusinessException("ERR-DN-000", "Impossible de trouver la personne avec l'identifiant recherché !");
		}
		
		return personDTOFound;
	}

	
	
	// Spring injections
	@Required
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Required
	public void setPersonDTOTransformer(PersonDTOTransformer personDTOTransformer) {
		this.personDTOTransformer = personDTOTransformer;
	}
	
	
}
