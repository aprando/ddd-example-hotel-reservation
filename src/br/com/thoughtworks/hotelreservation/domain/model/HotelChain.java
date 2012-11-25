package br.com.thoughtworks.hotelreservation.domain.model;

import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class HotelChain implements Entity {

	private Long id;

	private String name;
	
	/**
	 * Returns a HotelCheain detached.
	 * 
	 * @param id
	 * @param name
	 */
	public HotelChain(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Returns a HotelCheain detached.
	 */
	public HotelChain(){
		super();
	}

	public Long id() {
		return this.id;
	}

	public String name() {
		return this.name;
	}

	@Override
	public boolean isManaged() {
		return false;
	}

}
