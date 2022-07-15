package com.EticaretApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EticaretApi.Entities.Orders;
import com.EticaretApi.Service.OrderService;

@RestController
@RequestMapping("api")
public class OrderController {

	@Autowired
	private OrderService service;	
	
	@GetMapping("/Orders/FullData")
	public List<Orders> GetAll(){	
		return service.GetAll();		
	}
	
	@GetMapping("/Orders")
	public List<Orders> CustomersGetAll(int Id){	
		return service.CustomersGetAll(Id);		
	}
	
	@GetMapping("/Orders/{Id}")
	public Orders GetById(@PathVariable int Id){	
		return service.GetById(Id);		
	}
	
	@PostMapping("/Orders")
	public String Create(@RequestBody Orders data)
	{			
		return service.Add(data);		
	}
	
	@PutMapping("/Orders")
	public String Update(Orders data)
	{			
		return service.Update(data);		
	}
	
}
