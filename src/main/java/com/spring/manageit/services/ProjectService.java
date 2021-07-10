package com.spring.manageit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.manageit.domain.Backlog;
import com.spring.manageit.domain.Project;
import com.spring.manageit.domain.User;
import com.spring.manageit.exceptions.ProjectIdException;
import com.spring.manageit.repositories.BacklogRepository;
import com.spring.manageit.repositories.ProjectRepository;
import com.spring.manageit.repositories.UserRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Project saveOrUpdateProject(Project project, String username) {
		String projectIdentifier = project.getProjectIdentifier().toUpperCase();
		try {
			
			User user = userRepository.findByUsername(username);
			
			project.setUser(user);
			project.setProjectLeader(username);
			
			project.setProjectIdentifier(projectIdentifier);
			
			if(project.getId() == null) {
				Backlog backlog = new Backlog();
				project.setBacklog(backlog);
	            backlog.setProject(project);
				backlog.setProjectIdentifier(projectIdentifier);
			}else {
//				System.out.println("\n+++++"+projectIdentifier);
//				System.out.println("\n+++++"+backlogRepository.findByProjectIdentifier(projectIdentifier));
				project.setBacklog(backlogRepository.findByProjectIdentifier(projectIdentifier));
			}
			
			return projectRepository.save(project);			
		} catch (Exception e) {
			throw new ProjectIdException("Project ID '" + projectIdentifier+"' already exist");
		}	
	}
	
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null) {
			throw new ProjectIdException("Project ID '" + projectId.toUpperCase()+"' does not exist");
		}
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null) {
			throw new ProjectIdException("Cannot delete project with ID '"+projectId+"'. This project does not exists.");
		}
		projectRepository.delete(project);
	}
}
