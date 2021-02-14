package com.cognizant.truyum;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	@Query(value = "SELECT * FROM menuitems WHERE menu_item_active=true and menu_item_date_of_launch<= CURDATE()", nativeQuery = true)
	public Set<MenuItem> findByActiveAndDateOfLaunch();
}
