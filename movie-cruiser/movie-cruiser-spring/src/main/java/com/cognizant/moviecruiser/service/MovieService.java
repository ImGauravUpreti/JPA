package com.cognizant.moviecruiser.service;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MovieRepository;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public List<Movie> getMovieListAdmin() {
		return movieRepository.findAll();
	}

	@Transactional
	public Set<Movie> getMovieListCustomer() {
		return movieRepository.findByActiveAndDateOfLaunch();
	}

	@Transactional
	public Movie getMovie(int id) {
		Optional<Movie> result = movieRepository.findById(id);
		Movie movie = result.get();
		return movie;
	}

	@Transactional
	public void modifyMovie(Movie movie) {
		movieRepository.save(movie);
	}

}
