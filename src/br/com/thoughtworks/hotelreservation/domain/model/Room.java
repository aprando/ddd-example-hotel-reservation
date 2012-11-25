package br.com.thoughtworks.hotelreservation.domain.model;

import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class Room implements Entity{

	private Long number;

	private Long floor;

	//Many-To-One Relationship.
	private Hotel hotel;
	
	public Long number(){
		return this.number;
	}

	public Hotel hotel(){
		return this.hotel;
	}

	public Long floor(){
		return this.floor;
	}

	@Override
	public boolean isManaged() {
		return false;
	}


}
