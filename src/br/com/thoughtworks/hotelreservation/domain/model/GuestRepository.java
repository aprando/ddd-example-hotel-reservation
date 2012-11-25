package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.Date;
import java.util.List;

public interface GuestRepository {

	  /**
	   * Finds a Guest using given id.
	   *
	   * @param Long Id
	   * @return guest if found, else return null
	   * @throws Exception 
	   */
	  Guest find(Long id) throws Exception;

	  /**
	   * Finds all Guest.
	   *
	   * @return All Guest.
	   */
	  List<Guest> findAll();

	  /**
	   * Saves given Guest.
	   *
	   * @param Guest Guest to save
	   */
	  void store(Guest Guest);
	  
	  /**
	   * Lists all available Guests with rates.
	   * returns Guests 
	   * 
	   * @param to
	   * @param from
	   * @param guest
	   * @return
	   */
	  boolean listAvaiablesWithRates(Date to, Date from);
}
