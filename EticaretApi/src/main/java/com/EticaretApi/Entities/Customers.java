package com.EticaretApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "customers")
@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Id;
	@Column(name = "NameSurname",length = 100)
	public String NameSurname;	
	@Column(name = "Email",length = 50)
	public String Email;	
	@Column(name = "Passwords",length = 20)
	public String Passwords;
	@Column(name = "Phone",length = 15)
	public String Phone;
	public boolean Status;
	
	
}
