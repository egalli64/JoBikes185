/*
 * (c) 2019 ACME Inc.
 * Controller for Cities
 * 
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
import jo.model.entities.Region;

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
	
	@GetMapping("/cities/select")
	public String selectCity( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Select city " + id);

		model.addAttribute("city", repo.findById(id));
		return "city";
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

