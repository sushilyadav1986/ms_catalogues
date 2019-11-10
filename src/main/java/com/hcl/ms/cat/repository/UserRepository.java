package com.hcl.ms.cat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ms.cat.entity.User;

/**Create repository 
 * Execute DB operation Queries in DB
 *  Use Native/Custom function from Repository
 * @author SushilY
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Create Custom Query
	 * Fetch User Details belongs to User id
	 * 
	 */
	@Query("SELECT u FROM User u WHERE u._id = :userId")
	User findUserById(long userId);
}
