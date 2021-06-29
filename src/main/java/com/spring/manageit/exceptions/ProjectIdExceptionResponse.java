package com.spring.manageit.exceptions;

public class ProjectIdExceptionResponse {
	
	// To get a JSON like error response (like @Valid gives) instead of default error
	
	private String projectIdentifierString;

	public ProjectIdExceptionResponse(String projectIdentifierString) {
		this.projectIdentifierString = projectIdentifierString;
	}

	public String getProjectIdentifierString() {
		return projectIdentifierString;
	}

	public void setProjectIdentifierString(String projectIdentifierString) {
		this.projectIdentifierString = projectIdentifierString;
	}
	
}
