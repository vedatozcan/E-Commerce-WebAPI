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

import com.EticaretApi.Entities.TemporaryBaskets;
import com.EticaretApi.Service.TemporaryBasketService;


@RestController
@RequestMapping("api")
public class TemporaryController {

	@Autowired
	private TemporaryBasketService service;	
	
	@GetMapping("/Temporary/Get/{Id}")
	public List<TemporaryBaskets> GetAll(@PathVariable int Id){	
		return service.GetAll(Id);		
	}
	
	@PostMapping("/Temporary")
	public String Create(@RequestBody TemporaryBaskets data)
	{			
		return service.Add(data);		
	}
	
	@PutMapping("/Temporary")
	public String Update(int BasketId,boolean Status)
	{			
		System.out.println(BasketId);
		System.out.println(Status);
		return service.Update(BasketId,Status);		
	}
	
	@DeleteMapping("/Temporary/{Id}")
	public String Delete(@PathVariable int Id)
	{			
		return service.Delete(Id);		
	}
	
	
}
