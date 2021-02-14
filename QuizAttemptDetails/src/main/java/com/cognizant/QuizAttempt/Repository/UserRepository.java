package com.cognizant.QuizAttempt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.QuizAttempt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from user u join attempt a where u.user_id=:userId and a.attempt_id=:attemptId",nativeQuery = true)
	public User getUserAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
