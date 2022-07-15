package com.EticaretApi.IService;

import java.util.List;

import com.EticaretApi.Entities.TemporaryBaskets;

public interface ITemporaryBasketService {
	
	public String Add(TemporaryBaskets data);
	
	public List<TemporaryBaskets> GetAll(int CookieId);
		
	public TemporaryBaskets GetById(int Id);
	
	public String Delete(int Id);
	
	public String Update(int BasketId,boolean Status);
}
