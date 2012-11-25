package br.com.thoughtworks.hotelreservation.interfaces.web;

import java.io.File;

import br.com.thoughtworks.hotelreservation.application.BookingService;
import br.com.thoughtworks.hotelreservation.application.impl.BookingServiceImpl;

public class HotelController {

	private final BookingService service = new BookingServiceImpl();
	
	public void listCheapestHotelAvaiableByFilelist(String fileName) throws Exception {
		service.listCheapestHotelAvaiableByFilelist(fileName);
	}
	
	public void listCheapestsHotelsAvaiableByFilesInFolder() throws Exception {
		File folder = new File(".");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles){
			if(file.getName().indexOf(".txt") != -1){
				service.listCheapestHotelAvaiableByFilelist(file.getName());
			}
		}
	}

}
