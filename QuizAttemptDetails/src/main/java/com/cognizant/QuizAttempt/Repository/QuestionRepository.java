package com.cognizant.QuizAttempt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.QuizAttempt.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>
{

	@Query(value = "select * from user u join question a where u.user_id=:userId and a.question_id=:questionId",nativeQuery = true)
	public Question getQuestionAttempt(@Param("userId") int userId, @Param("questionId") int questionId);
}
