package br.com.thoughtworks.hotelreservation.domain.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.thoughtworks.hotelreservation.domain.model.Hotel;
import br.com.thoughtworks.hotelreservation.domain.model.HotelRepositoryImpl;

public class HotelTest {

	private Hotel hotel;

	@Before
	public void initialize() {
		hotel = new Hotel(new HotelRepositoryImpl());
	}

	@Test
	public void shouldFindCheapestRate() {
		try {
			Assert.assertNotNull("Hotel should be the cheapest rate", hotel);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	public void shouldNotFindAnything() {
		try {
			// TODO: Implementar teste range de datas.
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	public void shouldDateRangeFail() {
		try {
			// TODO: Implementar teste range de datas.
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
