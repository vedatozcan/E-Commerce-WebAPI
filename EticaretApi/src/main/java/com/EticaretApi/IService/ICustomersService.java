package com.EticaretApi.IService;

import java.util.List;

import com.EticaretApi.Entities.Customers;

public interface ICustomersService {

    public String Add(Customers data);
	
	public List<Customers> GetAll();
	
	public Customers GetById(int Id);
	
	public String Delete(int Id);
	
	public String Update(Customers data);
	
	public Customers Login(String Email,String Sifre);
	
}
