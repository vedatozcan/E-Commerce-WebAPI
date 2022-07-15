package com.EticaretApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EticaretApi.Entities.OrderCustomers;

public interface OrderCustomersRepositories extends JpaRepository<OrderCustomers,Integer> {

}
