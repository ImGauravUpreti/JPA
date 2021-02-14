package com.cognizant.moviecruiser;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Favorites;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Map<Integer, Integer>> {

}
