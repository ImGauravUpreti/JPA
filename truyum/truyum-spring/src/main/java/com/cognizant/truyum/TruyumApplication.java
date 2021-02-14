package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class TruyumApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) throws ParseException {
		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(TruyumApplication.class, args);
		menuItemService = context.getBean(MenuItemService.class);
		getMenuItemListAdminTest();
		getMenuItemListCustomerTest();
		getMenuItemTest();
		modifyMenuItemTest();

	}

	private static void getMenuItemListAdminTest() {

		LOGGER.info("Start");

		List<MenuItem> menuItems = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Menu Items={}", menuItems);

		LOGGER.info("End");

	}

	private static void getMenuItemListCustomerTest() {

		LOGGER.info("Start");

		Set<MenuItem> menuItems = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Menu Items={}", menuItems);

		LOGGER.info("End");

	}

	private static void getMenuItemTest() {

		LOGGER.info("Start");

		MenuItem menuItem = menuItemService.getMenuItem(4);
		LOGGER.debug("Menu Item={}", menuItem);

		LOGGER.info("End");

	}

	private static void modifyMenuItemTest() throws ParseException {

		LOGGER.info("Start");

		MenuItem menuItem = new MenuItem(1, "Cheese Sandwich", (float) 99.0, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		menuItemService.modifyMenuItem(menuItem);
		MenuItem savedMenuItem = menuItemService.getMenuItem(1);
		LOGGER.debug("Saved Menu Item={}", savedMenuItem);

		LOGGER.info("End");

	}

}
