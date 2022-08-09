package com.CovidDisclosure.v1.siddharth;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Statistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Integer id;

	
	@JsonIgnoreProperties("Message")
	String message;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name ="global_id", referencedColumnName = "global_id")
	@JsonProperty("Global")
	Global global;
	
	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name ="cID", referencedColumnName = "id")
	@JsonProperty("Countries")
	List<Countries> countries;
	
	
	@Column
	@JsonProperty("Date")
	String date;
	
	
	public Statistics() {}
	
	public Statistics(Global global, List<Countries> countries, String date) {
		super();
		this.global = global;
		this.countries = countries;
		this.date = date;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Global getGlobal() {
		return global;
	}


	public void setGlobal(Global global) {
		this.global = global;
	}


	public List<Countries> getCountries() {
		return countries;
	}


	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	
}
