package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
    @Column(name="country_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
 
    @Column(name="countryName")
    String countryName;

    
	public Country() {
		super();
	}

	public Country(long id, String countryName) {
		super();
		this.id = id;
		this.countryName = countryName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + "]";
	}
    
}
