package com.stepupit.reminder.exceptions;

/**
 *
 * @author ank
 */

public class RegistrationExceptions extends Exception {

	private static final long serialVersionUID = -8515034456417992020L;

	public RegistrationExceptions() {
		super();
	}

	public RegistrationExceptions(String message) {
		super(message);
	}

	public RegistrationExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public RegistrationExceptions(Throwable cause) {
		super(cause);
	}

}
