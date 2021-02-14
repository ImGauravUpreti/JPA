package com.cognizant.moviecruiser;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MovieCruiserApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	private static MovieService movieService;

	public static void main(String[] args) throws ParseException {
		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(MovieCruiserApplication.class, args);
		movieService = context.getBean(MovieService.class);
		getMovieListAdminTest();
		getMovieListCustomerTest();
		getMovieTest();
		modifyMovieTest();

	}

	private static void getMovieListAdminTest() {
		// MCUC001 - Admin - view all movies

		LOGGER.info("Start");

		List<Movie> movies = movieService.getMovieListAdmin();
		LOGGER.debug("Movies={}", movies);

		LOGGER.info("End");

	}

	private static void getMovieListCustomerTest() {
		// MCUC002 - Customer - view all movies that are active and not in future

		LOGGER.info("Start");

		Set<Movie> movies = movieService.getMovieListCustomer();
		LOGGER.debug("Movies={}", movies);

		LOGGER.info("End");

	}

	private static void getMovieTest() {
		// MCUC003 - Admin - get movie to edit details

		LOGGER.info("Start");

		Movie movie = movieService.getMovie(4);
		LOGGER.debug("Movie={}", movie);

		LOGGER.info("End");

	}

	private static void modifyMovieTest() throws ParseException {
		// MCUC003 - Admin - edit movie details

		LOGGER.info("Start");

		Movie movie = new Movie(1, "Inception", (float) 8.8, true, DateUtil.convertToDate("15/03/2017"),
				"Science Fiction", "https://www.imdb.com/video/vi2959588889?playlistId=tt1375666&ref_=tt_ov_vi");
		movieService.modifyMovie(movie);
		Movie savedMovie = movieService.getMovie(1);
		LOGGER.debug("Saved Movie={}", savedMovie);

		LOGGER.info("End");

	}

}
