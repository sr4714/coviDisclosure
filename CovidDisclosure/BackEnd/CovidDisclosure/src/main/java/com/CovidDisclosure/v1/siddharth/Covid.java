
package com.CovidDisclosure.v1.siddharth;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the covid results of a user")
public class Covid {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "covid_id")
	@ApiModelProperty(
			  value = "auto generated unique ID",
			  name = "id",
			  dataType = "Integer")
	Integer id;
	
	
	@Column
	@ApiModelProperty(
			  value = "0 for not tested, 1 for tested",
			  name = "tested",
			  dataType = "Boolean")
	boolean tested; // 0 for not tested; 1 for tested
	
	@Column
	@ApiModelProperty(
			  value = "0 for negative report, 1 for positive report",
			  name = "result",
			  dataType = "Boolean")
	boolean result; // 0 for negative report; 1 for positive report
	
	@Column
	@ApiModelProperty(
			  value = "test date of the user (month/date/year) ",
			  name = "testDate")
	int testDate[]; // month/date/year
	
	public Covid() {
		
	}

	public Covid(boolean tested, boolean result, int[] testDate) {
		super();
		this.tested = tested;
		this.result = result;
		this.testDate = testDate;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public boolean isTested() {
		return tested;
	}

	public void setTested(boolean tested) {
		this.tested = tested;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int[] getTestDate() {
		return testDate;
	}

	public void setTestDate(int[] testDate) {
		this.testDate = testDate;
	}
	
	
	
}
