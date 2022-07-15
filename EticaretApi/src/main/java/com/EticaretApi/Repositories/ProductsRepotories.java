package com.EticaretApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EticaretApi.Entities.Products;

public interface ProductsRepotories extends JpaRepository<Products,Integer> {

	
}
