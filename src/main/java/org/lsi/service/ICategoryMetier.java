package org.lsi.service;

import java.util.List;

import org.lsi.model.Category;


public interface ICategoryMetier {
	
	public List<Category> getAll();
	public Category get(Long id);
	public Category create(Category c);
	public void delete(Long id);
	public Category update(Long id, Category res);

}
