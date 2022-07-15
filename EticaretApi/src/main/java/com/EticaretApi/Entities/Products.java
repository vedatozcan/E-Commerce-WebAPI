package com.EticaretApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "products")
@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	@Column(name = "Name",length = 150)
	public String Name;
	@Column(name = "Images",length = 30)
	public String Images;
	public String Explanation;
	public float Price;
	public float DiscountPrice;
	public int Stock;
	public boolean Status;
	public int CategoriesId;
	@Column(name = "Keyword",length = 160)
	public String Keyword;
	@Column(name = "Description",length = 160)
	public String Description;
	
}
