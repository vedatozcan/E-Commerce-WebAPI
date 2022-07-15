package com.EticaretApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	public int OrdersId;
	
	@Column(name = "Name",length = 150)
	public String Name;
	@Column(name = "Images",length = 30)
	public String Images;
	public float Price;
	public float DiscountPrice;
	public int Piece;
	public int ProductsId;
	
	
}
