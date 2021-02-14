package com.cognizant.ormlearn.service.CountryService;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.CountryRepository.CountryRepository;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> p = countryRepository.findById(countryCode);
		if (!p.isPresent()) {
			throw new CountryNotFoundException(countryCode + " not found");
		} else {
			return p.get();
		}
	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(Country p) throws CountryNotFoundException {
		Country pp = countryRepository.getOne(p.getCode());
		if (pp == null)
			throw new CountryNotFoundException(p.getCode() + " not found to update");
		else
			pp.setCode(p.getCode());
		pp.setName(p.getName());
		countryRepository.save(pp);
	}

	public Country getCountry(String countryCode) throws CountryNotFoundException {
		// TODO Auto-generated method stub

		Optional<Country> p = countryRepository.findById(countryCode);
		if (!p.isPresent()) {
			throw new CountryNotFoundException(countryCode + " not found");
		} else {
			return p.get();
		}
	}

	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}

	@Transactional
	public List<Country> getPersonNameContaining(String name) {
		// TODO Auto-generated method stub
		return countryRepository.findByNameContaining(name);
	}

	public List<Country> displayNameSortedOrder() {
		return countryRepository.findByName();
	}

	public List<Country> getPersonNameStartWithA(String string) {
		// TODO Auto-generated method stub
		return countryRepository.findByNameContaining(string);
	}
	
	
}
