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

import com.EticaretApi.Entities.Products;
import com.EticaretApi.Service.ProductsService;

@RestController
@RequestMapping("api")
public class ProductsController {
	
	@Autowired
	private ProductsService service;	

	@GetMapping("/Products")
	public List<Products> GetAll(){	
		return service.GetAll();		
	}
	
	@PostMapping("/Products")
	public String Create(@RequestBody Products data)
	{			
		return service.Add(data);		
	}
	
	@PutMapping("/Products")
	public String Update(@RequestBody Products data)
	{			
		return service.Update(data);		
	}
	
	@DeleteMapping("/Products/{Id}")
	public String Delete(@PathVariable int Id)
	{			
		return service.Delete(Id);		
	}
	
}
