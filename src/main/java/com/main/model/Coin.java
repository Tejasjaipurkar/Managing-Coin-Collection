package com.main.model;

import java.util.Date;

public class Coin {
	
	int coinId;
	String country;
	String denomination;
	int yearOfMinting;
	double currentValue;
	Date acquriedDate;
	
	public Coin() {
		this.coinId = 0;
		this.country = null;
		this.denomination = null;
		this.yearOfMinting = 0000;
		this.currentValue = 0.0;
		this.acquriedDate = null;
		
	}

	public Coin(int coinId, String countrt, String denomination, int yearOfMinting, double currentValue,
			Date acquriedDate) {
		super();
		this.coinId = coinId;
		this.country = countrt;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.currentValue = currentValue;
		this.acquriedDate = acquriedDate;
	}
	public Coin( String countrt, String denomination, int yearOfMinting, double currentValue,
			Date acquriedDate) {
		super();
		this.country = countrt;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.currentValue = currentValue;
		this.acquriedDate = acquriedDate;
	}

	public int getCoinId() {
		return coinId;
	}

	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String countrt) {
		this.country = countrt;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getYearOfMinting() {
		return yearOfMinting;
	}

	public void setYearOfMinting(int yearOfMinting) {
		this.yearOfMinting = yearOfMinting;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public Date getAcquriedDate() {
		return acquriedDate;
	}

	public void setAcquriedDate(Date acquriedDate) {
		this.acquriedDate = acquriedDate;
	}

	@Override
	public String toString() {
		return "Coin [coinId=" + coinId + ", countrt=" + country + ", denomination=" + denomination + ", yearOfMinting="
				+ yearOfMinting + ", currentValue=" + currentValue + ", acquriedDate=" + acquriedDate + "]";
	}

	
	
}
