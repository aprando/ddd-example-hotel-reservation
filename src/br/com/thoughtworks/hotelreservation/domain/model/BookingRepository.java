package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.List;

public interface BookingRepository {

	  /**
	   * Finds a Booking using given id.
	   *
	   * @param Long Id
	   * @return Booking if found, else return null
	   */
	  Booking find(Long id);

	  /**
	   * Finds all Booking.
	   *
	   * @return All Booking.
	   */
	  List<Booking> findAll();

	  /**
	   * Saves given Booking.
	   *
	   * @param Booking Booking to save
	   */
	  void store(Booking Booking);

	  /**
	   * @return A unique, generated tracking Id.
	   */
	  Long nextId();

}
