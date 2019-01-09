/*
 * (c) 2019 ACME Inc.
 * Controller for Cities
 * 
 * @author Susanna
 */
package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jo.model.CityRepository;

@Controller
public class CityCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CityCtrl.class);

	@Autowired
	CityRepository repo;

	@GetMapping("/cities")
	public String showCities(Model model) {
		logger.debug("Get all cities");
		model.addAttribute("cities", repo.findAll());
		return "cities";
	}
}
