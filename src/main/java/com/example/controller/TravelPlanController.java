package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.entities.TravelPlan;
import com.example.service.TravelPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/travelplan")
public class TravelPlanController {

	@Autowired
	private TravelPlanService travelPlanService;

	
	@GetMapping //
	 public String list(Model model) {
			List<TravelPlan>list= new ArrayList<>();
			try {
				list=travelPlanService.listAll();		
				
				
				System.out.println("List: " + list.size());
				
				model.addAttribute("travelPlans", list);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			
				
			}
			 return "record/record";
	    }
	
	@GetMapping("delete/{id}") //
	public String deleteTravelPlan (@PathVariable("id") Long id) {
		
		try {
			if (travelPlanService.existsById(id)) {
				travelPlanService.deleteById(id);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "redirect:/card";
	}

}
