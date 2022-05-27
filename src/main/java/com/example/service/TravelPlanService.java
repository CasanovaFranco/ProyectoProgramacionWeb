package com.example.service;
import java.util.List;

import com.example.entities.TravelPlan;
import com.example.repository.TravelPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TravelPlanService implements CrudService<TravelPlan,Long> {
	@Autowired
	private TravelPlanRepository travelplanRepository;

	@Override
	public JpaRepository<TravelPlan, Long> getJpaRepository() {
		return travelplanRepository;
	}
	public List<TravelPlan> listAll() {
		return travelplanRepository.listAll();
	}
	
	public double total(List<TravelPlan> list) {
		double total=0;
		for (TravelPlan travelPlan : list) {
			
			total+=travelPlan.getUnitPrice();
			
		}
		
		return total ;
	}
	
}
