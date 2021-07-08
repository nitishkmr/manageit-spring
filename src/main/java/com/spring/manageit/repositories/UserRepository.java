package com.spring.manageit.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.spring.manageit.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}
