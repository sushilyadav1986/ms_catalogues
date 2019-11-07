package com.hcl.ms.cat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ms.cat.entity.Catalogue;

/**Create repository 
 * Execute Queries in DB
 * @author SushilY
 *
 */
@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
	

}
