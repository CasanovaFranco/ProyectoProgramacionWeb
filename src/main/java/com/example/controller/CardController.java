package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.entities.Card;
import com.example.entities.TravelPlan;
import com.example.service.CardService;
import com.example.service.TravelPlanService;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/card")
public class CardController  {

	@Autowired
	private CardService cardService;
	@Autowired
	private TravelPlanService travelPlanService;

	@GetMapping //
    public String list(Model model) {
		List<Card>list= new ArrayList<>();
		List<TravelPlan> listTravelPlans=new ArrayList<>();
		double total;
		try {
			list=cardService.listAll();	
			listTravelPlans=travelPlanService.listAll();
			total=travelPlanService.total(listTravelPlans);
			for (Card card : list) {
				int numDigitos=card.getNumber().length();
				
				card.setNumber(card.getNumber().substring(numDigitos-4,numDigitos));
			}
			
			System.out.println("List: " + list.size());
			System.out.println("List: " + listTravelPlans.size());
			model.addAttribute("cards", list);		
			model.addAttribute("travelPlans", listTravelPlans);
			model.addAttribute("total", total);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
			
		}
		 return "record/record";
    }
	
	
	@GetMapping("insert") //
    public String insertGo(Model model) {
		Card card= new Card(); 

		model.addAttribute("newCard", card);
		model.addAttribute("aux", "insert");
		model.addAttribute("textButton", "Añadir");
		
        return "record/record-insert";
    }

	@GetMapping("insert/new") //
    public String insertNew(@ModelAttribute ("newCard") Card card) {
		
		try {
			cardService.create(card);
			return "redirect:/card";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return null;
		
        
    }
	@GetMapping("delete/{id}") //
	public String delete (@PathVariable("id") Long id) {
		
		try {
			if (cardService.existsById(id)) {
				cardService.deleteById(id);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return "redirect:/card";
	}
	
	
	
	@GetMapping("update/{id}") //
	public String updateGo (Model model,@PathVariable("id") Long id) {
		
		try {
			if (cardService.existsById(id)) {
				model.addAttribute("newCard", cardService.findById(id));	
				model.addAttribute("aux", "update");	
				model.addAttribute("textButton", "Modificar");
				return "record/record-insert";		
			}
		} catch (Exception e) {
			e.getMessage();
		}		
		return null;
	}
	
	@GetMapping("update/new") //
    public String updateNew(@ModelAttribute ("newCard") Card card) {
		
		try {
			Long id=cardService.findByCvv(card.getCvv()).getId();
			card.setId(id);
			cardService.update(card);
			return "redirect:/card";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
    }
	
	
}
