package com.EticaretApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EticaretApi.Entities.Customers;
import com.EticaretApi.IService.ICustomersService;
import com.EticaretApi.Repositories.CustomersRepositories;

@Service
public class CustomersService implements ICustomersService {

	@Autowired
	private CustomersRepositories repo;
	
	@Override
	public String Add(Customers data) {
		try
		{
			if(repo.CustomersControl(data.Email,data.Phone) == null) 
			{
				repo.save(data);
				return "İşlem Başarlı Bir Şekilde Gerçekleşti";
			}
			else {
				return "Girdiğiniz Email adresine yada Telefon Numarasına sahip bir kullanıcı vardır.";
			}		
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
	@Override
	public List<Customers> GetAll() {
		return repo.findAll();
	}
	@Override
	public Customers GetById(int Id) {
		return repo.findById(Id).orElse(null);
	}
	@Override
	public String Delete(int Id) {
		try
		{
			repo.deleteById(Id);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
	@Override
	public String Update(Customers data) {
		try
		{
			repo.save(data);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

	@Override
	public Customers Login(String Email, String Sifre) {
		return repo.Login(Email, Sifre);
	}

}
