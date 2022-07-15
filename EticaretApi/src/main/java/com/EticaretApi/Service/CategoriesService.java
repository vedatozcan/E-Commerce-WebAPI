package com.EticaretApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EticaretApi.Entities.Categories;
import com.EticaretApi.IService.ICategoriesService;
import com.EticaretApi.Repositories.CategoriesRepotories;

@Service
public class CategoriesService implements ICategoriesService{

	@Autowired
	private CategoriesRepotories repo;
	
	@Override
	public String Add(Categories data) {	
		try
		{
			repo.save(data);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e) 
		{
			return e.getMessage();
		}
	}

	@Override
	public List<Categories> GetAll() {
		return repo.findAll();
	}

	@Override
	public Categories GetById(int Id) {
		return repo.findById(Id).orElse(null);
	}

	@Override
	public String Delete(int Id) {
		try
		{
			repo.deleteById(Id);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e) 
		{
			return e.getMessage();
		}
	}
	@Override
	public String Update(Categories data) {		
		try
		{
			repo.save(data);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e) 
		{
			return e.getMessage();
		}
	}

}
