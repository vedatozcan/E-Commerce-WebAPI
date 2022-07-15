package com.EticaretApi.Service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EticaretApi.Entities.Products;
import com.EticaretApi.Entities.TemporaryBaskets;
import com.EticaretApi.IService.ITemporaryBasketService;
import com.EticaretApi.Repositories.ProductsRepotories;
import com.EticaretApi.Repositories.TemporaryBasketRepositories;

@Service
public class TemporaryBasketService implements ITemporaryBasketService{

	
	@Autowired
	private TemporaryBasketRepositories repo;
	
	@Autowired
	private ProductsRepotories ProductsRepo;

	

	@Override
	public String Add(TemporaryBaskets data) {
	 int BasketCookieId = 0;
	 Random rnd = new Random();
	 // Üretilen Sayı Temporary Basket  ve Order Tablosunda var ise Tekrar Sayı üretecek. Yok ise üretilen ile devam edilecek.
	 do
	 {
		 BasketCookieId = rnd.nextInt(9000000); // 0  ile 9 Milyon arasında bir sayı üretecektir.
	 }
	 while((repo.BasketCookieControl(BasketCookieId) != null) || (repo.OrderCookieControl(BasketCookieId) != null));
	 
	 data.CookieBasketId = BasketCookieId; // Üretileni Veritabanına göndermek üzere Property'e atamasını gerçekleştiriyoruz. 
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
	
    public List<TemporaryBaskets> GetAll(int CookieId) {
		return repo.GetAllList(CookieId);
	}

	@Override
	public TemporaryBaskets GetById(int Id) {
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
	public String Update(int BasketId,boolean Status) {
		try
		{
			TemporaryBaskets DataKontrol = repo.SepetAdetKontrol(BasketId);	
			if(DataKontrol != null) // Gönderilen Ürün Sepette Varmı ? 
			{	
				Products BulunanUrun  = ProductsRepo.findById(DataKontrol.ProductsId).orElse(null);		
				if(Status) // Arttırma / TRUE
				{		
					if(BulunanUrun.Stock > DataKontrol.Piece ) // Ürün'ün Depo'daki Stoğuna bakılıp Kontrol ediliyor.
					{
						DataKontrol.Piece++; // Depodaki Ürünün Adeti, Alınmak istenen Adet'ten yüksek ise 1 Arttır.
					}
					else
					{
						return "Maximum " + BulunanUrun.Stock + " Adet Sipariş Verebilirsiniz";
					}
				}
				else  // Eksiltme / False
				{
					if( 1 < DataKontrol.Piece)  // ALınmak istenilen ürün Adeti 1'den yüksek ise adet'i azalt.
					{
						DataKontrol.Piece--;
					}
					else 
					{
						return "Minimum 1 Adet Ürün Satın Alabilirsiniz";
					}			
				}		
			}	
			repo.save(DataKontrol);
			return "İşlem Başarlı Bir Şekilde Gerçekleşti";
		}
		catch(Exception e){
			return e.getMessage();
		}
	}
	
}
