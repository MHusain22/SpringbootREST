package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	public Product findByProductname(String name);
	//this is equal to select * from products where productname=name
	
	public List<Product> findByOrderByPriceAsc();
	
	public List<Product> findByOrderByPriceDesc();
	
	public List<Product> findByProductidAndProductname(int id,String name);
}
