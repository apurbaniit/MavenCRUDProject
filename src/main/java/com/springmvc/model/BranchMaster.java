package com.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="branchmaster")
public class BranchMaster {

	@Id
    @Column(name="branch_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="branch_name")
    private String branch_name;
    
    @Column(name="branch_code")
    private String branch_code;
    
    @ManyToOne(targetEntity = Country.class)
	@JoinColumn(name="country_id")
	private Country country;
    
    @Transient
    private long countryId;
	
    @Column(name="branch_address")
    private String branch_address;

    
	public BranchMaster() {
		super();
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getBranch_name() {
		return branch_name;
	}


	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}


	public String getBranch_code() {
		return branch_code;
	}


	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public long getCountryId() {
		return countryId;
	}


	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}


	public String getBranch_address() {
		return branch_address;
	}


	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}


	@Override
	public String toString() {
		return "BranchMaster [id=" + id + ", branch_name=" + branch_name + ", branch_code=" + branch_code + ", country="
				+ country + ", countryId=" + countryId + ", branch_address=" + branch_address + "]";
	}

}
