#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.transformers;

import org.apache.commons.collections.Transformer;
import ${package}.dao.model.Person;
import ${package}.dto.PersonDTO;

public class PersonDTOTransformer implements Transformer {

	public Object transform(Object input) {
		if(input instanceof Person) {
			PersonDTO outputPersonDTO = new PersonDTO();
			Person inputPerson = (Person)input;
			
			outputPersonDTO.setUid(inputPerson.getUid());
			outputPersonDTO.setLastName(inputPerson.getLastName());
			outputPersonDTO.setGivenName(inputPerson.getGivenName());
			outputPersonDTO.setFullName(inputPerson.getFullName());
			outputPersonDTO.setEmail(inputPerson.getEmail());
			outputPersonDTO.setDistinguishedName(inputPerson.getDistinguishedName());
			outputPersonDTO.setClient(inputPerson.getClient());
			
			return outputPersonDTO;
		}
		else if(input instanceof PersonDTO) {
			Person outputPerson = new Person();
			PersonDTO inputPersonDTO = (PersonDTO)input;
			
			outputPerson.setUid(inputPersonDTO.getUid());
			outputPerson.setLastName(inputPersonDTO.getLastName());
			outputPerson.setGivenName(inputPersonDTO.getGivenName());
			outputPerson.setFullName(inputPersonDTO.getFullName());
			outputPerson.setEmail(inputPersonDTO.getEmail());
			outputPerson.setDistinguishedName(inputPersonDTO.getDistinguishedName());
			outputPerson.setClient(inputPersonDTO.getClient());
			
			return outputPerson;
		}
		
		return null;
	}

}
