package com.example.repository;

import com.example.entities.Affiliate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AffiliateRepository extends JpaRepository <Affiliate,Long> {

		
}
