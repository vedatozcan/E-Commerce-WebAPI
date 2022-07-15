package com.EticaretApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EticaretApi.Entities.Categories;
import com.EticaretApi.Service.CategoriesService;


@RestController
@RequestMapping("api")
public class CategoriesController {
	@Autowired
	private CategoriesService service;	

	@GetMapping("/Categories")
	public List<Categories> GetAll(){	
		return service.GetAll();		
	}
	
	@PostMapping("/Categories")
	public String Create(@RequestBody Categories data)
	{			
		return service.Add(data);		
	}
	
	@PutMapping("/Categories")
	public String Update(@RequestBody Categories data)
	{			
		return service.Update(data);		
	}
	
	@DeleteMapping("/Categories/{Id}")
	public String Delete(@PathVariable int Id)
	{			
		return service.Delete(Id);		
	}

}
