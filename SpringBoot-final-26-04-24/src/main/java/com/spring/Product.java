package com.spring;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String foodproducts;
	private String electricappliances;
	
	public Product() {
		
	}
	public Product(Long id) {
		super();
		this.id=id;
	}
	public Product(String foodproducts,String electricappliances) {
		super();
		this.foodproducts=foodproducts;
		this.electricappliances=electricappliances;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFoodproducts() {
		return foodproducts;
	}
	public void setFoodproducts(String foodproducts) {
		this.foodproducts = foodproducts;
	}
	public String getElectricappliances() {
		return electricappliances;
	}
	public void setElectricappliances(String electricappliances) {
		this.electricappliances = electricappliances;
	}
	
}

