package br.com.thoughtworks.hotelreservation.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.thoughtworks.hotelreservation.application.util.DateUtil;
import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class Booking implements Entity {

	private Long id;

	private String status;

	private Date from;

	private Date to;

	private Set<Guest> guests;

	//Many-to-one Relationship
	private Room room;

	//Many-to-one Relationship
	private Hotel hotel;
	
	//Transient
	private BookingRepository repository;
	
	/**
	 * Returns a booking managed.
	 * @param booking
	 */
	public Booking(BookingRepository repository){
		this.repository = repository;
	}
	
	/**
	 * Returns a booking managed.
	 * 
	 * @param status
	 * @param from
	 * @param to
	 * @param guests
	 * @param room
	 * @param hotel
	 * @param repository
	 */
	public Booking(String status, Date from, Date to, Set<Guest> guests,
			Room room, Hotel hotel, BookingRepository repository) {
		super();
		this.status = status;
		this.from = from;
		this.to = to;
		this.guests = guests;
		this.room = room;
		this.hotel = hotel;
		this.repository = repository;
	}
	
	/**
	 * Returns a booking detached. 
	 * 
	 * @param id
	 * @param status
	 * @param from
	 * @param to
	 * @param guests
	 * @param room
	 * @param hotel
	 */
	public Booking(Long id, String status, Date from, Date to,
			Set<Guest> guests, Room room, Hotel hotel) {
		super();
		this.id = id;
		this.status = status;
		this.from = from;
		this.to = to;
		this.guests = guests;
		this.room = room;
		this.hotel = hotel;
	}

	
	/**
	 * Returns a booking detached.
	 */
	public Booking() {
		super();
	}

	//Behavior
	public Hotel cheapestHotelAvaiable(Date to, Date from, Guest guest) throws Exception {
		Hotel hotel = new Hotel(new HotelRepositoryImpl());
		
		List<Hotel> avaiables = hotel.avaiables(to, from);
		if(avaiables == null || avaiables.size() == 0){
			//TODO: Validation.
		}
		
		Integer[] totalWeekdaysAndWeekend = DateUtil.weekdaysAndWeekendsByPeriod(to, from);
		BigDecimal weekdays = new BigDecimal(totalWeekdaysAndWeekend[0]);
		BigDecimal weekends = new BigDecimal(totalWeekdaysAndWeekend[1]);
		
		Hotel cheapest = null;
		BigDecimal cheapestRate = null;
		
		BigDecimal totalRate = null;
		for(Hotel avaiable : avaiables){
			if(guest.isSubscribedOnLoyatyProgram())
				totalRate = avaiable.rate().weekdayRewardRate().multiply(weekdays)
					.add(avaiable.rate().weekendRewardRate().multiply(weekends));
			else
				totalRate = avaiable.rate().weekdayRegularRate().multiply(weekdays)
					.add(avaiable.rate().weekendRegularRate().multiply(weekends));
			
			if((cheapest == null || cheapestRate == null) 
					|| cheapestRate.compareTo(totalRate) != -1){
				cheapest = avaiable;
				cheapestRate = totalRate;
			}
			
		}
		
		return cheapest;
	}
	
	//Behavior
	public Hotel cheapestHotelAvaiable(Guest guest, List<Hotel> avaiables, List<Date> dates) throws Exception {
		Integer[] totalWeekdaysAndWeekend = DateUtil.weekdaysAndWeekendsByDates(dates);
		BigDecimal weekdays = new BigDecimal(totalWeekdaysAndWeekend[0]);
		BigDecimal weekends = new BigDecimal(totalWeekdaysAndWeekend[1]);
		
		Hotel cheapest = null;
		BigDecimal cheapestRate = null;
		
		BigDecimal totalRate = null;
		for(Hotel avaiable : avaiables){
			if(guest.isSubscribedOnLoyatyProgram())
				totalRate = avaiable.rate().weekdayRewardRate().multiply(weekdays)
					.add(avaiable.rate().weekendRewardRate().multiply(weekends));
			else
				totalRate = avaiable.rate().weekdayRegularRate().multiply(weekdays)
					.add(avaiable.rate().weekendRegularRate().multiply(weekends));
			
			if((cheapest == null || cheapestRate == null) 
					|| cheapestRate.compareTo(totalRate) != -1){
				cheapest = avaiable;
				cheapestRate = totalRate;
			}
			
		}
		
		return cheapest;
	}
	
	
	public void addGuest(Guest guest){
		if(guests == null)
			guests = new HashSet<Guest>();
		guests.add(guest);
	}
	
	//Getters
	public Long id() {
		return this.id;
	}
	
	public String status() {
		return this.status;
	}
	
	public Date from() {
		return this.from;
	}
	
	public Date to() {
		return this.to;
	}
	
	public Set<Guest> guests(){
		return this.guests;
	}
	
	public Room room(){
		return this.room;
	}
	
	public Hotel hotel(){
		return this.hotel;
	}

	@Override
	public boolean isManaged() {
		return repository != null;
	}
}
