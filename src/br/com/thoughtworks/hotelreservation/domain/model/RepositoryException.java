package br.com.thoughtworks.hotelreservation.domain.model;

public class RepositoryException extends RuntimeException {

	private static final long serialVersionUID = 400787078695212039L;
	
	public RepositoryException() {

		super();
	}

	public RepositoryException(final String message) {

		super(message);
	}

	public RepositoryException(final Exception exception) {

		super(exception);
	}

	public RepositoryException(final String message, final Exception exception) {

		super(message, exception);
	}

}

