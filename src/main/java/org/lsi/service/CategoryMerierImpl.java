package org.lsi.service;

import java.util.ArrayList;
import java.util.List;

import org.lsi.model.Category;
import org.lsi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryMerierImpl implements ICategoryMetier {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		List<Category> category = new ArrayList<>();
		categoryRepository.findAll().forEach(category::add);;
		return category;
	}

	@Override
	public Category get(Long id) {
		
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category create(Category c){
		// TODO Auto-generated method stub
		return categoryRepository.save(c);
	}
	
	@Override
	public Category update(Long id, Category res) {
		res.setId(id);
		return categoryRepository.save(res);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
		
	}

	

}
