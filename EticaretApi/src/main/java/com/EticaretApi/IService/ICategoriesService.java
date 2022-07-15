package com.EticaretApi.IService;

import java.util.List;

import com.EticaretApi.Entities.Categories;

public interface ICategoriesService {

	public String Add(Categories data);
	
	public List<Categories> GetAll();
	
	public Categories GetById(int Id);
	
	public String Delete(int Id);
	
	public String Update(Categories data);
}
