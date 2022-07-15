package com.EticaretApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	@Column(name = "Name",length = 50)
	public String Name;
	public int Submenu;
	public boolean Status;
	@Column(name = "Keyword",length = 160)
	public String Keyword; // Ürün ile ilgili Anahtar kelimeleri belirlediğimiz Property'dir. Buraya girilen anahtar kelimeler Aslında
	// Google arama motoruna yazılan kelimelerdir. i5 Bilgisayar,Bilgisayar,Hiko Bilgisayar.
	@Column(name = "Description",length = 160)
	public String Description; // O Ürün'ün kısa açılmasıdır.
	
	// Kategori Tablosunu çektiğimiz anda her kategorinin ürünleri gelsin
	
	// @OneToMany // Tek'e Çok ilişki => Her Bir Kategorinin 1'den fazla Ürünü vardır.
	// @JoinColumn(name = "CategoriesId")
	// public List<Products> Products;

}
