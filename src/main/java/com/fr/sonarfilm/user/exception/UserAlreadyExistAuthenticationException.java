package com.fr.sonarfilm.user.exception;

import org.springframework.security.core.AuthenticationException;

public class UserAlreadyExistAuthenticationException extends AuthenticationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8469956785790708987L;

	public UserAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }

}