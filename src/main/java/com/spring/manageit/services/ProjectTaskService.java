package com.spring.manageit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.manageit.domain.Backlog;
import com.spring.manageit.domain.Project;
import com.spring.manageit.domain.ProjectTask;
import com.spring.manageit.exceptions.ProjectNotFoundException;
import com.spring.manageit.repositories.BacklogRepository;
import com.spring.manageit.repositories.ProjectRepository;
import com.spring.manageit.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		
		try {
			// PTs to be added to a specific project, project != null and BL exists
			Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
			
			// set the BL to PT
			projectTask.setBacklog(backlog);
			
			// the project sequence should be like: IDPRO-1 -> IDPRO-2 -> ... even if any IDPRO is deleted, then also the sequence should be retained
			Integer backlogSequence = backlog.getPTSequence();
			
			// update the BL Sequence
			backlogSequence++;
			backlog.setPTSequence(backlogSequence);
			
			// Add sequence to projectTask
			projectTask.setProjectSequence(projectIdentifier + "-" + backlogSequence);
			projectTask.setProjectIdentifier(projectIdentifier);
			
			// Initial priority when priority is null
			if(projectTask.getPriority() == null || projectTask.getPriority() == 0) {
				projectTask.setPriority(3);
			}
			
			// Initial status when status is null
			if(projectTask.getStatus() == null || projectTask.getStatus() == "") {
				projectTask.setStatus("TO_DO");
			}
			return projectTaskRepository.save(projectTask);
			
		} catch (Exception e) {
			throw new ProjectNotFoundException("Project not Found");
		}
		
	}

	public Iterable <ProjectTask> findBacklogById(String backlog_id) {
		
		Project project = projectRepository.findByProjectIdentifier(backlog_id);
		if(project == null) {
			throw new ProjectNotFoundException("Project with ID: '" + backlog_id + "' does not exist");
		}
		return projectTaskRepository.findByProjectIdentifierOrderByPriority(backlog_id);
	}
	
	public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id) {
		
		// the backlog should exist
		Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
		if(backlog == null) {
			throw new ProjectNotFoundException("Project with ID: '" + backlog_id + "' does not exist");
		}
		
		// the task should exist
		ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);
		if(projectTask == null) {
			throw new ProjectNotFoundException("Project Task: '" + pt_id + "' not found");
		}
		
		// the backlog/task should correspond to the right project
		if(!projectTask.getProjectIdentifier().equals(backlog_id)) {
			throw new ProjectNotFoundException("Project Task '"+pt_id+"' does not exist in the project: '"+backlog_id+"'");
		}
		
		return projectTask;
	}
}
