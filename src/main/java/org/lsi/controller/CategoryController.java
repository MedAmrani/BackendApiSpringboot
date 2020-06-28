package org.lsi.controller;

import java.util.List;

import org.lsi.model.Category;
import org.lsi.service.ICategoryMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class CategoryController {
	
	@Autowired
	private ICategoryMetier categoryMetier;
	
	 @RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<Category> getAll() {
		 return categoryMetier.getAll();
	}

	 @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public Category get(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		 return categoryMetier.get(id);
	}

	 @RequestMapping(value = "/categories", method = RequestMethod.POST)
	public Category create(@RequestBody Category res) {
		 return categoryMetier.create(res);
	}

	 @RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
	public Category update(@PathVariable("id") Long id,@RequestBody  Category res) {
		 return categoryMetier.update(id, res);
	}

	 @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		categoryMetier.delete(id);
		
	}

}
