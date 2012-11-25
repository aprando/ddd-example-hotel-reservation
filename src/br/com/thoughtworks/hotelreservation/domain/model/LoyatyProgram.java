package br.com.thoughtworks.hotelreservation.domain.model;

import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class LoyatyProgram implements Entity {

	public static final String REGULAR_TYPE = "Regular";
	public static final String REWARDS_TYPE = "Rewards";

	private Long id;

	private String details;

	public LoyatyProgram() {
		super();
	}

	/**
	 * Return a LoyatyProgram detached.
	 * 
	 * @param id
	 * @param details
	 */
	public LoyatyProgram(Long id, String details) {
		super();
		this.id = id;
		this.details = details;
	}

	public Long id() {
		return this.id;
	}

	public String details() {
		return this.details;
	}

	@Override
	public boolean isManaged() {
		return false;
	}
}
