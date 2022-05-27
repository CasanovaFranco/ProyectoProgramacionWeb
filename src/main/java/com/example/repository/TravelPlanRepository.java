package com.example.repository;
import java.util.List;

import com.example.entities.TravelPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPlanRepository extends JpaRepository <TravelPlan,Long> {
	
	@Query(value="Select * from travelplans", nativeQuery=true)
	List<TravelPlan>listAll();

}