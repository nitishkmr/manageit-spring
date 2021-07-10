package com.spring.manageit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.manageit.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	Project findByProjectIdentifier(String projectId);
	
	@Override
	Iterable<Project> findAll();
	
	Iterable<Project> findAllByProjectLeader(String username);
	
}
