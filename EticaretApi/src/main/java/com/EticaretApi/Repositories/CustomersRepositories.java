package com.EticaretApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EticaretApi.Entities.Customers;

public interface CustomersRepositories extends JpaRepository<Customers,Integer> {

	// Tüm verileri Listeleme FindAll();
	// Tek Satır Listeleme FindById();
	// Veri Ekleme Save();
	// Veri Güncelleme Save();
	// Veri Silme Delete;
	
	// Eğer Repository içerisindeki Metot'ların dışında Sorgulama yapılacak ise Bu interface içerisine Yeni Soyut Metot Tanımlanır.
	
	@Query(value ="Select * From customers Where Email = :Email and Passwords = :Passwords LIMIT 1",nativeQuery = true)
	public Customers Login(@Param("Email") String Email,@Param("Passwords") String Passwords);
	
	@Query(value = "Select * From customers where Email = :Email or Phone = :Phone LIMIT 1",nativeQuery = true)
	public Customers CustomersControl(@Param("Email") String Email,@Param("Phone") String Phone);
	
}
