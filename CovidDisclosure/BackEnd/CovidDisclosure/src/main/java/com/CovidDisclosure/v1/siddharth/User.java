package com.CovidDisclosure.v1.siddharth;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity
@ApiModel(description="All details about the user")
public class User {

	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(
			  value = "auto generated unique ID",
			  name = "id",
			  dataType = "Integer")
	Integer id;


	@Column
	@ApiModelProperty(
			  value = "password of the user",
			  name = "password",
			  dataType = "String")
	String password;
	
	
	@Column
	@ApiModelProperty(
			  value = "first name of the user",
			  name = "firstName",
			  dataType = "String")
	String firstName;
	
	@Column
	@ApiModelProperty(
			  value = "last name of the user",
			  name = "lastName",
			  dataType = "String")
	String lastName;
	
	@Column(nullable = false, unique = true)
	@ApiModelProperty(
			  value = "email of the user",
			  name = "email",
			  dataType = "String")
	String email;
	
	
	
	
	
	

	@OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name ="symptoms_id", referencedColumnName = "symptoms_id")
	@ApiModelProperty(
			  value = "symptoms of the user",
			  name = "symptoms",
			  dataType = "Symptoms")
	private Symptoms symptoms;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="covid_id", referencedColumnName = "covid_id")
	@ApiModelProperty(
			  value = "covid test results of the user",
			  name = "covid",
			  dataType = "Covid")
	private Covid covid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="details_id", referencedColumnName = "details_id")
	@ApiModelProperty(
			  value = "other details about the user",
			  name = "details",
			  dataType = "Details")
	private Details details;
	
	public User() {
		
	}

	public User(String username, String password, String firstName, String lastName, String email,
			String city, String state, String gender, String age) {
		super();
		
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
		
		//this.symptoms = new Symptoms(id, false, false, false, false, false, false, false, false, false, false, false, false);
		//int[] testDate= {0,0,0};
		//this.covid = new Covid(id, false, false, testDate);
	//	this.covid=new ArrayList<>();
		//this.symptoms=new ArrayList<>();
	}

	
	
	
	public Covid getCovid() {
		return covid;
	}

	public void setCovid(Covid covid) {
		this.covid = covid;
	}
	

	public Symptoms getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Symptoms symptoms) {
		this.symptoms = symptoms;
	}
	

	public Integer getId() { return id; }

	
	public String getPassword() { return password; }
	
    public void setPassword(String password) { this.password = password; }

    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	
	
	
	

	
	

	
	
	

}