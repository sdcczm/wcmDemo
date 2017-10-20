package com.sdczzm.wcmDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface userRepository extends JpaRepository<User,Long>{
	
	public User findByUsername(String username);

}
