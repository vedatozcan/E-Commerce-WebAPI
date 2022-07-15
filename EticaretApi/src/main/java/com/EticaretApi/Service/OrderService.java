package com.EticaretApi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EticaretApi.Entities.Orders;
import com.EticaretApi.Entities.Products;
import com.EticaretApi.IService.IOrderService;
import com.EticaretApi.Repositories.OrdersReporitories;
import com.EticaretApi.Repositories.ProductsRepotories;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrdersReporitories repo;
	
	@Autowired
	private ProductsRepotories ProductsRepo;
	
	@Override
	public String Add(Orders data) {
		try
		{
			repo.saveAll(List.of(data));			
			
			data.OrderDetails.forEach((e)-> {				
			  Products products = ProductsRepo.findById(e.ProductsId).orElse(null); // Satın alınan ürünü depoda buluyor.
			  products.Stock -= e.Piece; // Satın alınan ürün'ün adeti, Depodaki Ürün'ün adetinden düşürülüyor.
			  ProductsRepo.save(products);				
			});
				
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

	@Override
	public List<Orders> CustomersGetAll(int customerId) {
		
		List<Orders> Datalar = new ArrayList<>();	
		for (Orders orders : repo.findAll()) 
		{
			if(orders.Customers.Id == customerId) 
			{
				Datalar.add(orders);
			}
		}	
		return Datalar;
	}
	
	@Override
	public List<Orders> GetAll() {		
		return repo.findAll();
	}

	@Override
	public Orders GetById(int Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id).orElse(null);
	}

	@Override
	public String Update(Orders data) {
		try
		{
			repo.saveAll(List.of(data));
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

}
