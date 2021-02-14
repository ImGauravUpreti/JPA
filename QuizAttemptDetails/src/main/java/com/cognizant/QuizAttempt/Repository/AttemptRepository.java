package com.cognizant.QuizAttempt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.QuizAttempt.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
	
	@Query(value = "select * from user u join attempt a where u.user_id=:userId and a.attempt_id=:attemptId",nativeQuery = true)
	public Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
	

}
