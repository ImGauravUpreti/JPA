package com.cognizant.QuizAttempt.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.QuizAttempt.QuizAttemptDetailsApplication;
import com.cognizant.QuizAttempt.Repository.OptionRepository;
import com.cognizant.QuizAttempt.model.Option;

@Service
public class OptionService {

	@Autowired
	OptionRepository optionRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuizAttemptDetailsApplication.class);

	public List<Option> getAttempts() {
		return optionRepository.findAll();

	}

	@Transactional
	public Option get(int id) {
		LOGGER.info("Start");
		return optionRepository.findById(id).get();
	}
	
	public Option getOptionAttempt(int userId,int optionId) {
		return optionRepository.getOptionAttempt(userId, optionId);
	}
}
