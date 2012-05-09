#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.dto.rs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.tutorials.errors.dto.ErrorDTO;
import ${package}.dto.PersonDTO;

/**
 * @author a.benkirane
 *
 */
@XmlRootElement(name="viewpersonrs")
public class ViewPersonRS {

	@XmlElement(nillable=true)
	protected PersonDTO personDTO;

	private List<ErrorDTO> erreurs;	

	public ViewPersonRS() {
		super();
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
	
	public void setPerson(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}
	
}
