package com.cognizant.QuizAttempt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "option_id")
	private int option_id;
	@Column(name="options")
	private String option;
	@Column(name="value")
	private String value;
	@Column(name="option_score")
	private double optionScore;
	
	
	public Option() {
		super();
	}

	public int getOption_id() {
		return option_id;
	}

	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getOptionScore() {
		return optionScore;
	}

	public void setOptionScore(double optionScore) {
		this.optionScore = optionScore;
	}

	@Override
	public String toString() {
		return "Option [option_id=" + option_id + ", option=" + option + ", value=" + value + ", optionScore="
				+ optionScore + "]";
	}
	
	
	
}
