/**
 * (c) 2019 ACME Inc.
 * Controller for Cities
 * 
 * @author Susanna
 * @author Selena
 */
package jo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.CityRepository;
import jo.model.entities.City;

@Controller
public class CityCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CityCtrl.class);

	@Autowired
	CityRepository repo;

	

	@GetMapping("/cities")
	public String showCitiesOrderedbyId(Model model) {
		logger.debug("Get all cities");
		model.addAttribute("cities", repo.findAllByOrderById());
		return "cities";
	}
	
	@GetMapping("/cities/order")
	public String showCities(Model model) {
		logger.debug("Get all cities");
		model.addAttribute("cities", repo.findAllByOrderByName());
		return "cities";
	}

	@GetMapping("/cities/save")
	public String saveCity( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "name") String name, //
			Model model) {
		City city = new City(id, name);
		logger.debug("Save city " + city);
		repo.save(city);

		model.addAttribute("cities", repo.findAll());
		return "cities";
	}

	@GetMapping("/cities/delete")
	public String deleteCity( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Delete city " + id);
		repo.deleteById(id);

		model.addAttribute("cities", repo.findAll());
		return "cities";
	}
}
