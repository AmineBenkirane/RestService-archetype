/**
 * 
 */
package it.pkg.dto.rs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.tutorials.errors.dto.ErrorDTO;
import it.pkg.dto.PersonDTO;

/**
 * @author a.benkirane
 *
 */
@XmlRootElement(name="createpersonrs")
public class CreatePersonRS {

	private PersonDTO person;
	private List<ErrorDTO> erreurs;
	
	public CreatePersonRS() {
		super();
	}
	
	@XmlElement(name="personDTO")
	public PersonDTO getPersonDTO() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	
	@XmlElement(nillable=true)
	public List<ErrorDTO> getErreurs() {
		if(erreurs == null) {
			erreurs = new ArrayList<ErrorDTO>();
		}
		return erreurs;
	}

	public void setErreurs(List<ErrorDTO> erreurs) {
		this.erreurs = erreurs;
	}
	
}
