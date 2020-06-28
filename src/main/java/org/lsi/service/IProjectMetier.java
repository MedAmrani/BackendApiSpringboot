package org.lsi.service;

import java.util.List;

import org.lsi.model.Project;


public interface IProjectMetier {
	
	public List<Project> getAll();
	public Project get(Long id);
	public Project create(Project d);
	public Project update(Long id, Project d);
	public void delete(Long id);
	

}
