package com.cognizant.QuizAttempt.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ques_id")
	private int ques_id;
	@Column(name="questions")
	private String question;
	@Column(name="score")
	private double score;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ques_id")
	private Set<Option> optionSet;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQues_id() {
		return ques_id;
	}

	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Set<Option> getOptionSet() {
		return optionSet;
	}

	public void setOptionSet(Set<Option> optionSet) {
		this.optionSet = optionSet;
	}

	@Override
	public String toString() {
		return "Question [ques_id=" + ques_id + ", question=" + question + ", score=" + score + ", optionSet="
				+ optionSet + "]";
	}
	
	
}
