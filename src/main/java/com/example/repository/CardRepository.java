package com.example.repository;


import java.util.List;

import com.example.entities.Card;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface CardRepository extends JpaRepository <Card,Long> {
	

@Query(value="Select * from cards", nativeQuery=true)
List<Card>listAll();

@Query(value="Select * from cards where cvv=?1", nativeQuery=true)
Card findByCvv(String cvv );

}







