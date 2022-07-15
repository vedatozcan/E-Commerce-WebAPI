package com.EticaretApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EticaretApi.Entities.Categories;

public interface CategoriesRepotories extends JpaRepository<Categories,Integer> {

	
}
