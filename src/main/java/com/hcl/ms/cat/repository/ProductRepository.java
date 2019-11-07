package com.hcl.ms.cat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ms.cat.entity.Product;

/**Create repository 
 * Execute Queries in DB
 * @author SushilY
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/**
	 * @param catalogId
	 * @return
	 */
	List<Product> findByCatalogueCatIdOrderByNameAscPriceAsc(long catalogId);
	
	Page<Product> findAll(Pageable pageable);
		

}
