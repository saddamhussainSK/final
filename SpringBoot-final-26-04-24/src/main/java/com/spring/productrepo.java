package com.spring;


import org.springframework.data.jpa.repository.JpaRepository;

public interface productrepo extends JpaRepository<Product,Long>{
	
}
