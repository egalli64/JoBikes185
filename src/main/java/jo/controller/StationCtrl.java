/**
 * (c) 2019 ACME Inc.
 * Controller for Stations
 * @author Ariam 
 * @author Arturo
 */
package jo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.CityRepository;
import jo.model.StationRepository;
import jo.model.entities.City;
import jo.model.entities.Station;

@Controller
public class StationCtrl {
	private static final Logger logger = LoggerFactory.getLogger(StationCtrl.class);

	@Autowired
	private StationRepository repo;
	
	@Autowired
	private CityRepository repoCity;

	@GetMapping("/stations")
	public String showStations(Model model) {
		return orderStations("ID", model);
	}

	@GetMapping("/stations/order")
	public String orderStations( //
			@RequestParam String by, //
			Model model) {
		logger.debug("Order stations by " + by);

		List<Station> stations;
		switch (by) {
		case "Name":
			stations = repo.findAllByOrderByName();
			break;
		case "Id":
			stations = repo.findAllByOrderById();
			break;
		default:
			stations = repo.findAllByOrderById();
			break;
		}
		model.addAttribute("stations", stations);
		model.addAttribute("cities", repoCity.findAll());
		return "stations";
	}
	
	@GetMapping("/stations/save")
	public String saveStation( //
			@RequestParam(name = "id") Integer id, //
			@RequestParam(name = "name") String name, //
			@RequestParam(name = "cityId") Integer cityId, //
			Model model) {
		Station station = new Station(id, name, cityId);
		logger.debug("Save station " + station);
		repo.save(station);

		model.addAttribute("stations", repo.findAll());
		model.addAttribute("cities", repoCity.findAll());
		return "stations";
	}

	@GetMapping("/stations/delete")
	public String deleteRegion( //
			@RequestParam int id, //
			Model model) {
		logger.debug("Delete station  " + id);
		repo.deleteById(id);

		model.addAttribute("stations", repo.findAll());
		return "stations";
	}
	
	
	@GetMapping("/stations/city")
	public String stationsByCity( //
			@RequestParam int id, //
			Model model) {
		Optional<City> city = repoCity.findById(id);
		logger.debug("Stations by city " + id);

		if (city.isPresent()) {
			City cur = city.get();
			List<Station> stations = repo.findByCityId(id);
			model.addAttribute("stations", stations);
			model.addAttribute("city", cur);
		} else {
			model.addAttribute("city", new City(id, ""));
		}

		return "stationsByCity";
	}
}
