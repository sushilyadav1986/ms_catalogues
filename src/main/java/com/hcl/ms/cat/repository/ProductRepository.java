package com.hcl.ms.cat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ms.cat.entity.Product;

/**Create repository 
 * Execute Queries in DB
 * Use Native/Custom function from Repository
 * 
 * @author SushilY
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/**
	 * Fetch All Product List By User id
	 * List should be Sorted By Name And Price in Ascending Order 
	 * @param catalogId 
	 * @return List
	 */
	List<Product> findByCatalogueCatIdOrderByNameAscPriceAsc(long catalogId);
	
	/**
	 * Fetch All Product in Paging 
	 * Each Product should be Belongs to Page 
	 */
	Page<Product> findAll(Pageable pageable);
		

}
