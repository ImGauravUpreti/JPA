package com.cognizant.QuizAttempt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.cognizant.QuizAttempt.Service.AttemptService;
import com.cognizant.QuizAttempt.Service.OptionService;
import com.cognizant.QuizAttempt.Service.QuestionService;
import com.cognizant.QuizAttempt.Service.UserService;
import com.cognizant.QuizAttempt.model.Attempt;
import com.cognizant.QuizAttempt.model.Option;
import com.cognizant.QuizAttempt.model.Question;
import com.cognizant.QuizAttempt.model.User;

@SpringBootApplication
public class QuizAttemptDetailsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizAttemptDetailsApplication.class);
	private static AttemptService attemptService;
	private static QuestionService questionService;
	private static UserService userService;
	private static OptionService optionService;
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(QuizAttemptDetailsApplication.class, args);
		
		LOGGER.info("********************************EMPLOYEE START****************************");

		attemptService = (AttemptService) context.getBean("attemptService");
		LOGGER.info("Inside main");
		System.out.println("******************************GET ID********************************");
		testGetAttempt();
		System.out.println("******************************GET ID********************************");
		testGetUserAttempt();
		System.out.println("******************************GET ID********************************");
		testGetQuestionAttempt();
		System.out.println("******************************GET ID********************************");
		testGetOptionAttempt();
		
		
	}
	
	private static void testGetAttempt() {
		LOGGER.info("Start");
		Attempt employee = attemptService.get(1);
		LOGGER.debug("Attempt:{}", employee);
		LOGGER.debug("SUCCESS");
		LOGGER.info("End");
	}
	
	private static void testGetQuestionAttempt() {
		LOGGER.info("Start");
        Question employee = questionService.get(1);
		LOGGER.debug("Attempt:{}", employee);
		LOGGER.debug("SUCCESS");
		LOGGER.info("End");
	}
	
	private static void testGetOptionAttempt() {
		LOGGER.info("Start");
        Option employee = optionService.get(1);
		LOGGER.debug("Attempt:{}", employee);
		LOGGER.debug("SUCCESS");
		LOGGER.info("End");
	}
	private static void testGetUserAttempt() {
		LOGGER.info("Start");
        User employee = userService.get(1);
		LOGGER.debug("Attempt:{}", employee);
		LOGGER.debug("SUCCESS");
		LOGGER.info("End");
	}

}
