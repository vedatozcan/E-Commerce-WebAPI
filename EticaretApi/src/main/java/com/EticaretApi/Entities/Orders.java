package com.EticaretApi.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Orders {

	@Id
	public int Id;
	
	@Column(name = "OrderStatus",length = 30)
	public String OrderStatus; // Teslim Edildi,Kargoya verildi,Bekleniyor.

	@Column(name = "CargoNumber",length = 30)
	public String CargoNumber;
	public float TotalPrice;
	public float TotalDiscountPrice;
	public int KDV;
	
	@Temporal(TemporalType.DATE)
	public Date OrderDate;
	
	public int CustomersId;
	public String PaymentType; // Kredi Kartı,Havale ile Ödeme, Kapıda Ödeme
	
	@OneToMany(cascade = CascadeType.ALL) // Üst Tabloda hangi işlem olduysa, bende de aynı olacaktır.
	@JoinColumn(name = "OrdersId", insertable = true)
	public List<OrderCustomers> OrderCustomers;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrdersId", insertable = true)
	public List<OrderDetails> OrderDetails;
	
	@ManyToOne
	@JoinColumn(name = "CustomersId", insertable = false, updatable = false)
	public Customers Customers;
}
