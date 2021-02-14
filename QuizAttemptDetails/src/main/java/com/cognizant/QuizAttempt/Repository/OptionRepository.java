package com.cognizant.QuizAttempt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.QuizAttempt.model.Option;

@Repository
public interface OptionRepository  extends JpaRepository<Option, Integer> {

	@Query(value = "select * from user u join option a where u.user_id=:userId and a.option_id=:optionId",nativeQuery = true)
	public Option getOptionAttempt(@Param("userId") int userId, @Param("optionId") int optionId);
}
