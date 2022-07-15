package com.EticaretApi.IService;

import java.util.List;

import com.EticaretApi.Entities.Products;

public interface IProductsService {

	public String Add(Products data);
	
	public List<Products> GetAll();
	
	public Products GetById(int Id);
	
	public String Delete(int Id);
	
	public String Update(Products data);
}
