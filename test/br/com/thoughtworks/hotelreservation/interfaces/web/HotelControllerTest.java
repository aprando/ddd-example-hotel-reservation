package br.com.thoughtworks.hotelreservation.interfaces.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelControllerTest {
	
	private HotelController controller;
	
	@Before
	public void initialize() {
		controller = new HotelController();
	}

	//@Test
	public void shouldListCheapestHotelAvaiableByFilelist() {
		try {
			controller.listCheapestHotelAvaiableByFilelist("thoughtworks.txt");
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldListCheapestHotelAvaiableByFilesInFolder() {
		try {
			controller.listCheapestsHotelsAvaiableByFilesInFolder();
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
