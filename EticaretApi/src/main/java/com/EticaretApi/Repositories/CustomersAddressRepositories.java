package com.EticaretApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EticaretApi.Entities.CustomerAddress;

public interface CustomersAddressRepositories extends JpaRepository<CustomerAddress,Integer>{

	
}
