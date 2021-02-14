package com.cognizant.ormlearn.Repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByCodeAndDateBetween(String code,Date open,Date close);
	List<Stock> findByCloseGreaterThan(double price);
	List<Stock> findFirst3ByOrderByVolumeDesc();
	List<Stock> findFirst3ByCodeOrderByCloseAsc(String name);
}
