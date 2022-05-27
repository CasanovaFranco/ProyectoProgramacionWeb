package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	private String cvv;
	private String owner;
	private String expiration;
	
	public Card() {
		super();
	}

	public Card(Long id, String number, String cvv, String owner, String expiration) {
		super();
		this.id = id;
		this.number = number;
		this.cvv = cvv;
		this.owner = owner;
		this.expiration = expiration;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getExpiration() {
		return expiration;
	}


	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

}
	