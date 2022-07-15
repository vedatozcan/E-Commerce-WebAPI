package com.EticaretApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EticaretApi.Entities.Products;
import com.EticaretApi.IService.IProductsService;
import com.EticaretApi.Repositories.ProductsRepotories;

@Service
public class ProductsService implements IProductsService {

	@Autowired
    private ProductsRepotories repo;
	
	@Override
	public String Add(Products data) {
		try
		{
			repo.save(data);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

	@Override
	public List<Products> GetAll() {
		return repo.findAll();
	}

	@Override
	public Products GetById(int Id) {
		return repo.findById(Id).orElse(null);
	}

	@Override
	public String Delete(int Id) {
		try
		{
			repo.deleteById(Id);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

	@Override
	public String Update(Products data) {
		try
		{
			repo.save(data);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

	
	
	
}
