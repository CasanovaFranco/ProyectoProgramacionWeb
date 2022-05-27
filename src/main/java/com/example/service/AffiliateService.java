package com.example.service;


import com.example.entities.Affiliate;
import com.example.repository.AffiliateRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AffiliateService implements CrudService<Affiliate,Long> {

	private AffiliateRepository affiliateRepository;

	@Override
	public JpaRepository<Affiliate, Long> getJpaRepository() {
		return affiliateRepository;
	}
	
}
