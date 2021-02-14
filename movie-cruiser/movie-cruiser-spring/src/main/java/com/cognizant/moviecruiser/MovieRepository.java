package com.cognizant.moviecruiser;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query(value = "SELECT * FROM movies WHERE movie_active=true and movie_date_of_launch<= CURDATE()", nativeQuery = true)
	public Set<Movie> findByActiveAndDateOfLaunch();
}
