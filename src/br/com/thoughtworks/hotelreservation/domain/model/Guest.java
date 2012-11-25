package br.com.thoughtworks.hotelreservation.domain.model;

import java.util.Date;
import java.util.List;

import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class Guest implements Entity{

	private Long identificationCard;

	private String name;

	private String details;

	private Date bithday;

	//Many-To-One relationship.
	private LoyatyProgram loyatyProgram;
	
	//Transient
	private GuestRepository repository;
	
	/**
	 * Return a Guest detached.
	 *  
	 * @param identificationCard
	 * @param loyatyProgram
	 * @param name
	 * @param details
	 * @param bithday
	 */
	public Guest(Long identificationCard, LoyatyProgram loyatyProgram, String name, String details, Date bithday) {
		super();
		this.identificationCard = identificationCard;
		this.loyatyProgram = loyatyProgram;
		this.name = name;
		this.details = details;
		this.bithday = bithday;
	}

	/**
	 * Return a Guest detached.
	 *  
	 * @param loyatyProgram
	 * @param name
	 */
	public Guest(String name, LoyatyProgram loyatyProgram) {
		super();
		this.loyatyProgram = loyatyProgram;
		this.name = name;
	}
	
	/**
	 * Return a Guest detached.
	 */	
	public Guest(){
		super();
	}

	/**
	 * Return a Guest managed.
	 * 
	 * @param loyatyProgram
	 * @param name
	 * @param details
	 * @param bithday
	 * @param repository
	 */
	public Guest(LoyatyProgram loyatyProgram, String name, String details,
			Date bithday, GuestRepository repository) {
		super();
		this.loyatyProgram = loyatyProgram;
		this.name = name;
		this.details = details;
		this.bithday = bithday;
		this.repository = repository;
	}

	/**
	 * Return a Guest managed.
	 * 
	 * @param repository
	 */
	public Guest(GuestRepository repository) {
		this.repository = repository;
	}

	//Behavior
	public boolean isSubscribedOnLoyatyProgram(){
		return this.loyatyProgram != null;
	}
	
	public Guest find(Long id) throws Exception {
		return repository.find(id);
	}
	
	public List<Guest> findAll() throws Exception {
		return repository.findAll();
	}
	
	public void store(){
		if(this.identificationCard == null){
			//TODO: Validation
		}
		repository.store(this);
	}	
	
	//Getters
	public Long identificationCard(){
		return identificationCard;
	}

	public LoyatyProgram loyatyProgram(){
		return loyatyProgram;
	}

	public String name(){
		return name;
	}

	public String details(){
		return details;
	}

	public Date bithday(){
		return bithday;
	}
	
	

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean isManaged() {
		return repository != null;
	}
	
}
