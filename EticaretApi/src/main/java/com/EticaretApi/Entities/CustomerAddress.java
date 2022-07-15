package com.EticaretApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "customeraddress")
@Entity
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	public int CustomersId;
	@Column(name = "Addressname",length = 50)
	public String AddressName;
	@Column(name = "City",length = 50)
	public String City;
	@Column(name = "Distrinct",length = 50)
	public String Distrinct;
	@Column(name = "Fulladdress",length = 350)
	public String FullAddress;
	
}
