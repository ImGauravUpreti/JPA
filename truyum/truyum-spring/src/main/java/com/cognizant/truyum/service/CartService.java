package com.cognizant.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

}
