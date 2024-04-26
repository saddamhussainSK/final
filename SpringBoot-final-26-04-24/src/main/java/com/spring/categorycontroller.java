package com.spring;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class categorycontroller {
	@Autowired
	private categoryrepo cr;
	@PostMapping()
	public Category createcats(@RequestBody Category c) {
		return cr.save(c);
		
	}
	@GetMapping("/{pageNo}/{pageSize}")
	public Page<Category> getallcats(@PathVariable int pageNo,@PathVariable int pageSize){
		Pageable p=PageRequest.of(pageNo, pageSize);
		return cr.findAll(p);
		
	}
	@GetMapping("/sort")
	public  Iterable<Category> getallsort(@RequestParam String field1){
		return cr.findAll(Sort.by(Direction.ASC,field1));
		
	}
	@GetMapping("/{id}")
	public Optional<Category> getbyid(@PathVariable Long id) {
		return cr.findById(id);
		
	}
	@PutMapping("/{id}")
	public Category updatecat(@PathVariable Long id,@RequestBody Category c) {
		Category cat=cr.findById(id).get();
		cat.setFood(c.getFood());
		cat.setAppliances(c.getAppliances());
		return cr.save(c);
		
	}
	@DeleteMapping("/{id}")
	public void deletecat(@PathVariable Long id) {
		cr.deleteById(id);
	}
}
