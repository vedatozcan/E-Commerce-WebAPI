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

import com.EticaretApi.Entities.Customers;
import com.EticaretApi.Service.CustomersService;

@RestController
@RequestMapping("api")
public class CustomersController {

	@Autowired
	private CustomersService service;	

	@GetMapping("/customers")
	public List<Customers> GetAll(){	
		return service.GetAll();		
	}
	
	@PostMapping("/customers")
	public String Create(@RequestBody Customers customers)
	{			
		return service.Add(customers);		
	}
	
	@PutMapping("/customers")
	public String Update(@RequestBody Customers customers)
	{			
		return service.Update(customers);		
	}
	
	@DeleteMapping("/customers/{Id}")
	public String Delete(@PathVariable int Id)
	{			
		return service.Delete(Id);		
	}
	
	@PostMapping("/customers/Login")
	public Customers Login(String Email,String Password)
	{			
		return service.Login(Email,Password);		
	}
	
	
	
	
	
	
}
