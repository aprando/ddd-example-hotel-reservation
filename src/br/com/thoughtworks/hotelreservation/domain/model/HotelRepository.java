package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.Date;
import java.util.List;

public interface HotelRepository {

	  /**
	   * Finds a hotel using given id.
	   *
	   * @param Long Id
	   * @return hotel if found, else return null
	   */
	  Hotel find(Long id);

	  /**
	   * Finds all Hotel.
	   *
	   * @return All Hotel.
	   */
	  List<Hotel> findAll();

	  /**
	   * Saves given Hotel.
	   *
	   * @param Hotel hotel to save
	   */
	  void store(Hotel hotel);

	  /**
	   * @return A unique, generated tracking Id.
	   */
	  Long nextId();
	  
	  /**
	   * Lists all available hotels by period.
	   * 
	   * @param to
	   * @param from
	   * @param guest
	   * @return Hotels if found, else return empty list.
	 * @throws Exception 
	   */
	  List<Hotel> listAvaiables(Date to, Date from) throws Exception;
	  
	  /**
	   * Lists all available hotels on dates.
	   * 
	   * @param dates
	   * @return
	   * @throws Exception
	   * @return Hotels if found, else return empty list.
	   */
	  List<Hotel> listAvaiables(List<Date> dates) throws Exception;
}
