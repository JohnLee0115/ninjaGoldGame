package com.john.ninjaGoldGame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	public String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	
	public double goldCount = 0;
	
	public ArrayList<String> activities = new ArrayList<String>();

	@GetMapping("/")
	public String form(HttpSession session) {
		session.setAttribute("gold", this.goldCount);
		session.setAttribute("activities", this.activities);
		
		return "NinjaGoldGame.jsp";
	}
	
	@RequestMapping(value="/gold", method=RequestMethod.POST)
	public String submit(HttpSession session,
		@RequestParam(value="hidden") String hidden
		) {
		
		if (hidden.equals("farm")) {
			double farmRandom = Math.floor(Math.random() * (20 - 10 + 1) + 10);
			this.goldCount += farmRandom;
			activities.add("You entered a farm and earned" + String.valueOf(farmRandom) + "gold (" + timeStamp + ")");
	
		} else if (hidden.equals("cave")) {
			double caveRandom = Math.floor(Math.random() * (10 - 5 + 1) + 5);
			this.goldCount += caveRandom;
			activities.add("You entered a cave and earned" + String.valueOf(caveRandom) + "gold (" + timeStamp + ")");
			
		} else if (hidden.equals("house")) {
			double houseRandom = Math.floor(Math.random() * (5 - 2 + 1) + 2);
			this.goldCount += houseRandom;
			activities.add("You entered a house and earned" + String.valueOf(houseRandom) + "gold (" + timeStamp + ")");
			
		} else if (hidden.equals("quest")) {
			double earnTake = Math.floor(Math.random() * 2);
			double questRandom = Math.floor(Math.random() * (50 - 0 + 1) + 0);
			if (earnTake > 0) {
				this.goldCount += questRandom;
				activities.add("You completed a quest and earned" + String.valueOf(questRandom) + "gold (" + timeStamp + ")");
				
			} else {
				this.goldCount -= questRandom;
				activities.add("You completed a quest and lost" + String.valueOf(questRandom) + "gold. Ouch. (" + timeStamp + ")");
			}
			
		}
		
		return "redirect:/";
	}
	
}
