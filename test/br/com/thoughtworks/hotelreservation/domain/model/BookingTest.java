package br.com.thoughtworks.hotelreservation.domain.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.thoughtworks.hotelreservation.domain.model.Booking;
import br.com.thoughtworks.hotelreservation.domain.model.BookingRepositoryImpl;

public class BookingTest {
	
	private Booking booking;
	
	@Before
	public void initialize() {
		booking = new Booking(new BookingRepositoryImpl());
	}

	@Test
	public void shouldFindCheapestHotel() {
		try {
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}


}
