package com.example.service;


import java.util.List;

import com.example.entities.Card;
import com.example.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService implements CrudService<Card,Long> {
	@Autowired
	private CardRepository cardRepository;

	@Override
	public JpaRepository<Card, Long> getJpaRepository() {
		return cardRepository;
	}
	public List<Card> listAll() {
		return cardRepository.listAll();
	}
	
	
	public Card findByCvv(String cvv) {
		return cardRepository.findByCvv(cvv);	
	}
}
