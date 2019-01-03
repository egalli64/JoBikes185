package jo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jo.model.CountryRepository;
import jo.model.entities.Country;
import jo.model.entities.Region;

@Controller
public class CountryCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CountryCtrl.class);

	@Autowired
	CountryRepository repo;

	@GetMapping("/countries")
	public String allCountries(Model model) {
		logger.debug("All countries");
		model.addAttribute("countries", repo.findAll());
		return "countries";
	}

	@GetMapping("/countries/select")
	public String selectCountry( //
			@RequestParam String id, //
			Model model) {
		Optional<Country> country = repo.findById(id.toUpperCase());
		logger.debug(String.format("Country with id %s is %s", id, country));

		model.addAttribute("country", country.orElse(new Country(id, "Unknown", 0)));
		return "country";
	}

	@GetMapping("/countries/region")
	public String countriesByRegion( //
			@RequestParam int id, //
			@RequestParam String name, //
			Model model) {
		Region region = new Region(id, name);
		logger.debug("Countries by region " + region);

		model.addAttribute("countries", repo.findByRegId(id));
		model.addAttribute("region", region);
		return "countriesByRegion";
	}

	@GetMapping("/countries/save")
	public String saveCountry( //
			@RequestParam String cid, //
			@RequestParam String name, //
			@RequestParam int rid, //
			Model model) {
		Country country = new Country(cid.toUpperCase(), name, rid);
		logger.debug("Save country " + country);

		repo.save(country);

		model.addAttribute("countries", repo.findAll());
		return "countries";
	}

	@GetMapping("/countries/delete")
	public String deleteCountry( //
			@RequestParam String cid, //
			@RequestParam int rid, //
			Model model) {
		logger.debug("Delete country " + cid);

		repo.deleteById(cid);

		model.addAttribute("countries", repo.findAll());
		return "countries";
	}
}
