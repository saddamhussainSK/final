package com.spring;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
@RequestMapping("/preducts")
public class productcontroller {
	@Autowired
	private productrepo pr;
	@PostMapping()
	public Product createcproducts(@RequestBody  Product p) {
		return pr.save(p);
	}
	@GetMapping("/{pageNo}/{pageSize}")
	public Page<Product> getallProducts(@PathVariable int pageNo,@PathVariable int pageSize){
		Pageable p=PageRequest.of(pageNo, pageSize);
		return pr.findAll(p);
		
	}
	@GetMapping("/sort")
	public  Iterable<Product> getallsort(@RequestParam String field1){
		return pr.findAll(Sort.by(Direction.ASC,field1));
		
	}
	@GetMapping("/{id}")
	public Optional<Product> getbyid(@PathVariable Long id) {
		return pr.findById(id);
		
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product p) {
		Product pro=pr.findById(id).get();
		pro.setFoodproducts(p.getFoodproducts());
		pro.setElectricappliances(p.getElectricappliances());
		return pr.save(p);
		
	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		pr.deleteById(id);
	}
}
