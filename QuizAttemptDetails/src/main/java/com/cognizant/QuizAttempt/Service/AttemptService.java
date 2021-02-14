package com.cognizant.QuizAttempt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttempt.QuizAttemptDetailsApplication;
import com.cognizant.QuizAttempt.Repository.AttemptRepository;
import com.cognizant.QuizAttempt.model.Attempt;

@Service
public class AttemptService {

	@Autowired
	AttemptRepository attemptRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(QuizAttemptDetailsApplication.class);

	public List<Attempt> getAttempts() {
		return attemptRepository.findAll();

	}

	@Transactional
	public Attempt get(int id) {
		LOGGER.info("Start");
		return attemptRepository.findById(id).get();
	}
	
	public Attempt getAttempt(int userId,int attemptId) {
		return attemptRepository.getAttempt(userId, attemptId);

	}
}
