package it.pkg.dto.rs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.pkg.dto.PersonDTO;

@XmlRootElement(name="searchpersonrs")
public class SearchPersonRS {

	private List<PersonDTO> persons;
	
	public SearchPersonRS() {
		super();
	}
	
	@XmlElement(name="person")
	public List<PersonDTO> getPersons() {
		if(persons == null) {
			persons = new ArrayList<PersonDTO>();
		}
		return persons;
	}

	public void setPersons(List<PersonDTO> persons) {
		this.persons = persons;
	}
	
}
