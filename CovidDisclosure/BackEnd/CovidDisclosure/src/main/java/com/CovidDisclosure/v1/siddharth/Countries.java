package com.CovidDisclosure.v1.siddharth;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Countries {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "countries_id")
	Integer id;
	
	
	
	

	@Column
	@JsonProperty("Country")
	String country;
	
	@JsonIgnoreProperties("CountryCode")
	String countryCode;
	
	@JsonIgnoreProperties("Slug")
	String slug;
	
	@Column
	@JsonProperty("NewConfirmed")
	Long newConfirmed;
	
	@Column
	@JsonProperty("TotalConfirmed")
	Long totalConfirmed;
	
	@Column
	@JsonProperty("NewDeaths")
	Long newDeaths;
	
	@Column
	@JsonProperty("TotalDeaths")
	Long totalDeaths;
	
	@Column
	@JsonProperty("NewRecovered")
	Long newRecovered;
	
	@Column
	@JsonProperty("TotalRecovered")
	Long totalRecovered;
	
	@JsonIgnoreProperties("Date")
	String date;
	
	public Countries() {}

	public Countries(String country, Long newConfirmed, Long totalConfirmed, Long newDeaths, Long totalDeaths,
			Long newRecovered, Long totalRecovered) {
		super();
		this.country = country;
		this.newConfirmed = newConfirmed;
		this.totalConfirmed = totalConfirmed;
		this.newDeaths = newDeaths;
		this.totalDeaths = totalDeaths;
		this.newRecovered = newRecovered;
		this.totalRecovered = totalRecovered;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Long getNewConfirmed() {
		return newConfirmed;
	}

	public void setNewConfirmed(Long newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public Long getTotalConfirmed() {
		return totalConfirmed;
	}

	public void setTotalConfirmed(Long totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public Long getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(Long newDeaths) {
		this.newDeaths = newDeaths;
	}

	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(Long totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Long getNewRecovered() {
		return newRecovered;
	}

	public void setNewRecovered(Long newRecovered) {
		this.newRecovered = newRecovered;
	}

	public Long getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(Long totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	/*
	@JsonIgnoreProperties("Premium")
	Premium premium;
	*/

	
}
