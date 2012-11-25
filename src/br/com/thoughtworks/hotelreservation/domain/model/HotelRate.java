package br.com.thoughtworks.hotelreservation.domain.model;

import java.math.BigDecimal;

import br.com.thoughtworks.hotelreservation.domain.shared.Entity;

public class HotelRate implements Entity {

	private Long code;

	private BigDecimal weekdayRegularRate;

	private BigDecimal weekendRegularRate;

	private BigDecimal weekdayRewardRate;

	private BigDecimal weekendRewardRate;

	/**
	 * Returns a HotelRate detached
	 */
	public HotelRate() {
		super();
	}
	
	/**
	 * Returns a HotelRate detached
	 * 
	 * @param code
	 * @param weekdayRegularRate
	 * @param weekendRegularRate
	 * @param weekdayRewardRate
	 * @param weekendRewardRate
	 */
	public HotelRate(Long code, BigDecimal weekdayRegularRate,
			BigDecimal weekendRegularRate, BigDecimal weekdayRewardRate,
			BigDecimal weekendRewardRate) {
		super();
		this.code = code;
		this.weekdayRegularRate = weekdayRegularRate;
		this.weekendRegularRate = weekendRegularRate;
		this.weekdayRewardRate = weekdayRewardRate;
		this.weekendRewardRate = weekendRewardRate;
	}

	public Long code() {
		return this.code;
	}

	public BigDecimal weekdayRegularRate() {
		return this.weekdayRegularRate;
	}

	public BigDecimal weekendRegularRate() {
		return this.weekendRegularRate;
	}

	public BigDecimal weekdayRewardRate() {
		return this.weekdayRewardRate;
	}

	public BigDecimal weekendRewardRate() {
		return this.weekendRewardRate;
	}

	@Override
	public boolean isManaged() {
		return false;
	}
}
