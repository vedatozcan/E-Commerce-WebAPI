package com.EticaretApi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EticaretApi.Entities.Orders;
import com.EticaretApi.Entities.TemporaryBaskets;

public interface TemporaryBasketRepositories  extends JpaRepository<TemporaryBaskets,Integer> {

	@Query(value = "Select * From TemporaryBaskets Where cookie_basket_id = :CookieId LIMIT 1",nativeQuery = true)
	public TemporaryBaskets BasketCookieControl(@Param("CookieId") int CookieId);
	
	@Query(value = "Select * From orders Where Id = :CookieId LIMIT 1",nativeQuery = true)
	public Orders OrderCookieControl(@Param("CookieId") int CookieId);
	
	@Query(value = "Select * From TemporaryBaskets Where cookie_basket_id = :CookieId",nativeQuery = true)
	public List<TemporaryBaskets> GetAllList(@Param("CookieId") int CookieId);
	
	// i5 Bilgisayar Hikmet Kullanıcısı tarafından Daha önce sepete eklenmiş ise adeti Yükseltilsin.
	@Query(value = "Select * From temporarybaskets where Id =:BasketId",nativeQuery = true)
	public TemporaryBaskets SepetAdetKontrol(@Param("BasketId")int BasketId);
	
}
