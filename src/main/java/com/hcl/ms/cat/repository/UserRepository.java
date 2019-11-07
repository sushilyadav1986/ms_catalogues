package com.hcl.ms.cat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ms.cat.entity.User;

/**Create repository 
 * Execute DB opreation Queries in DB
 * @author SushilY
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Custom Query
	 * @param userId
	 * @return User
	 * 
	 */
	@Query("SELECT u FROM User u WHERE u._id = :userId")
	User findUserById(long userId);
}
