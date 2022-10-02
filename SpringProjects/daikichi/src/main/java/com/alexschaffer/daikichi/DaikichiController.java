package com.alexschaffer.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an oppertunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/{cityName}")
	public String travel(
			@PathVariable(value= "cityName", required = false) String cityName
			) {
		return "Congrats! Soon you will travel to " + cityName + "!";
	}
	
	@RequestMapping("/lotto/{lottoNum}")
	public String lotto(
			@PathVariable(value = "lottoNum", required = false) Integer lottoNum
			) {
		if(lottoNum % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		if (lottoNum % 2 != 0) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		} else {
			return "Not working";
		}
	}
}
