package br.com.thoughtworks.hotelreservation.infrastructure.persistence.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.thoughtworks.hotelreservation.domain.model.Hotel;
import br.com.thoughtworks.hotelreservation.domain.model.HotelChain;
import br.com.thoughtworks.hotelreservation.domain.model.HotelRate;
import br.com.thoughtworks.hotelreservation.domain.model.HotelRepositoryImpl;
import br.com.thoughtworks.hotelreservation.domain.model.Room;

public class HotelDAO extends AbstractDAO {

	public List<Hotel> listAvaiables(Date to, Date from) throws Exception {
		//TODO: Use database instead of mocked entities
		HotelChain chain = new HotelChain(1L, "Miami");
		
		List<Room> rooms = new ArrayList<Room>();
		HotelRate rate3 = new HotelRate(3L, new BigDecimal(110), new BigDecimal(90), new BigDecimal(80), new BigDecimal(80));
		HotelRate rate4 = new HotelRate(4L, new BigDecimal(160), new BigDecimal(60), new BigDecimal(110), new BigDecimal(50));
		HotelRate rate5 = new HotelRate(5L, new BigDecimal(220), new BigDecimal(150), new BigDecimal(100), new BigDecimal(40));
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(1L, chain, "Lakewood", "Address 1", "City 1", "PostCode 1", rate3, rooms, new HotelRepositoryImpl()));
		hotels.add(new Hotel(2L, chain, "Bridgewood", "Address 2", "City 2", "PostCode 2", rate4, rooms, new HotelRepositoryImpl()));
		hotels.add(new Hotel(3L, chain, "Ridgewood", "Address 3", "City 3", "PostCode 3", rate5, rooms, new HotelRepositoryImpl()));
		
		return hotels;
	}
	
	public List<Hotel> listAvaiables(List<Date> dates) throws Exception {
		//TODO: Use database instead of mocked entities
		HotelChain chain = new HotelChain(1L, "Miami");
		
		List<Room> rooms = new ArrayList<Room>();
		HotelRate rate3 = new HotelRate(3L, new BigDecimal(110), new BigDecimal(90), new BigDecimal(80), new BigDecimal(80));
		HotelRate rate4 = new HotelRate(4L, new BigDecimal(160), new BigDecimal(60), new BigDecimal(110), new BigDecimal(50));
		HotelRate rate5 = new HotelRate(5L, new BigDecimal(220), new BigDecimal(150), new BigDecimal(100), new BigDecimal(40));
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(1L, chain, "Lakewood", "Address 1", "City 1", "PostCode 1", rate3, rooms, new HotelRepositoryImpl()));
		hotels.add(new Hotel(2L, chain, "Bridgewood", "Address 2", "City 2", "PostCode 2", rate4, rooms, new HotelRepositoryImpl()));
		hotels.add(new Hotel(3L, chain, "Ridgewood", "Address 3", "City 3", "PostCode 3", rate5, rooms, new HotelRepositoryImpl()));
		
		return hotels;
	}
		
	
}
