package com.EticaretApi.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import com.EticaretApi.Entities.Orders;

public interface OrdersReporitories extends JpaRepository<Orders,Integer>{

	
	//@Query(value = "Select * From orders as o join ordercustomers as c on c.orders_id = o.id join orderdetails as d on o.id = c.orders_id join customers as cu on cu.id = o.customers_id" ,nativeQuery = true)
	//public Orders OrdersCustomersDetails(@Param("OrderId") int OrderId);

	//@Query(value = "Select * From orders as o join ordercustomers as c on c.orders_id = o.id join orderdetails as d on o.id = c.orders_id join customers as cu on cu.id = o.customers_id" ,nativeQuery = true)
	//public List<Orders> GetAllOrdersCustomersDetails();
	
}
