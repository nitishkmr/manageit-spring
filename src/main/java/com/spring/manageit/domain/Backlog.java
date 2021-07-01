package com.spring.manageit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Backlog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer PTSequence = 0;
	private String projectIdentifier;
	
	// OneToOne with the project

	// OneToMany with projectTasks
	
	
	public Backlog() {}

	public Long getId() {
		return id;
	}
	
}
