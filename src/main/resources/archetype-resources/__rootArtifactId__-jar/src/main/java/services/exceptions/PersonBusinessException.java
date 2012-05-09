#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.services.exceptions;


/**
 * @author a.benkirane
 *
 */
public class PersonBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5028430461472849893L;

	private String DEFAULT_MESSAGE ="Business Exception ";

	private String errorcode = "";

	private String message = "";

	
	public PersonBusinessException() {
		super();
	}

	public PersonBusinessException(String errorCode, String givenMessage){
		super(givenMessage);
		this.message = givenMessage;
		this.errorcode = errorCode;
	}
	public PersonBusinessException(Exception exception) {
		super(exception);
	}

	
	public final String getMessage() {
		return DEFAULT_MESSAGE + " " + ErrorCode() + ":" + getDetailledMessage();
	}

	public String getDetailledMessage() {
		return message;
	}

	/**
	 * @return the businessRules
	 */
	public String ErrorCode() {
		return this.errorcode;
	}



}
