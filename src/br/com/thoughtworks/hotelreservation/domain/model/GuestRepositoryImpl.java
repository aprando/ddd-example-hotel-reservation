package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.Date;
import java.util.List;

import br.com.thoughtworks.hotelreservation.infrastructure.persistence.dao.GuestDAO;

public class GuestRepositoryImpl implements GuestRepository {

	final GuestDAO dao = new GuestDAO();
	
	@Override
	public Guest find(Long id) throws Exception {
		return dao.find(id);
	}

	@Override
	public List<Guest> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Guest Guest) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean listAvaiablesWithRates(Date to, Date from) {
		// TODO Auto-generated method stub
		return false;
	}

}
