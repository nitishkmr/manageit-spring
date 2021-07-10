package com.spring.manageit.exceptions;

public class ProjectIdExceptionResponse {
	
	// To get a JSON like error response (like @Valid gives) instead of default error
	
	private String projectIdentifier;

	public ProjectIdExceptionResponse(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
}
