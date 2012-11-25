package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.Date;
import java.util.List;

import br.com.thoughtworks.hotelreservation.infrastructure.persistence.dao.HotelDAO;

public class HotelRepositoryImpl implements HotelRepository {

	final HotelDAO dao = new HotelDAO();
	
	@Override
	public Hotel find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Hotel hotel) {
		// TODO Auto-generated method stub
	}

	@Override
	public Long nextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> listAvaiables(Date to, Date from) throws Exception {
		return dao.listAvaiables(to, from);
	}

	@Override
	public List<Hotel> listAvaiables(List<Date> dates) throws Exception {
		return dao.listAvaiables(dates);
	}

}
