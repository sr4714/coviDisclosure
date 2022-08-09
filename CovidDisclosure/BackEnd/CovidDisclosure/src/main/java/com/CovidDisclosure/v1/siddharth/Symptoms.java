package com.CovidDisclosure.v1.siddharth;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


	

@Entity
@ApiModel(description="All details about symptoms of a user")
public class Symptoms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "symptoms_id")
	@ApiModelProperty(
			  value = "auto generated unique ID",
			  name = "id",
			  dataType = "Integer")
	Integer id;
	
	
	@Column
	boolean fever;
	
	@Column
	boolean cough;
	
	@Column
	boolean tiredness;
	
	@Column
	boolean pains;
	
	@Column
	boolean sore_throat;
	
	@Column
	boolean diarrhea;
	
	@Column
	boolean headache;
	
	@Column
	boolean loss_of_senses;
	
	@Column
	boolean rashes;
	
	@Column
	boolean difficult_breathing;
	
	@Column
	boolean short_breath;
	
	@Column
	boolean chest_pain;
	
	

	public Symptoms() {
		
	}
	
	
	
	
	public Symptoms( boolean fever, boolean cough, boolean tiredness, boolean pains, boolean sore_throat,
			boolean diarrhea, boolean headache, boolean loss_of_senses, boolean rashes, boolean difficult_breathing,
			boolean short_breath, boolean chest_pain) {
		super();
		
		this.fever = fever;
		this.cough = cough;
		this.tiredness = tiredness;
		this.pains = pains;
		this.sore_throat = sore_throat;
		this.diarrhea = diarrhea;
		this.headache = headache;
		this.loss_of_senses = loss_of_senses;
		this.rashes = rashes;
		this.difficult_breathing = difficult_breathing;
		this.short_breath = short_breath;
		this.chest_pain = chest_pain;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isFever() {
		return fever;
	}

	public void setFever(boolean fever) {
		this.fever = fever;
	}

	public boolean isCough() {
		return cough;
	}

	public void setCough(boolean cough) {
		this.cough = cough;
	}

	public boolean isTiredness() {
		return tiredness;
	}

	public void setTiredness(boolean tiredness) {
		this.tiredness = tiredness;
	}

	public boolean isPains() {
		return pains;
	}

	public void setPains(boolean pains) {
		this.pains = pains;
	}

	public boolean isSore_throat() {
		return sore_throat;
	}

	public void setSore_throat(boolean sore_throat) {
		this.sore_throat = sore_throat;
	}

	public boolean isDiarrhea() {
		return diarrhea;
	}

	public void setDiarrhea(boolean diarrhea) {
		this.diarrhea = diarrhea;
	}

	public boolean isHeadache() {
		return headache;
	}

	public void setHeadache(boolean headache) {
		this.headache = headache;
	}

	public boolean isLoss_of_senses() {
		return loss_of_senses;
	}

	public void setLoss_of_senses(boolean loss_of_senses) {
		this.loss_of_senses = loss_of_senses;
	}

	public boolean isRashes() {
		return rashes;
	}

	public void setRashes(boolean rashes) {
		this.rashes = rashes;
	}

	public boolean isDifficult_breathing() {
		return difficult_breathing;
	}

	public void setDifficult_breathing(boolean difficult_breathing) {
		this.difficult_breathing = difficult_breathing;
	}

	public boolean isShort_breath() {
		return short_breath;
	}

	public void setShort_breath(boolean short_breath) {
		this.short_breath = short_breath;
	}

	public boolean isChest_pain() {
		return chest_pain;
	}

	public void setChest_pain(boolean chest_pain) {
		this.chest_pain = chest_pain;
	}

	
}
