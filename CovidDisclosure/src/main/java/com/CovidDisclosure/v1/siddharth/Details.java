package com.CovidDisclosure.v1.siddharth;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Age and gender of the user")
public class Details {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "details_id")
	@ApiModelProperty(
			  value = "auto generated unique ID",
			  name = "id",
			  dataType = "Integer")
		Integer id;


		@Column
		boolean male;
		
		@Column 
		boolean female;
		
		@Column
		@ApiModelProperty(
				  value = "age range 18-27",
				  name = "age1",
				  dataType = "Boolean")
		boolean age1; 
		
		@Column
		@ApiModelProperty(
				  value = "age range 28-40",
				  name = "age2",
				  dataType = "Boolean")
		boolean age2;
		
		@Column
		@ApiModelProperty(
				  value = "age range 41-60",
				  name = "age3",
				  dataType = "Boolean")
		boolean age3;
		
		@Column
		@ApiModelProperty(
				  value = "age range 61+",
				  name = "age4",
				  dataType = "Boolean")
		boolean age4;

		
		public Details() {
		
		}
		
		public Details(boolean male, boolean female, boolean age1, boolean age2, boolean age3, boolean age4) {
			super();
			this.male = male;
			this.female = female;
			this.age1 = age1;
			this.age2 = age2;
			this.age3 = age3;
			this.age4 = age4;
		}

		public boolean isMale() {
			return male;
		}

		public void setMale(boolean male) {
			this.male = male;
		}

		public boolean isFemale() {
			return female;
		}

		public void setFemale(boolean female) {
			this.female = female;
		}

		public boolean isAge1() {
			return age1;
		}

		public void setAge1(boolean age1) {
			this.age1 = age1;
		}

		public boolean isAge2() {
			return age2;
		}

		public void setAge2(boolean age2) {
			this.age2 = age2;
		}

		public boolean isAge3() {
			return age3;
		}

		public void setAge3(boolean age3) {
			this.age3 = age3;
		}

		public boolean isAge4() {
			return age4;
		}

		public void setAge4(boolean age4) {
			this.age4 = age4;
		}
		
		
		

}
