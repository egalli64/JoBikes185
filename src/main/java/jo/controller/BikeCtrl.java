/**
 * (c) 2019 ACME Inc.
 * Controller for Bikes
 * 
 * 	@author Federico
 */
package jo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.BikeRepository;
import jo.model.BikeUserRepository;
import jo.model.CityRepository;
import jo.model.StationRepository;
import jo.model.entities.Bike;

@Controller
public class BikeCtrl {
	private static final Logger logger = LoggerFactory.getLogger(BikeCtrl.class);

	@Autowired
	BikeRepository repo;

	@Autowired
	CityRepository repoCity;

	@Autowired
	StationRepository repoStation;
	
	@Autowired
	BikeUserRepository repoBikeUser;

	@GetMapping("/bikes")
	public String showBikeOrderedbyId(Model model) {
		logger.debug("Get all bikes");
		model.addAttribute("bikes", repo.findAllByOrderById());
		return orderBikes("Id", model);
	}

	@GetMapping("/bikes/order")
	public String orderBikes( //
			@RequestParam String by, //
			Model model) {
		logger.debug("Order bikes by " + by);

		List<Bike> bikes;
		switch (by) {
		case "Id":
			bikes = repo.findAllByOrderById();
			break;
		case "CityId":
			bikes = repo.findAllByOrderByCityId();
			break;
		case "Type":
			bikes = repo.findAllByOrderByType();
			break;
		default:
			bikes = repo.findAllByOrderById();
			break;
		}
		model.addAttribute("bikes", bikes);
		model.addAttribute("cities", repoCity.findAll());
		model.addAttribute("stations", repoStation.findAll());
		model.addAttribute("bikeusers", repoBikeUser.findAll());
		return "bikes";
	}

	@GetMapping("/bikes/save")
	public String saveBike( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "cityId") Integer cityId, //
			@RequestParam(name = "stationId") Integer stationId, //
			@RequestParam(name = "bikeUserId") Integer bikeUserId,
			@RequestParam(name = "type") String type, //
			Model model) {	
		Bike bike = new Bike(id, cityId, stationId, bikeUserId, type);
		logger.debug("Save bike " + bike);
		repo.save(bike);

		model.addAttribute("bikes", repo.findAll());
		model.addAttribute("cities", repoCity.findAll());
		model.addAttribute("stations", repoStation.findAll());
		model.addAttribute("bikeusers", repoBikeUser.findAll());
		return "bikes";
	}

	@GetMapping("/bikes/create")
	public String saveBike( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "cityId") Integer cityId, //
			@RequestParam(name = "stationId") Integer stationId, //
			@RequestParam(name = "type") String type, //
			Model model) {	
		return saveBike(id, cityId, stationId, 0, type, model);
	}
	
	@GetMapping("/bikes/delete")
	public String deleteBike( //
			@RequestParam Integer id, //
			Model model) {
		logger.debug("Delete bike " + id);
		repo.deleteById(id);

		model.addAttribute("bikes", repo.findAll());
		model.addAttribute("cities", repoCity.findAll());
		model.addAttribute("stations", repoStation.findAll());
		model.addAttribute("bikeusers", repoBikeUser.findAll());
		return "bikes";
	}
}