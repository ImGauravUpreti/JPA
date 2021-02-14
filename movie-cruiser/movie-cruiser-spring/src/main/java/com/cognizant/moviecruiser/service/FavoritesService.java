package com.cognizant.moviecruiser.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.FavoritesRepository;

@Service
public class FavoritesService {
	@Autowired
	private FavoritesRepository favoritesRepository;

}
