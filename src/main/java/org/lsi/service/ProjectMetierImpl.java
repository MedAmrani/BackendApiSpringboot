package org.lsi.service;

import java.util.ArrayList;
import java.util.List;

import org.lsi.model.Project;
import org.lsi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectMetierImpl implements IProjectMetier{
	
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public List<Project> getAll() {
		List<Project> projets = new ArrayList<>();
		projectRepository.findAll().forEach(projets::add);
		return projets;
	}

	@Override
	public Project get(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public Project create(Project res) {
		return projectRepository.save(res);
	}

	@Override
	public Project update(Long id, Project res) {
		res.setId(id);
		return projectRepository.save(res);
	}

	@Override
	public void delete(Long id) {
		projectRepository.deleteById(id);
		
	}
	

}
