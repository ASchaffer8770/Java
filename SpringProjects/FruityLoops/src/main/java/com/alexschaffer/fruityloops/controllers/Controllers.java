package com.alexschaffer.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexschaffer.fruityloops.models.Item;

@Controller
public class Controllers {

	// ... imports (Use shift+ctrl+O or shift+cmd+O to import as you code)
	@Controller
	public class ItemController {
	    
	    @RequestMapping("/")
	    public String fruitLoop(Model model) {
	        
	        ArrayList<Item> fruits = new ArrayList<Item>();
	        fruits.add(new Item("Kiwi", 1.5));
	        fruits.add(new Item("Mango", 2.0));
	        fruits.add(new Item("Goji Berries", 4.0));
	        fruits.add(new Item("Guava", .75));
	        
	        // Add fruits your view model here
	        fruits.add(new Item("Raspberries", 4.5));
	        fruits.add(new Item("Blackberries", 3.75));
	        model.addAttribute("fruits" , fruits);
	        
	        for(Item eachFruit : fruits) {
	        	System.out.println(eachFruit);
	        }
	        
	        return "fruityLoops.jsp";
	    }
	}


}
