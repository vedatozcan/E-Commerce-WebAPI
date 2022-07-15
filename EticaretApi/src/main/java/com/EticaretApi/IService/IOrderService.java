package com.EticaretApi.IService;

import java.util.List;

import com.EticaretApi.Entities.Orders;

public interface IOrderService {

    public String Add(Orders data);
	
	public List<Orders> GetAll();
	
	public List<Orders> CustomersGetAll(int customerId);
		
	public Orders GetById(int Id);
	
	public String Update(Orders data);		
	
}
