package com.cognizant.ormlearn.CountryRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	@Query("SELECT e FROM Country e  WHERE name LIKE ?1%")
	List<Country> findByNameContaining(String name);

	@Query("SELECT e FROM Country e order by e.name desc")
	List<Country> findByName();
}
