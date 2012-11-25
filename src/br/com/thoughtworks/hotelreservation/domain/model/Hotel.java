package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.Date;
import java.util.List;

import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class Hotel implements Entity {

	private Long id;

	private HotelChain hotelChain;

	private String name;

	private String address;

	private String city;

	private String postCode;
	
	//One-To-Many relationship
	private List<Room> rooms;

	//Many-To-One relationship
	private HotelRate rate;
	
	//Transient
	private HotelRepository repository;
	
	/**
	 * Returns a hotel managed.
	 * @param hotel
	 */
	public Hotel(HotelRepository repository) {
		super();
		this.repository = repository;
	}

	/**
	 * Returns a hotel managed.
	 * @param hotel
	 */	
	public Hotel(Long id, HotelChain hotelChain, String name, String address,
			String city, String postCode, HotelRate rate, List<Room> rooms, HotelRepository repository) {
		super();
		this.hotelChain = hotelChain;
		this.name = name;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.rate = rate;
		this.rooms = rooms;
		this.repository = repository;
	}

	/**
	 * Return a hotel detached.
	 */
	public Hotel() {
		super();
	}
	
	/**
	 * Return a hotel detached.
	 * 
	 * @param hotelChain
	 * @param name
	 * @param address
	 * @param city
	 * @param postCode
	 * @param rooms
	 */
	public Hotel(Long id, HotelChain hotelChain, String name, String address,
			String city, String postCode, HotelRate rate, List<Room> rooms) {
		super();
		this.hotelChain = hotelChain;
		this.name = name;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.rate = rate;
		this.rooms = rooms;
	}
	

	//Behavior
	public List<Hotel> avaiables(Date to, Date from) throws Exception {
		if(to == null && from == null){
			//TODO: Validation.
		}
		return repository.listAvaiables(to, from);
	}
	
	public List<Hotel> avaiables(List<Date> dates) throws Exception {
		if(dates == null || dates.isEmpty()){
			//TODO: Validation.
		}
		return repository.listAvaiables(dates);
	}	
	
	public Hotel find(Long id) throws Exception {
		return repository.find(id);
	}
	
	public List<Hotel> findAll() throws Exception {
		return repository.findAll();
	}
	
	public void store(){
		if(this.id == null)
			this.id = nextId();
		repository.store(this);
	}
	
	//Getters
	public Long nextId() {
		return nextId();
	}
	
	public Long id(){
		return this.id;
	}

	public HotelChain hotelChain(){
		return this.hotelChain;
	}

	public String name(){
		return this.name;
	}

	public String address(){
		return this.address;
	}

	public String city(){
		return this.city;
	}

	public String postCode(){
		return this.postCode;	
	}
	
	public List<Room> rooms(){
		return this.rooms;
	}

	public HotelRate rate(){
		return this.rate;
	}

	@Override
	public boolean isManaged() {
		return repository != null;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}