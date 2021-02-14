package com.cognizant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService service;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		service = (CountryService) context.getBean(CountryService.class);
		System.out.println("***************** All the Countries**************");
		testGetAllCountries();
		System.out.println("***************** Get the All The Country based on IN************");
		getAllCountriesTest();
		System.out.println("***************** Add New Countries**************");
	    testAddCountry();
	    System.out.println("***************** update Countries**************");
	    testUpdateCountry();
	    System.out.println("*******************Name containing OU *************************");
		getByNameContaining();
		System.out.println("*******************Name sorted *************************");
		sorted();
		System.out.println("*******************Name like Z *************************");
		getByNameLike();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = service.getAllCountries();
		LOGGER.debug("countries={}", countries);
		countries.forEach(System.out::println);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() {
		try {
			LOGGER.info("Start");
			Country country;
			country = service.findCountryByCode("IN");
			System.out.println("IN Country data is:" + country);
			LOGGER.debug("Country:{}", country);
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			LOGGER.debug(e.getMessage());
		}

	}
	
	public static void testAddCountry()
	{
		try {
		LOGGER.info("Start");
		Country c1=new Country("AX","Åland Islands");
		Country c2=new Country("AF","Åfghanistan");
		service.addCountry(c1);
		service.addCountry(c2);
		Country country;
		country = service.findCountryByCode("AX");
		System.out.println("AX Country data is:" + country);
		country = service.findCountryByCode("AF");
		System.out.println("AF Country data is:" + country);
		LOGGER.info("Added Successfull");
		LOGGER.debug("Country:{}", c1);
		LOGGER.info("END");
		}
		catch (CountryNotFoundException e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage());
		}
	}

	public static void testUpdateCountry()
	{
		try {
			LOGGER.info("start");
			Country p=service.getCountry("AX");
			p.setName("Åfghanistan");
			service.updateCountry(p);
			LOGGER.debug("Countrys={}",p);
			Country country;
			country = service.findCountryByCode("AX");
			System.out.println("AX Country data is:" + country);
			LOGGER.info("updated Successfull");
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			LOGGER.debug(e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	private static void deletePerson() {
		
		LOGGER.info("start");
		service.deleteCountry("AF");
		LOGGER.debug("persons={}","AF person deleted");
		LOGGER.info("deleted Successfull");
		LOGGER.info("End");
	
}
	private static void getByNameContaining() {
		LOGGER.info("start");
		List<Country> plist=service.getPersonNameContaining("ou");
		LOGGER.debug("persons={}",plist);
		plist.forEach(System.out::println);
		LOGGER.info("End");
	}
	
	private static void sorted() {
		LOGGER.info("start");
		List<Country> plist=service.displayNameSortedOrder();
		LOGGER.debug("persons={}",plist);
		plist.forEach(System.out::println);
		LOGGER.info("End");	
	}

	private static void getByNameLike() {
		LOGGER.info("start");
		List<Country> plist=service.getPersonNameStartWithA("Z");
		LOGGER.debug("Country={}",plist);
		plist.forEach(System.out::println);
		LOGGER.info("End");
		
		
	}
}