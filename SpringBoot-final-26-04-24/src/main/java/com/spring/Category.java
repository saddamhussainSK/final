package com.spring;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String food;
	private String appliances;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> product=new ArrayList<>();
	public Category() {
		
	}
	public Category(Long id) {
		super();
		this.id=id;
	}
	public Category(String food,String appliances) {
		super();
		this.food=food;
		this.appliances=appliances;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getAppliances() {
		return appliances;
	}
	public void setAppliances(String appliances) {
		this.appliances = appliances;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
}

