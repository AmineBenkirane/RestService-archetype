/**
 * 
 */
package org.tutorials.errors.dto;

import javax.xml.bind.annotation.XmlType;

/**
 * @author a.benkirane
 *
 */
@XmlType(propOrder={"errorCode", "errorMessage"})
public class ErrorDTO {

	
	protected String errorCode;
	protected String errorMessage;
	
	public ErrorDTO() {
		super();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
