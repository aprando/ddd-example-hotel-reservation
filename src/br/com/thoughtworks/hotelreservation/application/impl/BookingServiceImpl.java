package br.com.thoughtworks.hotelreservation.application.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import br.com.thoughtworks.hotelreservation.application.BookingService;
import br.com.thoughtworks.hotelreservation.application.util.DateUtil;
import br.com.thoughtworks.hotelreservation.domain.model.Booking;
import br.com.thoughtworks.hotelreservation.domain.model.BookingRepository;
import br.com.thoughtworks.hotelreservation.domain.model.BookingRepositoryImpl;
import br.com.thoughtworks.hotelreservation.domain.model.Guest;
import br.com.thoughtworks.hotelreservation.domain.model.Hotel;
import br.com.thoughtworks.hotelreservation.domain.model.HotelRepository;
import br.com.thoughtworks.hotelreservation.domain.model.HotelRepositoryImpl;
import br.com.thoughtworks.hotelreservation.domain.model.LoyatyProgram;

public final class BookingServiceImpl implements BookingService {

	private final HotelRepository hotelRepository;
	private final BookingRepository bookingRepository;

	public BookingServiceImpl(HotelRepository hotelRepository,
			BookingRepository bookingRepository) {
		super();
		this.hotelRepository = hotelRepository;
		this.bookingRepository = bookingRepository;
	}
	
	public BookingServiceImpl(){
		super();
		this.hotelRepository = new HotelRepositoryImpl();
		this.bookingRepository = new BookingRepositoryImpl();
	}

	@Override
	public void listCheapestHotelAvaiableByFilelist(String fileName) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter out = null;
		try {
			Guest guest = null;
			String customerType = null;
			List<Date> dates = null;
			
			Map<Guest, List<Date>> requests = new HashMap<Guest, List<Date>>();
			
			StringTokenizer tokenizer = null;
			int index = 0;
			String line = br.readLine();
			while (line != null) {
				dates = new ArrayList<Date>();
				
				customerType = line.substring(0, line.indexOf(':'));
				line = line.substring(line.indexOf(':') + 1);
				guest = new Guest("OUTPUT " + index++, customerType.toLowerCase().trim().equals(LoyatyProgram.REWARDS_TYPE.toLowerCase()) ? new LoyatyProgram() : null);
				tokenizer = new StringTokenizer(line, ",");
				while (tokenizer.hasMoreElements()) 
					dates.add(DateUtil.parseStringToDate((String) tokenizer.nextElement(), DateUtil.PATTERN_DDMMMYYYY));
				
				requests.put(guest, dates);
				line = br.readLine();
			}
			

			FileWriter fstream = new FileWriter("out.txt");
			out = new BufferedWriter(fstream);
			
			Booking booking = new Booking(bookingRepository);
			Hotel hotel = new Hotel(hotelRepository);
			
			Hotel cheapest = null;
			for (Map.Entry<Guest, List<Date>> entry : requests.entrySet()) {
				cheapest = booking.cheapestHotelAvaiable(entry.getKey(), hotel.avaiables(entry.getValue()), entry.getValue()); 
				out.write(entry.getKey() + ": " + cheapest.toString() + "\n");
				System.out.println(entry.getKey() + ": " + cheapest.toString() );
			}
			
		} finally {
			out.close();
			br.close();
		}
	}

}
